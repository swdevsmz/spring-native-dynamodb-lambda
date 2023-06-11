package com.swdevsmz.model;

import java.io.Serializable;
import java.util.List;

import com.swdevsmz.entity.User;

public class Response implements Serializable {
    private List<User> sessions;

    public Response() {
    }

    public Response(List<User> sessions) {
        this.sessions = sessions;
    }

    public List<User> getSessions() {
        return sessions;
    }

    public void setSessions(List<User> sessions) {
        this.sessions = sessions;
    }
}
