pipeline {
    agent any
 
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
