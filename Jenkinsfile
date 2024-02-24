pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'sudhanshu1020/calculator-java-image:latest'
        DOCKER_CREDENTIALS_ID =credentials('cred')
        ANSIBLE_VERSION = 'ansible'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the GitHub repository
                    checkout scm
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
        stage('Login to Dockerhub'){
            steps{
                sh 'echo $DOCKER_CREDENTIALS_ID_PSW | docker login -u $DOCKER_CREDENTIALS_ID_USR --password-stdin'
            }
        }
//         stage('Push Docker Images') {
//             steps {
//                 script {
//                     // Push Docker image to the registry
//                     def dockerImage = docker.image(DOCKER_IMAGE_NAME)
//
//                     // Check if the Docker image is available
//                     if (!dockerImage) {
//                         error 'Docker image not found.'
//                     }
//
//                     // Push Docker image to the registry
//                     def pushResult = docker.withRegistry('', DOCKER_CREDENTIALS_ID) {
//                         dockerImage.push('latest')
//                     }
//
        stage('Push Image'){
             steps{
                 sh 'docker push ${DOCKER_IMAGE_NAME}'
             }
        }
        stage('Run Ansible Playbook') {
            steps {
                script {
                       ansiblePlaybook installation: 'ansible', playbook: 'deploy.yml', vaultTmpPath: ''
                }
            }
        }
    }
}
