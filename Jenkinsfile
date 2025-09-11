pipeline {
    agent any

    environment {
        IMAGE_NAME = "mpraveen5640/api-service"
        IMAGE_TAG = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull code from GitHub
                git branch: 'master', url: 'https://github.com/mpraveen5640/api-service.git'
            }
        }

        stage('Run Tests') {
                    steps {
                        // Run all unit & integration tests
                        bat "mvn clean test"
                    }
                }

        stage('Build JAR') {
            steps {
                // Build the JAR using Maven
                bat "mvn clean package -DskipTests"
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build Docker image using the JAR
                bat "docker build -t %IMAGE_NAME%:%IMAGE_TAG% ."
            }
        }

        stage('Verify Docker Image') {
            steps {
                // Verify Docker image is created
                bat "docker images | findstr %IMAGE_NAME%"
            }
        }
    }

    post {
        success {
            echo "✅ Docker image built successfully!"
        }
        failure {
            echo "❌ Pipeline failed!"
        }
    }
}