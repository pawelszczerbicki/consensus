package com.szczerbicki.json;

/**
 * Created by pawel on 25.03.15.
 */
public abstract class JsonResponse<T> {

    private String status;

    private T data;

    public JsonResponse(T data, String status) {
        this.data = data;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
}
