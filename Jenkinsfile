pipeline {
    agent any

    stages {
        stage('Clone Project') {
            environment {
                GIT_USERNAME = 'mahdikarray'
                GIT_PASSWORD = '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'
            }
            steps {
                withCredentials([usernamePassword(credentialsId: '', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')]) {
                    script {
                        git url: 'https://github.com/mahdikarray/4twin6-ScriptSquad-Foyer.git'
                    }
                }
            }
        }
    }
}
