pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'sudhanshu1020/calculator-java-image:latest'
        DOCKER_CREDENTIALS_ID ='15d20253-245f-4ed2-9004-bc03d648c001'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the GitHub repository
                    checkout scm
                }
            }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    docker.build(DOCKER_IMAGE_NAME, '.')
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                 script {
                        // Push Docker image to the registry
                           docker.withRegistry('', DOCKER_CREDENTIALS_ID) {
                           docker.image(DOCKER_IMAGE_NAME).push('latest')
                 }
            }
        }

   stage('Run Ansible Playbook') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'deploy.yml',
                        inventory: 'inventory'
                     )
                }
            }
        }
    }
}