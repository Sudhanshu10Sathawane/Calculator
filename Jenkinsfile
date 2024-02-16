pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo "Building"
                script {
                         sh "${MAVEN_HOME}/bin/mvn clean install"
                }
            }
        }
        stage('Test') {
            steps {
                echo "Testing"
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying"
            }
        }
    }
}

