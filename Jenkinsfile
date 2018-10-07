pipeline {
	agent any
	tools { 
        maven 'maven3.5.4' 
        jdk 'jdk8'
    }
	stages {
		stage('Build'){
			steps {
				echo 'Building..'
				sh 'mvn clean install'
				sh 'mvn install dockerfile:build'
			}
		}
		stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            agent { 
            	dockerfile true 
            }
            steps {
                sh 'docker run -p 8443:8080 -t shaeqkhan/app'
            }
        }
	}
}