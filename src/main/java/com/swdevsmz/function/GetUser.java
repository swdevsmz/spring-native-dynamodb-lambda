package com.swdevsmz.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.swdevsmz.entity.User;
import com.swdevsmz.model.Request;
import com.swdevsmz.model.Response;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;

@Component
public class GetUser implements Function<Request, Response> {

    private final String tableName;
    private final DynamoDbClient dynamoDbClient;

    public GetUser(String tableName, DynamoDbClient dynamoDbClient) {
        this.tableName = tableName;
        this.dynamoDbClient = dynamoDbClient;
    }

    @Override
    public Response apply(Request request) {
        String userId = request.getUserId().toLowerCase();

        Map<String, AttributeValue> expressionValues = new HashMap<>();
        expressionValues.put(":userId", AttributeValue.builder().s(userId).build());

        QueryRequest queryRequest = QueryRequest.builder()
                .tableName(tableName)
                .keyConditionExpression("userId = :userId")
                .expressionAttributeValues(expressionValues).build();

        List<Map<String, AttributeValue>> queryResponse = dynamoDbClient.query(queryRequest).items();

        List<User> users = queryResponse.isEmpty() ? List.of()
                : queryResponse.stream()
                        .map(User::from)
                        .collect(Collectors.toList());

        return new Response(users);
    }
}