# Alexa ASK SDK Examples
These are some examples including instructions to help you build your own Alexa skills to add your own functionality.

# Steps to run a new skill
* Create a new skill
* Deploying the application to AWS Lambda
* Couple the skill and the application

## Create a new skill
* GOTO the Alexa developer portal https://developer.amazon.com/alexa
* Create skill
* Give the skill a name
* Follow the wizard
* Click on JSON Editor
* Upload the interaction model located in the 'models' directory
* Build model
* Click on 'Endpoint'
* Select 'AWS Lambda ARN'
* [optional, but recommended for security] Note the 'Skill ID'

## Deploying the application to AWS Lambda
* You need to setup two things (only once):
	* An S3 bucket where the artifacts will be uploaded
	* An IAM role to deploy the artifact in AWS Lambda
* [optional, but recommended for security] add the 'Skill ID' to the StreamHandler as argument to 'withSkillId'.
* We'll use the Lambda Maven Plugin configured in the pom.xml
* mvn -DaccessKey=[your-access-key] -DsecretKey=[your-secret-key] -Ds3Bucket=[your-S3-bucket] -DlambdaRoleArn=[your-deployment-role] package lambda:deploy-lambda
* GOTO the AWS Lambda console: https://console.aws.amazon.com/lambda
* Open your application
* Note the 'ARN' in the top right

## Couple the skill and the application
* Go back to the Alexa developer portal
* Enter the application's 'ARN' as the endpoint
* 'Save Endpoints'
* Go to the 'Test' tab
* Enable the skill

## Test the skill
* Talk to Alexa: Alexa ask [invocationname] to say [utterance/sample]
* You receive the spoken response
* If you don't have a screen for Alexa, you can see the written response in the Alexa portal: https://alexa.amazon.com

# Steps to update a skill
* Simply change the code and use Maven to upload and deploy the new code
* And/or change the interaction model in the Alexa developer portal

# DemoSkill combined with SpringBootHelloWorldAWSLambda
* SpringBootHelloWorldAWSLambda is a simple Spring Boot application with a REST endpoint which should be deployed in AWS Lambda
* DemoSkill shows the different features of the Alexa ASK SDK and uses the SpringBootHelloWorldAWSLambda for some functionality

## Steps to run both applications
* Deploy SpringBootHelloWorldAWSLambda
* Configure the AWS API Gateway
* Configure the endpoint in DemoSkill
* Deploy and run DemoSkill

## Deploy SpringBootHelloWorldAWSLambda
* Use the same Maven command as the one to upload and deploy a Skill
* GOTO https://console.aws.amazon.com/lambda
* Note the 'ARN' of the application

## Configure the AWS API Gateway
* GOTO https://console.aws.amazon.com/apigateway
* Create a new API
* Choice a name
* Create Resource
* Select 'Proxy'
* Replace 'proxy' by 'hello' (the endpoint of the application) twice
* Create Resource
* Enter the 'ARN' of the application
* Save
* Actions -> Deploy API
* Enter a name for instance 'Prod'
* Note the 'Invoke URL'
* Use the following commands to test the API Gateway and the application
	* Reponse and detailed information: curl -i "[Invoke URL]/hello?name=Frank"
	* Only the response: curl -s "[Invoke URL]/hello?name=Frank"

## Configure the endpoint in DemoSkill
* GOTO HelloNameRequestHandler.java
* Enter the 'Invoke URL'

## Deploy and run DemoSkill
* Use the Maven command as before
* Create a new Skill in the Amazon Alexa developer portal as before
