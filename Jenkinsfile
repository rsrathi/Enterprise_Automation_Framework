pipeline {

    agent any

    tools {

        jdk 'JDK21'
        maven 'Maven'

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