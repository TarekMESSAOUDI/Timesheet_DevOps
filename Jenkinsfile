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

		stage ("Analyse avec Sonar"){
			steps{
				bat """mvn sonar:sonar"""
			}
		}

		stage ("Deploiement dans http://localhost:8081/repository/maven-snapshots/ "){
			steps{
				bat """mvn clean package -Dmaven.test.skip=true -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet_DevOps -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-snapshots/ -Dfile=target/Timesheet_DevOps-1.0.jar"""
			}
		}

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
