pipeline{
agent any
stages{
stage('Test Execution'){
  steps{  echo 'Starting test execution...'
       bat'mvn clean test'}
}

  stage('Allure Report'){
  steps{
    allure([results:[[path: 'target/allure-results']]
            ])
  }stage('Generate Allure HTML Report'){
    steps{bat'allure generate target/allure-results -o target/allure-report --clean'}
  }
  }
  stage('Generate Allure PDF'){
    steps{
      bat '''
      echo Checking Allure HTML report...
      dir target\\allure-report
      echo Generating PDF...
      "C:\\Program Files\\Google\\Chrome\\Application\\Chrome.exe" ^
      --headless ^
      --disable-gpu ^
      --no-sandbox ^
      --allow-file-access-from-files
      --user-data-dir="%WORKSPACE%\\chrome-profile"^
      --print-to-pdf=%WORKSPACE%\\target\\Allure.Report.pdf"^
      "file:///%WORKSPACE%/target/allure-report/index.html"
      echo Checking PDF...
      dir target\\Allure-Report.pdf
      '''
    }
  }
      
}stage('Publish Allure HTML Report'){
  steps{
   
  publishHTML([allowMissing:true,
               alwaysLinkToLastBuild:true,
               keepAll:true,
               reportDir:'target/allure-report',
               reportFiles:'intex.html',
               reportName:'Allure Test Automation Report'])
}
    }
  
}
post{
  always{
    emailext(
      subject: "[CI/CD] $
      {env.JOB_NAME} - Build #$
      {env.BUILD_NUMBER} - $
      {currentBuild.currentResult}",
      body: """
      Hi Team,
      The CI/CD pipeline execution has completed.
      Project : ${env.JOB_NAME}
      Build Number : #${env.BUILD_NUMBER}
      Build Staus :$
      {currentBuild.currentResult}
      Test Excution : completed
      Allure Report :Attached as PDF
      HTML report: Attached in Jenkins
      Build Log :Attached

      Please check the jenkins build for detailed test results.

      Regards,
      QA Team
    
""",
      to:'Banupriya.kiaq@gmail.com'
      attachmentsPattern:'target/Allure-Report.pdf',
      attachLog: true)
      }
   
      }
      }
