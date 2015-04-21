package com.szczerbicki.json;

import com.szczerbicki.task.TaskDto;

/**
 * Created by pawel on 25.03.15.
 */
public class FailResponse extends JsonResponse {

    public static final String FAIL = "fail";

    private FailResponse() {
        this(null);
    }

    private FailResponse(TaskDto data) {
        super(data, FAIL);
    }

    public static FailResponse create(TaskDto data) {
        return new FailResponse(data);
    }

    public static  FailResponse create() {
        return new FailResponse();
    }
}
