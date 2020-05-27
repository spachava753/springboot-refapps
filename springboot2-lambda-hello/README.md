# springboot2-lambda-hello serverless API
The springboot2-lambda-hello project, created with [`aws-serverless-java-container`](https://github.com/awslabs/aws-serverless-java-container).

The starter project defines a simple `/ping` resource that can accept `GET` requests with its tests.

The project folder also includes a `template.yml` file and serverless.yml. You can use this [SAM CLI](https://github.com/awslabs/aws-sam-cli) to test locally using `sam local start-api`. To deploy, use this [SERVERLESS CLI](https://github.com/serverless/serverless) using `sls deploy`. 

## Pre-requisites
- [AWS CLI](https://aws.amazon.com/cli/)
- [SAM CLI](https://github.com/awslabs/aws-sam-cli)
- [SERVERLESS CLI](https://github.com/serverless/serverless)
- [Maven](https://maven.apache.org/)

## Building the project
You can use the Maven to generate and package the project
```bash
$ mvn archetype:generate -DartifactId=springboot2-lambda-hello -DarchetypeGroupId=com.amazonaws.serverless.archetypes -DarchetypeArtifactId=aws-serverless-jersey-archetype -DarchetypeVersion=1.5 -DgroupId=net.thespblog.refapp -Dversion=1.0-SNAPSHOT -Dinteractive=false
$ cd springboot2-lambda-hello
$ mvn package
```

## Testing locally with the SAM CLI

From the project root folder - where the `template.yml` file is located - start the API with the SAM CLI.

```bash
$ sam local start-api
```

Using a new shell, you can send a test ping request to your API:

```bash
$ curl -s http://127.0.0.1:3000/ping | python -m json.tool

{
    "pong": "Hello, World!"
}
``` 

## Deploying to AWS
To deploy the application in your AWS account, you can use the SAM CLI's guided deployment process and follow the instructions on the screen

```
$ sam deploy --guided
```

OR

you can use serverless framework

```
$ sls deploy
```
The serverless framework will deploy to dev, so there will be a base path of `/dev` in instead of `/prod` for SAM CLI.

Once the deployment is complete, the SAM CLI and SLS CLI will print out the stack's outputs, including the new application URL. You can use `curl` or a web browser to make a call to the URL.

For SAM CLI:
```bash
$ curl -s https://xxxxxxx.execute-api.xxxxxxxxx.amazonaws.com/Prod/ping

{
    "pong": "Hello, World!"
}
```

For SLS CLI:
```bash
$ curl -s https://xxxxxxx.execute-api.xxxxxxxxx.amazonaws.com/dev/ping

{
    "pong": "Hello, World!"
}
```

# Reasons why I have SAM and SLS

- SAM CLI makes it really easy to test locally using `sam local start-api`. The previous command will spin up a local version of the API Gateway and start a container that will run your lambda code. 
- However, I prefer the ease of Serverless Framework for deploying as I don't have to deal with CloudFormation templates that much, and I can easily deploy to multiple environments. 
- Plus, Serverless Framework there are tons of plugins in the Serverless Framework ecosystem that expedite the development process.  