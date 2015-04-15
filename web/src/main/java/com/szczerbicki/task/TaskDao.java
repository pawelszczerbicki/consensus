package com.szczerbicki.task;

import com.szczerbicki.generic.GenericDao;
import org.springframework.stereotype.Repository;

/**
 * Created by pawel on 15.04.15.
 */
@Repository
public class TaskDao extends GenericDao<Task> {

    public TaskDao() {
        super(Task.class);
    }
}
