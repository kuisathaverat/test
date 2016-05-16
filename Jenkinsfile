stage 'git'


def fsSh( String cmd ) {
  sh cmd + " || true"
}


node {
        sh 'ls -la'
        fsSh 'git remote -v'
        fsSh 'git branch'
        fsSh 'git branch -a'
}
