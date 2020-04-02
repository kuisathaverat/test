pipeline {
  agent { label 'master' }
  environment {
    BASE_DIR = "src/github.com/elastic/${env.REPO}"
    JOB_GIT_CREDENTIALS = "f6c7695a-671e-4f4f-a331-acdce44ff9ba"
  }
  stages {
    stage('checkout') {
      steps {
        deleteDir()
        setEnvVar("REAL_GIT_COMMIT", getGitCommitSha())
        setEnvVar("OLD_GIT_COMMIT", "${env.OLD_GIT_COMMIT}")
        sh(label: 'Env vars before', script: 'export|grep GIT_')
        gitCheckout(basedir: "${BASE_DIR}",
          branch: "master",
          repo: "file:///repo",
          credentialsId: "${JOB_GIT_CREDENTIALS}"
        )
        dir("${BASE_DIR}"){
          sh(label: 'Env vars after', script: 'export|grep GIT_')
          whenFalse("${env.REAL_GIT_COMMIT}" == "${env.GIT_BASE_COMMIT}"){
            error("The GIT_BASE_COMMIT value is incorrect, we expect ${env.GIT_COMMIT} and it is ${env.GIT_BASE_COMMIT}")
          }
          whenFalse("${env.GIT_COMMIT}" == "1111"){
            error("The GIT_COMMIT value is incorrect, we expect 1111 and it is ${env.GIT_COMMIT}")
          }
        }
      }
    }
  }
}
