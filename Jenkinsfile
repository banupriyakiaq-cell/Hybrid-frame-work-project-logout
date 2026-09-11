pipeline{
agent any
stages{
stage('Test Execution'){
  steps{  echo 'Starting test execution...'
       bat'mvn clean test'}
}
}stage('Allure Report'){
  steps{
    allure([results:[[path:'target/allure-results']]
            ])
  }
}
   
      }
      }
