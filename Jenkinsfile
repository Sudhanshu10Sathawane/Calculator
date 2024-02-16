pipeline {
    agent any

    environment {
        // Define the Docker image name
        DOCKER_IMAGE_NAME = 'calculator-java-image:latest'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from your version control system
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                // Use Maven to build the Java application
                script {
                    def mvnHome = tool 'Maven'
                    sh "${mvnHome}/bin/mvn clean install"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build the Docker image using the provided Dockerfile
                script {
                    docker.build DOCKER_IMAGE_NAME, '-f Dockerfile .'
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                // Run the Docker container
                script {
                    docker.withRun("-p 8080:8080 -d --name calculator-container ${DOCKER_IMAGE_NAME}") {
                        // Command to run inside the container, replace with your actual command
                        sh 'java -jar target/Calculator-0.0.1-SNAPSHOT.jar'
                    }
                }
            }
        }
    }

    post {
        always {
            // Clean up - remove the Docker container after execution
            script {
                docker.image(DOCKER_IMAGE_NAME).remove()
            }
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
