pipeline {
  agent { label 'linux||master' }
    triggers {
      cron('0 0 * * 1-5')
      githubPush()
    }
    options {
      timeout(time: 1, unit: 'HOURS') 
      buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '2', daysToKeepStr: '30'))
      timestamps()
      preserveStashes()
      ansiColor('xterm')
    }

  stages {
    stage("test") {
      agent { label 'linux||master' }
      steps {
        checkout scm
        sh 'export'
        script{
          echoColor(text: 'RED', colorfg: 'red')
          echoColor(text: 'RED over BLACK', colorfg: 'red', colorbg: 'black')
          echoColor(text: 'GREEN', colorfg: 'green')
          echoColor(text: 'YELLOW', colorfg: 'yellow')
          build(job: "dummy")
          build(job: "dummy")
        }
      }
      post {
        always{
          updateGithubCommitStatus(
          repoUrl: "${GIT_URL}",
          commitSha: "${GIT_COMMIT}",
          message: 'Build result.'
          )
        }
      }
    }
  }
}
