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

        stage('Build & Test') {

            steps {
                bat 'mvn clean test'
            }

        }

       }

    

    post {

        always {

            allure(
            includeProperties: false,
            results: [[path: 'allure-results']]
        )
        publishHTML(target: [

            allowMissing: false,

            alwaysLinkToLastBuild: true,

            keepAll: true,

            reportDir: 'target/ExtentReport',

            reportFiles: '*.html',

            reportName: 'Extent Report'

        ])
         archiveArtifacts(
            artifacts: 'target/ExtentReport/*.html',
            fingerprint: true
        )


        }

    }
    


}