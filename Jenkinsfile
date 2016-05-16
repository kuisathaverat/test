stage 'git'


def fsSh( String cmd ) {
  sh cmd + " || true"
}


node {
    sh 'ls -la'
    checkout scm
    sh 'git status'
    sh 'git checkout master'
//    sh 'git pull origin master'
//    sh 'export'
//    sh 'git reset --hard'
    fsSh 'git remote -v'
    fsSh 'git branch -v'
    fsSh 'git branch -a'
}
