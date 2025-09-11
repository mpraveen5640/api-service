pipeline {
    agent any

    environment {
        IMAGE_NAME = "mpraveen5640/api-service"  // Your Docker image name
        IMAGE_TAG = "latest"                     // Image tag
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull code from your public GitHub repo
                git branch: 'master', url: 'https://github.com/mpraveen5640/api-service.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build Docker image using your Dockerfile and existing JAR
                bat "docker build -t $IMAGE_NAME:$IMAGE_TAG ."
            }
        }

        stage('Verify Docker Image') {
            steps {
                // Verify Docker image is created
                bat "docker images | grep $IMAGE_NAME"
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