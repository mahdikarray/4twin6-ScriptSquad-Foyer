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
        stage('Test') {
            steps {
                        // Run Maven tests
                sh 'mvn test'
                   }
            }
       stage("MVN SONARQUBE") {
           steps {
               withSonarQubeEnv(installationName: 'sonar') {
                   sh "mvn -DskipTests sonar:sonar"
               }
           }
       }
stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Deploy') {
                    steps {
                        sh 'mvn deploy'
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
