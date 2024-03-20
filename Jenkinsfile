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
        stage("UploadArtifact"){
                    steps{
                        nexusArtifactUploader(
                              nexusVersion: 'nexus3',
                              protocol: 'http',
                              nexusUrl: '192.168.33.10:8081',
                              groupId: 'QA',
                              version: "${env.BUILD_ID}-${env.BUILD_TIMESTAMP}",
                              repository: 'twin6-scriptSquad-foyer',
                              credentialsId: 'nexus',
                              artifacts: [
                                [artifactId: 'my-project',
                                 classifier: '',
                                 file: 'target/vprofile-v2.war',
                                 type: 'war']
                            ]
                        )
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
