pipeline{
		agent any 
	stages{
		stage ('Checkout GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'master',
					url : 'https://github.com/TarekMESSAOUDI/Timesheet_DevOps';
			}
		}

		stage ("Verification du  version Maven"){
			steps{
				bat """mvn -version"""
			}
		}

		stage ("Clean install ignore Test"){
			steps{
				bat """mvn clean install -Dmaven.test.skip=true"""
			}
		}

		stage ("Lancement des Tests Unitaires"){
			steps{
				bat """mvn test"""
			}
		}

		stage ("Creation du livrable"){
			steps{
				bat """mvn package"""
			}
		}

		/*stage ("Analyse avec Sonar"){
			steps{
				bat """mvn sonar:sonar"""
			}
		}

		stage ("Deploiement dans http://localhost:8081/repository/maven-releases/ "){
			steps{
				bat """mvn deploy"""
			}
		}*/

	}

	post{
		success{
			emailext body: 'Build success', subject: 'Jenkins', to:'tarek.messaoudi@esprit.tn'
		}
		failure{
			emailext body: 'Build failure', subject: 'Jenkins', to:'tarek.messaoudi@esprit.tn'
		}

	}
}
