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
          bat """mvn clean package -Dmaven.test.failure.ignore=true deploy -DaltDeploymentRepository=deploymentRepo::default::file:/"""
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