pipeline{
agent any
stages{
stage('Checkout'){
steps{
echo 'Checking out source code..'
}
}
stage('Run Test'){
steps{
bat 'mvn clean test'
}
}
stage('Generate Allure Report'){
steps{
allure([results: [[path:'allure-results']]
])
}
}
}post{
always{ echo 'pipeline execution completed.'}
sucess{echo 'Tests passed successfully.'}
failure{echo 'Tests failed. Check console Output.'}}}
