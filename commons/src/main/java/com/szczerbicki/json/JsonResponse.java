package com.szczerbicki.json;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.szczerbicki.task.TaskDto;

/**
 * Created by pawel on 25.03.15.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "status")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FailResponse.class, name = FailResponse.FAIL),
        @JsonSubTypes.Type(value = SuccessResponse.class, name = SuccessResponse.SUCCESS),
})
public abstract class JsonResponse {

    private String status;

    private TaskDto data;

    public JsonResponse(TaskDto data, String status) {
        this.data = data;
        this.status = status;
    }

    public TaskDto getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
}
