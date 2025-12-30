pipeline {
    agent any

    tools {
          maven 'Maven3'
    }

    environment {
        SONAR_HOST_URL = 'http://localhost:9000'
        SONAR_TOKEN = credentials('sonar-token')
    }

    stages {

         stage('Checkout') {
             steps {
                 checkout([
                     $class: 'GitSCM',
                     branches: [[name: '*/master']],
                     userRemoteConfigs: [[
                         url: 'https://github.com/Kapilan1998/java21-hello-world.git',
                         credentialsId: 'github-token'
                     ]]
                 ])
             }
         }

        stage('Build') {
            steps {
                sh 'mvn --version'
                sh 'java --version'
                sh 'mvn clean compile'
            }
        }


        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.login=${SONAR_TOKEN} -Dsonar.projectKey=java21-hello-world -Dsonar.projectName=java21-hello-world'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Run Application') {
            steps {
                sh '''
                    echo "===================================="
                    echo "Running Java 21 Hello World Application"
                    echo "===================================="
                    java -jar target/java21-hello-world-1.0.0.jar
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline completed successfully!'
        }
        failure {
            echo '❌ Pipeline failed! Check logs for details.'
        }
        always {
            cleanWs()
        }
    }
}