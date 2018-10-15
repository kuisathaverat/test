pipeline {
  agent { label 'linux||master' }
    triggers {
      cron('0 0 * * 1-5')
      githubPush()
    }

  stages {
    stage("test") {
      agent { label 'linux||master' }
      steps {
        sh 'export'
        checkout scm
        sh 'export'
        script{
          build(job: "dummy")
          ansiColor('xterm') {
            build(job: "dummy")
          }
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
