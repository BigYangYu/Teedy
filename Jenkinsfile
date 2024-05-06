pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }
        // stage('Run Tests') {
        //     steps {
        //         // 添加测试到你的 Pipeline
        //         bat 'mvn test'
        //     }
        // }
        stage('Static Code Analysis') {
            steps {
                bat 'mvn pmd:pmd'
            }
        }
        stage('Generate Javadoc') {
            steps {
                script {
                    try {
                        // 生成 Javadoc 并作为构件保存
                        bat 'mvn javadoc:jar'
                    } catch (Exception e) {
                        echo "An error occurred while generating Javadoc: ${e.message}"
                    }
                }
            }
            post {
                always {
                    // 归档生成的 Javadoc 索引报告
                    archiveArtifacts artifacts: '**/target/site/apidocs/index.html', fingerprint: true
                }
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
