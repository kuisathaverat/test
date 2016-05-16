stage 'git'


def fsSh( String cmd ) {
  sh cmd + " || true"
}


node {
    sh 'ls -la'
    checkout scm
    sh 'export'
    sh 'git reset --hard'
    fsSh 'git remote -v'
    fsSh 'git branch'
    fsSh 'git branch -a'
}
