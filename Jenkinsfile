pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'sudhanshu1020/calculator-java-image:latest'
        DOCKER_CREDENTIALS_ID =credentials('cred')
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
//                     // Check the result of the push operation
//                     if (pushResult != null && pushResult.getLastState().exitCode != 0) {
//                         error "Failed to push Docker image. Exit code: ${pushResult.getLastState().exitCode}"
//                     } else {
//                         echo "Docker image pushed successfully."
//                     }
//                 }
//             }
//         }
        stage('Push Image'){
             steps{
                 sh 'docker push ${DOCKER_IMAGE_NAME}'
             }
        }
        stage('Pull Image'){
              steps{
                  sh 'docker pull ${DOCKER_IMAGE_NAME}'
              }
         }
        stage('Run Ansible Playbook') {
            steps {
                script {
                    def ansiblePlaybookPath = "${workspace}/deploy.yml"
                    // Define the path to the inventory file
                    def inventoryFilePath = "${workspace}/inventory"
                    ansiblePlaybook(
                        playbook: ansiblePlaybookPath,
                        inventory: inventoryFilePath
                    )
                }
            }
        }
    }
}
