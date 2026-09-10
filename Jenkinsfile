pipeline{
agent any
stages{
stage('Test'){
  steps{  echo 'Jenkins Pipeline is working'}
}
}
}
post{always{
  publishHTML([allowMissing:true,
               alwaysLinkToLastBuild:true,
               keepAll:true,
               reportDir:'target/surefire-reports',
               reportFiles:'intex.html',
               reportName:'Test Automation HTML Report'])
}
    }
}
