pipeline {
    agent any

    environment {
        SNAP_REPO = 'twin6scriptsquadfoyer-SNAPSHOT'
        RELEASE_REPO = 'twin6-scriptSquad-foyer'
        NEXUS_IP = "192.168.33.10"
        NEXUS_PORT = "8081"
        NEXUS_LOGIN = "nexus"
        NEXUS_URL = "192.168.1.23:8081" // Correction de l'URL Nexus
        NEXUS_REPOSITORY = "twin6-scriptSquad-foyer"
        NEXUS_USERNAME = "admin"
        NEXUS_PASSWORD = "nexus"
        ARTIFACT_PATH = "com/example/twin6scriptsquadfoyer/0.0.1-SNAPSHOT/twin6scriptsquadfoyer-0.0.1-20240325.233457-5.jar"
        DOCKER_IMAGE_NAME = "mohamedaminederouiche/spring"
        DOCKER_HUB_CREDENTIALS = 'DockerHub'
        DOCKER_COMPOSE_VERSION = "1.29.2"
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

        // stage('Test') {
        //     steps {
        //         sh 'mvn test'
        //     }
        // }

        // stage("MVN SONARQUBE") {
        //     steps {
        //         withSonarQubeEnv(installationName: 'sonar') {
        //             sh "mvn -DskipTests sonar:sonar"
        //         }
        //     }
        // }

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
                    nexusUrl: "${NEXUS_URL}", // Utilisation de la variable NEXUS_URL
                    groupId: 'com.example',
                    version: "0.0.1-SNAPSHOT",
                    repository: 'twin6-scriptSquad-foyer',
                    credentialsId: 'nexus',
                    artifacts: [
                        [
                            artifactId: 'twin6scriptsquadfoyer',
                            classifier: '',
                            file: 'target/twin6scriptsquadfoyer-0.0.1-SNAPSHOT.jar',
                            type: 'jar'
                        ]
                    ]
                )
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image using the Dockerfile
                    docker.build("${DOCKER_IMAGE_NAME}", "--build-arg NEXUS_URL=${NEXUS_URL} \
                        --build-arg NEXUS_REPOSITORY=${NEXUS_REPOSITORY} \
                        --build-arg NEXUS_USERNAME=${NEXUS_USERNAME} \
                        --build-arg NEXUS_PASSWORD=${NEXUS_PASSWORD} \
                        --build-arg ARTIFACT_PATH=${ARTIFACT_PATH} .")
                }
            }
        }



             stage('Push Docker Image') {
                              steps {
                                  script {
                                      docker.withRegistry('https://index.docker.io/v1/', 'DockerHub') {
                                          docker.image("${DOCKER_IMAGE_NAME}").push()
                                      }
                                  }
                              }
               }

               


                         stage('Run Docker Compose') {
                                 steps {
                                     script {
                                         // Perform Docker login
                                         sh 'docker login -u mohamedaminederouiche -p Monjialeao17'

                                         // Pull the Docker image
                                         sh 'docker pull mohamedaminederouiche/spring'

                                         // Run Docker Compose
                                         sh 'docker compose up -d'
                                     }
                                 }
                             }

 }
    post {
        success {
            echo 'Build successful! Deploying...'
            // Ajoutez les étapes de déploiement ici
        }
        failure {
            echo 'Build failed! Sending notification...'
            // Ajoutez les étapes de notification ici
        }
    }
}
