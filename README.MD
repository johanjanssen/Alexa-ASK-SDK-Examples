# Alexa ASK SDK Examples
These are some examples including instructions to help you build your own Alexa skills to add your own functionality.

# Steps to run a skill
* Create a skill
* Upload the application to AWS Lambda
* Couple the skill and the application

## Create a new skill for your application
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

## Couple the skill and your application
* Go back to the Alexa developer portal
* Enter the application's 'ARN' as the endpoint
* 'Save Endpoints'
* Go to the 'Test' tab
* Enable the skill

## Test the skill
* Talk to Alexa: Alexa ask [invocationname] to say [utterance/sample]
* You receive the spoken response
* If you don't have a screen for Alexa, you can see the written response in the Alexa portal: https://alexa.amazon.com

