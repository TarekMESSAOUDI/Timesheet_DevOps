pipeline{
		agent any 
	stages{
		stage ('Checkout GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'Ghassen_Branch',
					url : 'https://github.com/GhassenHouissa/Timesheet_DevOps';
			}
		}

		stage ("Verification du  version Maven"){
			steps{
				bat """mvn -version"""
			}
		}

		 stage ("clean"){
		 	steps{
		 		bat """mvn clean """
		 	}
		 }


 		 stage ("creation de livrable"){
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

		 stage ("Deploiement "){
		 	steps{
		 		bat """mvn deploy"""
		 	}
		 }
	}

	post{
		success{
			emailext body: 'Build success', subject: 'Jenkins', to:'houissaghassen@gmail.com'
		}
		failure{
			emailext body: 'Build failure', subject: 'Jenkins', to:'houissaghassen@gmail.com'
		}

	}
}
