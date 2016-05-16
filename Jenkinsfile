stage 'git'


def fsSh( String cmd ) {
  sh cmd + " || true"
}


node {
    sh 'export'
    
    checkout scm
//    sh 'git status'
//    sh 'GIT_COMMIT=$(git rev-parse HEAD)'
//    sh 'GIT_BRANCH=$(git symbolic-ref -q --short HEAD)'

   sh 'git checkout ${BRANCH_NAME}'
//    fsSh 'git branch -t'

    fsSh 'git remote -v'
    fsSh 'git branch -v'
    fsSh 'git branch -a'
}
