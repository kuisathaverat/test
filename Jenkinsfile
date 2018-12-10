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
  stages {
    stage('Dummy'){
      agent { label 'master' }
      options { skipDefaultCheckout() }
      steps {
        checkout([$class: 'GitSCM', 
          branches: [[name: "${env?.CHANGE_ID ? env?.GIT_COMMIT : env?.BRANCH_NAME}"]],
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