pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git credentialsId: 'd1ea93fa-dbdf-4a89-a0bb-00c78b7fe433', url: 'https://github.com/tirumalareddysanampudi/maven_Project.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean "
            }
            }
        stage('test'){
            steps{
             sh "mvn -Dmaven.test.failure.ignore=true  test"
        }
        stage('compile'){
            steps{
              //Run Maven Compil
              sh "mvn -Dmaven.test.failure.ignore=tru compile"
        }
    }
    }
    }
    }
