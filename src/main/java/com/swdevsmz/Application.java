package com.swdevsmz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.SerializationHint;

import com.swdevsmz.entity.User;
import com.swdevsmz.model.Request;
import com.swdevsmz.model.Response;

@NativeHint
@SerializationHint(types = { Request.class, Response.class, User.class })
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
