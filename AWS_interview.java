1 What is AWS lambda  ? 
	Lambda is a compute service from AWS which lets you run your code without provisioning any server either physical or virtual
	, lambda has four Main feature to manage
	I. No server to manage
	II. lambda scale automitically, you don't need to configure any auto scaling group
	III. is inherently highly available , so under the hood lambda is deployed into multiple availability zone, if one availability goes down
		lambda still be up and  running and available
	IV. pay as you use
	use api, alexa
2 what are some of the other aws serverless services?
	Any serverless services should have four property
	I. No server to manage
	II. don't need to configure auto scaling
	II. inherently highly available
	IV. you should pay as you use
	API gateway, SQS, dynamo db etc
3 how to handle lambda cold stars?
	code is sitting but no action. time getting invoked and start running. provision concurrently: when you create your lambda, you can say that
	bring up specify number. 
	schedule provional concrurrency , you can schedule provisional concurrency, when the test and other item is going to increase.
	auto scaling, you spin of 10 of the pre own container, 
4 Can you use your own container image with lambda?
	Yes, provide the container image but if you want you can create your own image for lambda
	why should u  do this? -->. reused all the advantages of lambda, kubernetes, services as well as pay as you go.
	
5 how does lambda scale? how is it different than farget?,
	Every traffic that comes in , create a new instance of the lambda. one lambda instance cann't handle more than one traffic connection
	so each traffic will simply spinup a new instance of your lambda function.
	Fargate, spin up a container, Lets' example EKS fargate, running inside a pod, but this pod can handle more than 1 traffic connection.
	cpu utilization goes to 70%, exceed the threshold then another fargate pod will come up and then the other traffice start going to this pod.
	another way if threshold or limit goes down then fargarte reduce his pod
	- fargate is run into the container
	- fargate is create another container based instance when the threshold limit get exceed.
	- support 3,4 fargate pod created but when traffic goes down then only 1 fargate will keep running
	- lambda can run maximum 15 minute but fargate there is no time limit
	- maximum lambda memory 10GB, cpu code is 6
	- fargate you have to choose and pickup a memory, kubernetes , you have to choose fargate put orssitdo something, lambda easily integrate
	with S3. 
6 how do you change the amount of cpu allocated to lambda
	put up core , availability , x.cpu_count();
7 how do you secure your lambda function?
	- lambda alllow to fetch dynamo db, s3. this lambda AWS Role attach
	- role can specify , which bucket can this lambda code access
	- lambda resource policies can control who can call your lambda example ApI a1 and a2. you want to allow only a1, then you can add in
		policies
	- if vulnerability detected , by dynamic scan by few scanner twislock, seasing scan 
8  why use Eventbridge when SQS is cheaper , 
	build even driven architecture so if system A wants to send some message to system B both eventbridge and sqs can do that but what eventbridge does that SQS(simple query service) does not do is uh rule-based target invocation and message transformation and archive and replay.
	EVentbride can do
	- Rule based target invocation, message tranformation, archive and replay
	SQS can't see inside of your message, suppose you are sending message from A to B via SQS for insurance company , so B would like to do
	some action(call lambda function) based on the type of the insurance like home, motor etc. 
	- SQS can't transform the message,  because even bridge discovers the schema of the message even bridge will have this mapping automatically that or type is of type string so you have uh you can manipulate
	you are testing it sending a message and this lambda fails okay so something is
	wrong with the code and when you fix the lambda and you want to retest it
	system a needs to resend the same message again and then maybe the lambda failed again then you fixed again so you
	have to so the system may i need to keep resending those messages
	with even bridge messages can be saved so lets say the message one i am going to put it as m1
	came to even bridge m1 can be archived in even bridge
	free of charge and this time also lets say some lambda failed you fixed it and you can replay this message. system A don't need to resend
	message.
	- SQS way more scalability than EB have finite number but SQL has unlimited.
	- Event bridge discover the message type then u can use this and process the message
	- Q SNS also do the filtering based on message, also do filtering based on the metadata of the message not the actual value inside the message.
	- Event bridge can read inside the message


9 should i use serverless or kubernetes?
	
10 how can you migrate your existing apis to amazon api gateway? // other api as well , mulesoft other 
	export the API as swagar file, you can import api gate basic structure of api.
	you can do the lambda you can do the integration piece. 
	Swager + API gateway, example apache doesn't have lambda, lambda has much more straight forward way .
	Open API version 3 
	
11 how can you use api gateway with elastic kubernetes service(EKS) and elastic container service(ECS)? 
   kubernete process the pods through ingress(is an kubernet object). 
   API -> Ingress -pods
   ECS cna integrate directly using api, using cloud map.
12 tell me a challenge you faced with serverless ?
	with server: cost optimization and performance optimization.
	without server:allocated hudge number of memory and then notice we are paying lot more we should have, solved using aws cloudwatch service.
	how  much is  used and allocated, going inside. amount of memory allocated is charge. power tuner trace to the lambda , used graph
	between the cost and execution time.
13 this is a packed video so i have provided timestamps for your viewing
convenience let's get started question number one what is aws lambda
so in reply to this question everyone will say that lambda is a compute service from aws
which lets you run your code without provisioning any server either physical or virtual
but then you should add these things you should say that lambda has four