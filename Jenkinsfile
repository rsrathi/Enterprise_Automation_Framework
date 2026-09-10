pipeline {

    agent any

    tools {

        jdk 'jdk21'
        maven 'Maven_3.9.8'

    }

    stages {

        stage('Checkout') {

            steps {
                checkout scm
            }

        }

        stage('Build') {

            steps {
                bat 'mvn clean compile'
            }

        }

        stage('Execute Tests') {

            steps {
                bat 'mvn test'
            }

        }

    }

    post {

        always {

            archiveArtifacts artifacts: 'target/**/*.html',
                             fingerprint: true

        }

    }

}