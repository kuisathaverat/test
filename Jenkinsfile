stage 'git'


def fsSh( String cmd ) {
  sh cmd + " || true"
}


node {
    sh 'ls -la'
    checkout scm
    echo env.GIT_BRANCH
    sh 'git status'
//    sh 'git checkout master'
//    fsSh 'git branch -t'

    fsSh 'git remote -v'
    fsSh 'git branch -v'
    fsSh 'git branch -a'
}
