pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                sh 'rm -rf target/*'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('http://192.168.33.10:9000') {
                sh 'mvn clean package sonar:sonar'
              }
            }
          }
    }

    post {
        success {
            echo 'Build successful! Deploying...'
            // Add deployment steps here
        }
        failure {
            echo 'Build failed! Sending notification...'
            // Add notification steps here
        }
    }
}
