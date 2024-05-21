 pipeline {
 agent any
 stages {
 stage('Build') { 
steps {
 sh 'mvn -B -DskipTests clean package' 
}
 }
 stage('K8s') {
 steps {
 sh 'kubectl set image deployments/hello-node docs=yang2003/teedy2024_manual0'
 }
 }
 }
 }
