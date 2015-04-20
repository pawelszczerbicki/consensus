package com.szczerbicki.task;

import com.szczerbicki.generic.GenericDao;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by pawel on 15.04.15.
 */
@Repository
public class TaskDao extends GenericDao<Task> {

    public TaskDao() {
        super(Task.class);
    }

    public Optional<Task> getFirstUnfinished() {
        return ofNullable(mongo.findOne(query(where("finished").is(false)), clazz));
    }
}
