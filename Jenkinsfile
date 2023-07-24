pipeline {
    agent any
  tools {
    maven '3.9.2'
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
