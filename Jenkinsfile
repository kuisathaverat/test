stage 'git'


def fsSh( String cmd ) {
  sh cmd + " || true"
}


node {
    sh 'export'
    stage 'One'
    checkout 'https://github.com/kuisathaverat/test.git'
//    sh 'git status'
//    sh 'GIT_COMMIT=$(git rev-parse HEAD)'
//    sh 'GIT_BRANCH=$(git symbolic-ref -q --short HEAD)'
    stage 'Two'
   sh 'git checkout ${BRANCH_NAME}'
//    fsSh 'git branch -t'
    stage 'Three'
    fsSh 'git remote -v'
    stage 'Four'
    fsSh 'git branch -v'
    fsSh 'git branch -a'
}
