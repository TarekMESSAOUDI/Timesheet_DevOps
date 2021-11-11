pipeline {

environment
{
registry = "meissabenali/benalimeissa"
registryCredential= 'dockerHub'
dockerImage = ''
}

agent any
stages{
       stage('Checkout GIT'){
       steps{
             echo 'Pulling...';
             git branch: 'Meissa_Branch',
             url : 'https://github.com/TarekMESSAOUDI/Timesheet_DevOps.git';
             }
         }
         
         stage("Test,Build"){
          steps{
          bat """mvn clean package -Dmaven.test.skip=true"""
          }
          }
          
          stage("Sonar"){
          steps{
          bat """mvn sonar:sonar"""
          }
          }
          
          stage("Nexus"){
          steps{
          bat """mvn clean package -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet_DevOps -Dversion=1.2 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet_DevOps-1.2.jar"""
          }
          }

          stage('Building our image') {
          steps { script { dockerImage= docker.build registry + ":$BUILD_NUMBER" } }
          }
          stage('Deploy our image') {
          steps { script { docker.withRegistry( '', registryCredential) { dockerImage.push() } } }
          }
          stage('Cleaning up') {
          steps { bat "docker rmi $registry:$BUILD_NUMBER" }
          }
          }
       
       post {
    always {
       mail to: 'meissabnali@gmail.com',
          subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
          body: "${env.BUILD_URL} has result ${currentBuild.result}"
   
       }    
        }
      
      
       }