Pipeline{
		agent any 
	stages{
		stage ('Checkout GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'master',
					url : 'https://github.com/TarekMESSAOUDI/Timesheet_DevOps.git',
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

		stage ("Deploiement dans http://localhost:8081/repository/maven-releases/ "){
			steps{
				bat """mvn deploy"""
			}
		}

	}

	post{
		success{
			emailtext body: 'Build success', subject: 'Jenkins', to:'tarek.messaoudi@esprit.tn'
		}
		failure{
			emailtext body: 'Build failure', subject: 'Jenkins', to:'tarek.messaoudi@esprit.tn'
		}

	}
}