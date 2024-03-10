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
        stage('Test') {
                    steps {
                        sh 'mvn test'
                    }
                }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage("MVN SONARQUBE"){
                    steps{
                        withSonarQubeEnv(installationName: 'sonar') {
                        sh "mvn sonar:sonar"
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
