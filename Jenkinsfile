pipeline {
 agent any
 stages {
 stage('Build') { 
steps {
 sh 'mvn -B -DskipTests clean package' 
}
 }
 stage('pmd') {
 steps {
 sh 'mvn pmd:b88b09639ae04f4e9229c3ec54f5663b'
 }
 }
 }
 post {
 always {
 archiveArtifacts artifacts: '**/target/site/**', fingerprint: true
 archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
 archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
 }
 }
 }
