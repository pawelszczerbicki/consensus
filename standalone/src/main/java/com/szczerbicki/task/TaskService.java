package com.szczerbicki.task;

import com.szczerbicki.rest.RestClient;
import com.szczerbicki.utils.Keys;

import java.util.Optional;

import static java.lang.Integer.parseInt;

/**
 * Created by pawel on 20.04.15.
 */
public class TaskService {
    private RestClient client = new RestClient();

    public Optional<TaskDto> getFirst() {
        return client.get(Keys.TASK_URL);
    }

    public Integer[][] getData(TaskDto t){
        return toIntArray(client.fileAsString(t.getFileUrl()));
    }

    private Integer[][] toIntArray(String s) {
        String[] lines = s.split("\n");
        Integer[][] out = new Integer[lines.length][2];
        for (int i = 0; i < lines.length; i++) {
            String[] data = lines[i].split(";");
            out[i][0] = parseInt(data[0]);
            out[i][1] = parseInt(data[1]);
        }
        return out;
    }

    public void finished(TaskDto t) {
client.finish(t);
    }
}
