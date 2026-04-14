aws --endpoint-url=http://localhost:4566 cloudformation describe-stacks --stack-name mio-stack --query "Stacks[0].StackStatus" 
