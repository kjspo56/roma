package com.board.roma.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL) // 1
@AllArgsConstructor(access = AccessLevel.PRIVATE) // 2
@Getter // 3
public class Response {
    private boolean success;
    private int code;
    private Result result;

    public static Response success() { // 4
        return new Response(true, 0, null);
    }

    public static <T> Response success(T data) { // 5
        return new Response(true, 0, new Success<>(data));
    }

    public static Response failure(int code, String msg) { // 6
        return new Response(false, code, new Failure(msg));
    }
}
