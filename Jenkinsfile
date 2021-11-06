pipeline{
	environment{
		registry = "moneimhamadi/devops_project"
		registryCredential= 'dockerHub'
		dockerImage = ''
	}
	agent any 
	stages{
		stage ('Checkout GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'Moneim_Branch',
					url : 'https://github.com/moneimhamadi/Timesheet_DevOps';
			}
		}

		
		stage ("verification version Maven"){
			steps{
				bat """mvn -version"""
			}
		}

		stage ("Clean"){
			steps{
				bat """mvn clean"""
			}
		}

		stage ("Creation du livrable"){
			steps{
				bat """mvn package"""
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

	post{
		success{
			emailext body: 'Build success', subject: 'Jenkins', to:'hammadi.moneim@esprit.tn'
		}
		failure{
			emailext body: 'Build failure', subject: 'Jenkins', to:'hammadi.moneim@esprit.tn'
		}

	}
}
//
