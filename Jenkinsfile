pipeline{
	environment{
		registry = 'rachedchakchouk/timesheet_img'
		registryCredential= 'dockerHub'
		dockerImage = ''
	}

	agent any 
	stages{
		stage ('Checkout GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'Rached_Branch',
					url : 'https://github.com/rachedchakchouk/Timesheet_DevOps.git';

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

		stage ("Deploiement dans http://localhost:8081/Browse/maven-releases/ "){
		 	steps{
		 		bat """mvn deploy"""
		 	}
		 }
		
		
		/*stage ("Clean install ignore Test"){
			steps{
				bat """mvn clean install -Dmaven.test.skip=true"""
			}
		}*/

		stage ("Clean"){
			steps{
				bat """mvn clean"""
			}
		}

		stage ("Creation du livrable"){
			steps{
				bat """mvn package -Dmaven.test.skip=true"""
			}
		}

		stage ("Lancement des Tests Unitaires"){
			steps{
				bat """mvn test"""
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

		stage('Cleaning up'){
			steps{
				bat "docker rmi $registry:$BUILD_NUMBER" 
			}
		}
}

	post{
		success{
			emailext body: 'Build success', subject: 'Jenkins', to:'Rached.chakchouk@esprit.tn'
		}
		failure{
			emailext body: 'Build failure', subject: 'Jenkins', to:'rached.chakchouk@esprit.tn'
		}
	}
}
