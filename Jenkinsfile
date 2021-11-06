pipeline{

	environment{
		registry = 'ghassen1995/timesheet-devops'
		registryCredential= 'dockerHub'
		dockerImage = ''
	}


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
		 		bat """mvn clean package -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet_DevOps -Dversion=2.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet_DevOps-2.0.jar


-Dmaven.test.skip=true"""
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
		stage('email'){
			mail bcc: '', body: 'jknlk', cc: '', from: '', replyTo: '', subject: 'jhbj', to: 'houissaghassen@gmail.com'
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
