# Simple Spring AI

This project contains a web service that will accept HTTP GET requests at
`http://localhost:8080/ai/simple`.

There is optional `message` parameter whose default value is "Tell me a joke".

The response to the request is from the OpenAI ChatGPT Service.

## Prerequisite

Before using the AI commands, make sure you have a developer token from OpenAI.

Create an account at [OpenAI Signup](https://platform.openai.com/signup) and generate the token at [API Keys](https://platform.openai.com/account/api-keys).

The Spring AI project defines a configuration property named `spring.ai.openai.api-key` that you should set to the value of the `API Key` obtained from `openai.com`.

Exporting an environment variable is one way to set that configuration property.
```shell
export SPRING_AI_OPENAI_API_KEY=<INSERT KEY HERE>

export SPRING_AI_OPENAI_API_KEY=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
```

## Building and running

```
./mvnw spring-boot:run
```

## Access the endpoint

To get a response to the default request of "Tell me a joke"

```shell 
curl http://localhost:8080/ai/simple
```

A sample response is 

```text
Sure, here's a classic one for you:

Why don't scientists trust atoms?

Because they make up everything!
```

Now using the `message` request parameter
```shell
curl --get  --data-urlencode 'message=Tell me a joke about a cow.' http://localhost:8080/ai/simple 
```

A sample response is

```text
Why did the cow go to space?

Because it wanted to see the mooooon!
```

Alternatively use the `httpie` clinet
```shell
http 
```

# Simple Spring AI Application with OpenAI

This project contains a web service that will accept HTTP GET requests at
`http://localhost:8080/ai/simple`

There is optional `message` parameter whose default value is "Tell me a joke".

The response to the request is from the Azure OpenAI Service.

Look at the section below on **prerequisites** before continuing

## Building and running

```
./mvnw spring-boot:run
```

## Access the endpoint

To get a response for a funny joke about a cow.

```shell
$ http GET localhost:8080/ai/prompt?adjective=funny?topic=cow
```

A sample response is

```json
{
    "info": {},
    "text": "Why did the cow go to outer space? \n\nTo see the moooon!"
}
```

## Prerequisite

Obtain your Azure OpenAI `endpoint` and `api-key` from the Azure OpenAI Service section on [Azure Portal](https://portal.azure.com)

The Spring AI project defines a configuration property named `spring.ai.azure.openai.api-key` that you should set to the value of the `API Key` obtained from Azure.

Exporting an environment variables is one way to set these configuration properties.
```shell
export SPRING_AI_AZURE_OPENAI_API_KEY=<INSERT KEY HERE>
export SPRING_AI_AZURE_OPENAI_ENDPOINT=<INSERT ENDPOINT URL HERE>
```

