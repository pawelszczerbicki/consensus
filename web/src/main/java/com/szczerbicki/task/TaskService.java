package com.szczerbicki.task;

import com.szczerbicki.drive.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

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

    public List<TaskDto> getAll() {
        return dao.findAll().stream().map(this::toDto).collect(toList());
    }

    public TaskDto get(String id) {
        return toDto(dao.findOne(id).get());
    }

    public Optional<Task> getFirstUnfinished() {
        return dao.getFirstUnfinished();
    }

    private TaskDto toDto(Task t) {
        return new TaskDto(t.getId(), t.getName(), t.getFile().getName(), t.getFile().getId(), t.getProceeded(), t.getOverallAmount(), t.getCores(), t.isFinished());
    }

    public void finishTask(TaskDto dto) {
        Task t = dao.findOne(dto.getId()).get();
        t.setFinished(dto.isFinished());
        t.setTimeMillis(dto.getProceedTimeMillis());
        dao.save(t);
    }
}
