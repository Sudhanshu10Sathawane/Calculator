pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'maven'
        PATH = "${env.MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Check out the code from your version control system
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Build the Maven project
                script {
//                     sh "${env.MAVEN_HOME}/bin/mvn clean install"
                       sh "mvn clean install"
                }
            }
        }

        // ... other stages ...
    }

    post {
        success {
            // Actions to be taken if the build is successful
            echo 'Build successful!'
        }
        failure {
            // Actions to be taken if the build fails
            echo 'Build failed!'
        }
    }
}