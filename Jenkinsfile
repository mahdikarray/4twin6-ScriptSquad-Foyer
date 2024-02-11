pipeline {
    agent any

    environment {
        GIT_USERNAME = 'mahdikarray'
        GIT_PASSWORD = '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'
    }

    stages {
        stage('Clone Project') {
            steps {
                script {
                    git branch: 'main', credentialsId: '', url: 'https://github.com/mahdikarray/4twin6-ScriptSquad-Foyer.git'
                }
            }
        }
    }
}
