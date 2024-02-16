pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'sudhanshu1020/calculator-java-image:latest'
        GITHUB_REPO_URL = 'https://github.com/Sudhanshu10Sathawane/Calculator.git'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the GitHub repository
                    git branch: 'master', url: "${GITHUB_REPO_URL}"
                }
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
                script{
                    docker.withRegistry('', 'DockerCredentialId') {
                        docker.image(DOCKER_IMAGE_NAME).push('latest')
                    }
                 }
            }
        }

//    stage('Run Ansible Playbook') {
//             steps {
//                 script {
//                     ansiblePlaybook(
//                         playbook: 'deploy.yml',
//                         inventory: 'inventory'
//                      )
//                 }
//             }
//         }

    }
}