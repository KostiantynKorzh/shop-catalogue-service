pipeline {
    agent any

    stages {
        stage('Pre-Test') {
                steps {
                    whoami
                }
            }
        stage('Pulling git repo'){
        steps{
             git branch: "main", url: 'https://github.com/KostiantynKorzh/shop-catalogue-service.git'
            }
        }

        stage('Build') {
            steps {
                echo "${env.BUILD_ID}"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}