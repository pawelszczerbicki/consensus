package com.szczerbicki.json;

import com.szczerbicki.task.TaskDto;

/**
 * Created by pawel on 25.03.15.
 */
public class SuccessResponse extends JsonResponse {

    public static final String SUCCESS = "success";

    public SuccessResponse() {
        this(null);
    }

    private SuccessResponse(TaskDto data) {
        super(data, SUCCESS);
    }

    public static SuccessResponse create(TaskDto data) {
        return new SuccessResponse(data);
    }

    public static SuccessResponse create() {
        return new SuccessResponse();
    }
}
