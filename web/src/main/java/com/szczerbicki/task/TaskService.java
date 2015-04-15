package com.szczerbicki.task;

import com.szczerbicki.drive.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pawel on 15.04.15.
 */
@Service
public class TaskService {

    @Autowired
    private TaskDao dao;

    @Autowired
    private DriveService drive;

    public void saveNewTask(TaskDto dto) {
        Task t = new Task(dto);
        drive.store(t.getFile());
        dao.save(t);
    }
}
