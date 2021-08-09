#!groovy

pipeline {
    agent any
    environment {
        registry = "kostiakorzh/demoshop-catalogue-service-dev"
        registryCredential = 'dockerhub'
        dockerImage = ''
    }
    stages {
        stage('Build') {
            steps {
                script {
                    dockerImage = docker.build registry
                }
            }
        }
        stage('Push to dockerhub') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push("latest")
                    }
                }
            }
        }
        stage("Deploy to docker") {
            steps {
                sh 'docker rm -f catalogue-dev-container'
                sh 'docker rmi kostiakorzh/demoshop-catalogue-service-dev'
                sh 'docker run -p 8081:8081 -d --name catalogue-dev-container -e MYSQL_URL=jdbc:mysql://demo-shop.c9pmrkdcjaav.eu-central-1.rds.amazonaws.com/catalogue_db -e MYSQL_ROOT_PASSWORD=root1234  kostiakorzh/demoshop-catalogue-service-dev'
            }
        }
    }
}