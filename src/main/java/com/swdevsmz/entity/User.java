package com.swdevsmz.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class User implements Serializable {
    private String userId;
    private Long timestamp;
    private List<String> participants;
    private Map<String, Integer> results;

    public User() {
    }

    public User(String userId, Long timestamp, List<String> participants, Map<String, Integer> results) {
        this.userId = userId;
        this.timestamp = timestamp;
        this.participants = participants;
        this.results = results;
    }

    public static User from(Map<String, AttributeValue> values) {
        User user = new User();

        user.setUserId(values.get("userId").s());
        // user.setTimestamp(Long.parseLong(values.get("timestamp").n()));
        // user.setParticipants(values.get("participants").ss());

        // Map<String, AttributeValue> resultValues = values.get("results").m();
        // Map<String, Integer> results = new HashMap<>();

        // resultValues.forEach((k, v) -> results.put(k, Integer.parseInt(v.n())));
        // user.setResults(results);

        return user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public Map<String, Integer> getResults() {
        return results;
    }

    public void setResults(Map<String, Integer> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", timestamp=" + timestamp +
                ", participants=" + participants +
                ", results=" + results +
                '}';
    }
}
