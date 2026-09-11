pipeline{
agent any
stages{
stage('Test Execution'){
  steps{  echo 'Starting test execution...'
       bat'mvn clean test'}
}

  stage('Allure Report'){
  steps{
    allure([results:[[path:  n 'target/allure-results']]
            ])
  }
}stage('Publish HTML Report'){
  steps{
   
  publishHTML([allowMissing:true,
               alwaysLinkToLastBuild:true,
               keepAll:true,
               reportDir:'target/surefire-reports',
               reportFiles:'intex.html',
               reportName:'Test Automation HTML Report'])
}
    }
}
post{
  always{
    emailext(
      subject:"[CI/CD]$
      {env.JOB_NAME}-Build #$
      {env.BUILD_NUMBER}-$
      {currentBuild.currentResult}",
      body:"""
      Hi Team,
      The CI/CD pipeline execution has completed.
      Project : ${env.JOB_NAME}
      Build Number : #${env.BUILD_NUMBER}
      Build Staus :$
      {currentBuild.currentResult}
      Test Excution : completed
      Allure Report :Available in jenkins
      HTML report: Available in jenkins
      Build Log :Attached

      Please check the jenkins build for detailed test results.

      Regards,
      QA Team
    
""",
      to:'Banupriya.kiaq@gmail.com'
      attachLog: true)
      }
   
      }
      }
