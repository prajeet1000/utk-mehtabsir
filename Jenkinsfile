pipeline {
    agent any
  tools {
    maven "3.6.3"
  }
    stages {
        stage('clean & install ') {
            steps {
                bat 'mvn clean install'
            }
        }
      stage('Packages') {
            steps {
                bat 'mvn package'
            }
        }
    }
}
