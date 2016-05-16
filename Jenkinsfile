stage 'git'


def fsSh( String cmd ) {
  sh cmd + " || true"
}


node {
    sh 'ls -la'
    checkout scm
    sh 'echo GIT_BRANCH : ${GIT_BRANCH}'
    sh 'git checkout -'
    sh 'export'
//    sh 'git reset --hard'
    fsSh 'git remote -v'
    fsSh 'git branch -v'
    fsSh 'git branch -a'
}
