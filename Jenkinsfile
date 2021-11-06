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
