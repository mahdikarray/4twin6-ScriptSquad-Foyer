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
        stage('SonarQube Analysis') {
                    steps {
                        withCredentials([usernamePassword(credentialsId: 'sonarqube-credentials', usernameVariable: 'admin', passwordVariable: '201JMT4720')]) {
                            sh "mvn sonar:sonar -Dsonar.login=${admin} -Dsonar.password=${201JMT4720}"
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
