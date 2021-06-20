pipeline {
    agent any

    stages {
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
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}