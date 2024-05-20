pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }
        stage(' Test report') {
            steps {
                // 添加测试到你的 Pipeline
                bat 'mvn test'
            }
        }
        stage('pmd') {
            steps {
                bat 'mvn pmd:pmd'
            }
        }
        stage('Doc') {
            steps {
                // 生成 Javadoc 并作为构件保存
                bat 'mvn javadoc:jar --fail-never'
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
