pipeline{

environment{
		registry = 'medamin20/timesheet-devops'
		registryCredential= 'dockerHub'
		dockerImage = ''
	}
  


		agent any 
	stages{
		stage ('Checkout GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'Amine_Branch',
					url : 'https://github.com/medamin20/Timesheet_DevOps';
			}
		}

		stage ("Verification du  version Maven"){
			steps{
				bat """mvn -version"""
			}
		}

		stage ("Suppression du dossier tareget + Copie du livrable dans le Repository local"){
			steps{
				bat """mvn clean install"""
			}
		}

		stage ("Lancement des Tests Unitaires"){
			steps{
				bat """mvn test"""
			}
		}

		stage ("Création du livrable dans target"){
			steps{
				bat """mvn package"""
			}
		}

		stage ("Analyse avec Sonar"){
			steps{
				bat """mvn sonar:sonar"""
			}
		}

		
		stage ("Deploiement"){
			steps{
				bat """mvn clean package -Dmaven.test.skip=true -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet_DevOps -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet_DevOps-1.0.jar"""
			}
		}

		stage('Building our image'){
			steps{ 
				script{ 
					dockerImage= docker.build registry + ":$BUILD_NUMBER" 
				}
			}
		}

		stage('Deploy our image'){
			steps{ 
				script{
					docker.withRegistry( '', registryCredential){
						dockerImage.push()
					} 
				} 
			}
		}
	}

	// post{
	// 	success{
	// 		emailext body: 'Build success', subject: 'Jenkins', to:'benhssanmohamedamin@gmail.com'
	// 	}
	// 	failure{
	// 		emailext body: 'Build failure', subject: 'Jenkins', to:'benhssanmohamedamin@gmail.com'
	// 	}


	post{
	always{
		emailext body: 'Build # $BUILD_NUMBER - $BUILD_STATUS!', subject: 'mail of pipeline satut', to: 'benhssanmohamedamin@gmail.com'
	}
	}



}
