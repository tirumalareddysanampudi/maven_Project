pipeline {
    agent any
    environment{
      PATH="/opt/apache-maven-3.8.8/bin:$PATH"
    }
    stages {
        stage('Git-Checkout') {
            steps {
                // Get some code from a GitHub repository
                git credentialsId: 'd1ea93fa-dbdf-4a89-a0bb-00c78b7fe433', url: 'https://github.com/tirumalareddysanampudi/maven_Project.git'

                // Run Maven on a Unix agent.
               // sh "mvn -Dmaven.test.failure.ignore=true clean "
            }
            }
        stage('Build'){
            steps{
               sh "mvn clean  validate "
            }
        }
        stage('test'){
            steps{
             sh "mvn  test"
        }
        }
        stage('compile'){
            steps{
              //Run Maven Compil
              sh "mvn  compile"
        }
    }
    stage('package'){
         steps{
            sh "mvn package"
            sh "mv target/*.war  target/myweb.war"
         }
    }
    stage ('code-deploy'){
          steps {
                    sshagent(['TOMCAT']) {
                    sh """
                       scp -o StrictHostKeyChecking=no  target/myweb.war ec2-user@10.0.0.62  /opt/apache-tomcat-9.0.80/webapps/
                        // after copy file to restart the tomcat
                        sh ec2-user@10.0.0.62  /opt/apache-tomcat-9.0.80/bin/shutdown.sh
                        // start the tomcat
                        sh ec2-user@10.0.0.62  /opt/apache-tomcat-9.0.80/bin/startup.sh
                    """
                }
    }
    }
}
}
    
