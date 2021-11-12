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
					url : 'https://github.com/rachedchakchouk/Timesheet_DevOps';
			}
		}

		stage ("Verification du  version Maven..."){
			steps{
				bat """mvn -version"""
			}
		}

		stage ("Clean..."){
			steps{
				bat """mvn clean"""
			}
			
		}

		stage ("Creation du livrable..."){
			steps{
				bat """mvn package -Dmaven.test.skip=true"""
			}
		}

		stage ("Lancement des Tests Unitaires..."){
			steps{
				bat """mvn test"""
			}
		}

		stage ("Analyse avec Sonar..."){
			steps{
				bat """mvn sonar:sonar"""
			}
		}

		stage ("Deploiement dans Nexux..."){
			steps{
				bat """mvn clean package -Dmaven.test.skip=true -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet_DevOps -Dversion=3.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet_DevOps-3.0.jar"""
			}
		}

		stage('Building our image...'){
			steps{ 
				script{ 
					dockerImage= docker.build registry + ":$BUILD_NUMBER" 
				}
			}
		}

		stage('Deploy our image...'){
			steps{ 
				script{
					docker.withRegistry( '', registryCredential){
						dockerImage.push()
					} 
				} 
			}
		}

		stage('Cleaning up...'){
			steps{
				bat "docker rmi $registry:$BUILD_NUMBER" 
			}
		}
}

	post{
	always{
		emailext body: 'Build # $BUILD_NUMBER - $BUILD_STATUS!', subject: 'mail of pipeline satut', to: 'rached.chakchouk@esprit.tn'
	}
	}
}