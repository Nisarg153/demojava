pipeline {
    agent any

    environment {
        TOMCAT_CRED = credentials('b78c1002-9ea5-4e05-b1ab-927e9d38713a')  // Tomcat credential ID
        TOMCAT_HOST = '3.235.95.211'
        TOMCAT_PORT = '8080'
        WAR_NAME = 'demojava.war'                     // Update if needed
    }

    stages {
        stage('Checkout Code') {
            steps {
                git credentialsId: 'GithubCreds', url: 'https://github.com/Nisarg153/demojava.git'
            }
        }

        stage('Build WAR') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                script {
                    def warPath = "target/${env.WAR_NAME}"
                    def deployURL = "http://${TOMCAT_CRED_USR}:${TOMCAT_CRED_PSW}@${env.TOMCAT_HOST}:${env.TOMCAT_PORT}/manager/text/deploy?path=/yourapp&update=true"
                    sh "curl -T ${warPath} ${deployURL}"
                }
            }
        }
    }

    post {
        success {
            echo '✅ Deployment Successful!'
        }
        failure {
            echo '❌ Build or Deployment Failed!'
        }
    }
}
