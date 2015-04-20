package com.szczerbicki.json;

/**
 * Created by pawel on 25.03.15.
 */
public class FailResponse<T> extends JsonResponse<T> {

    public static final String FAIL = "fail";

    private FailResponse() {
        this(null);
    }

    private FailResponse(T data) {
        super(data, FAIL);
    }

    public static <T> FailResponse<T> create(T data) {
        return new FailResponse<>(data);
    }

    public static <T> FailResponse<T> create() {
        return new FailResponse<>();
    }
}
