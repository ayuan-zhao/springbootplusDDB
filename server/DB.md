
IAM: https://docs.aws.amazon.com/singlesignon/latest/userguide/getting-started.html

root
https://signin.aws.amazon.com/signin?redirect_uri=https%3A%2F%2Fconsole.aws.amazon.com%2Fconsole%2Fhome%3FhashArgs%3D%2523%26isauthcode%3Dtrue%26state%3DhashArgsFromTB_us-east-2_b6bd35cc107af125&client_id=arn%3Aaws%3Asignin%3A%3A%3Aconsole%2Fcanvas&forceMobileApp=0&code_challenge=vRats72SXGP_SsfXtw5RJi4zKECGerIXPRxQT1hXCtg&code_challenge_method=SHA-256
devaccount@blackcowtech.com
米吗：BCT@2023

IAM
https://d-9a6706d486.awsapps.com/start
anya_dev/BCTdev@2023

Using the AWS CLI
https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Tools.CLI.html#Tools.CLI.UsingWithDDBLocal

## aws commands


aws dynamodb create-table \
--table-name Music \
--attribute-definitions \
AttributeName=Artist,AttributeType=S \
AttributeName=SongTitle,AttributeType=S \
--key-schema AttributeName=Artist,KeyType=HASH AttributeName=SongTitle,KeyType=RANGE \
--provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 \
--table-class STANDARD \
--endpoint-url http://localhost:8000


aws dynamodb put-item \
--table-name Music \
--item \
'{"Artist": {"S": "No One You Know"}, "SongTitle": {"S": "Call Me Today"}, "AlbumTitle": {"S": "Somewhat Famous"}}' \
--return-consumed-capacity TOTAL  \
--endpoint-url http://localhost:8000

aws dynamodb put-item \
--table-name Music \
--item '{
"Artist": {"S": "Acme Band"},
"SongTitle": {"S": "Happy Day"},
"AlbumTitle": {"S": "Songs About Life"} }' \
--return-consumed-capacity TOTAL \
--endpoint-url http://localhost:8000

aws dynamodb query --table-name Music --key-condition-expression "Artist = :value" --expression-attribute-values '{":value": {"S": "Acme Band"}}' --endpoint-url http://localhost:8000

aws dynamodb scan --table-name Music


aws dynamodb create-table \
--table-name btcCustomer \
--attribute-definitions \
AttributeName=customerId,AttributeType=S \
--key-schema AttributeName=customerId,KeyType=HASH \
--provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 \
--table-class STANDARD \
--endpoint-url http://localhost:8000

aws dynamodb scan --table-name btcCustomer --endpoint-url http://localhost:8000
aws dynamodb list-tables --endpoint-url http://localhost:8000