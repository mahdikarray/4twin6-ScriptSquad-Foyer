pipeline {
    agent any
environment {
        SNAP_REPO = 'twin6scriptsquadfoyer-SNAPSHOT'
        RELEASE_REPO = 'twin6-scriptSquad-foyer'
        NEXUS_IP = "192.168.33.10"
        NEXUS_PORT = "8081"
        NEXUS_LOGIN = "nexus"
        NEXUS_URL = "http://192.168.1.17:8081"
        NEXUS_REPOSITORY = "twin6-scriptSquad-foyer"
        NEXUS_USERNAME = "admin"
        NEXUS_PASSWORD = "nexus"
        ARTIFACT_PATH = "com/example/4twin6-ScriptSquad-Foyer/0.0.1-SNAPSHOT/twin6scriptsquadfoyer-0.0.1.jar"

 }
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
       stage("UploadArtifact") {
           steps {
               nexusArtifactUploader(
                   nexusVersion: 'nexus3',
                   protocol: 'http',
                   nexusUrl: '192.168.1.17:8081',
                   groupId: 'com.example',
                   version: "0.0.1-SNAPSHOT",
                   repository: 'twin6-scriptSquad-foyer',
                   credentialsId: 'nexus',
                   artifacts: [
                       [
                           artifactId: 'twin6scriptsquadfoyer', // Correct artifactId
                           classifier: '',
                           file: 'target/twin6scriptsquadfoyer-0.0.1-SNAPSHOT.jar',
                           type: 'jar'
                       ]
                   ]
               )
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
