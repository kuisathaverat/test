@Library('apm@current') _

pipeline {
  agent any
  options {
    timeout(time: 1, unit: 'HOURS')
    buildDiscarder(logRotator(numToKeepStr: '20', artifactNumToKeepStr: '20', daysToKeepStr: '30'))
    timestamps()
    ansiColor('xterm')
    disableResume()
    durabilityHint('PERFORMANCE_OPTIMIZED')
  }
  triggers {
    issueCommentTrigger('.*Jenkins test this.*')
  }
  environment {
    PIPELINE_LOG_LEVEL = 'DEBUG'
  }
  stages {
    stage('Dummy'){
      agent { label 'master' }
      options { skipDefaultCheckout() }
      steps {
        checkout([$class: 'GitSCM', 
          branches: [[name: "${env?.BRANCH_NAME}"]],
          doGenerateSubmoduleConfigurations: false, 
          extensions: [
            [$class: 'ChangelogToBranch', 
              options: [compareRemote: "origin",
              compareTarget: "master"]]], 
          submoduleCfg: [], 
          userRemoteConfigs: [
            [credentialsId: 'UserAndToken', 
            url: "${env?.GIT_URL}"]]])
      }
    }
  }
}
