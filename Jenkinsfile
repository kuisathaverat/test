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
      steps {
        checkout([$class: 'GitSCM', 
          branches: [[name: "${env?.CHANGE_ID ? env?.GIT_COMMIT : env?.BRANCH_NAME}"]],
          doGenerateSubmoduleConfigurations: false, 
          extensions: [
            [$class: 'ChangelogToBranch', 
              options: [compareRemote: "${env?.GIT_URL}", 
              compareTarget: "${env?.CHANGE_ID ? env?.CHANGE_TARGET : 'master'}"]]], 
          submoduleCfg: [], 
          userRemoteConfigs: [
            [credentialsId: 'UserAndToken', 
            url: "${env?.GIT_URL}"]]])
        error "Please do not continue"
      }
    }
  }
}
