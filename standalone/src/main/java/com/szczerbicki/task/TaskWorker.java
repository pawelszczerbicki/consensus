package com.szczerbicki.task;

import com.szczerbicki.Consensus;
import org.apache.log4j.Logger;

import java.util.Optional;

import static java.lang.System.currentTimeMillis;

/**
 * Created by pawel on 20.04.15.
 */
public class TaskWorker {
    private final Logger logger = Logger.getLogger(getClass());

    private static final int SIZE = 2000;
    private static final int MAX = 1000;
    private static final int GROUPS_AMOUNT = 3;

    private TaskService service;

    public TaskWorker(TaskService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
            Optional<TaskDto> task = service.getFirst();
            if (task.isPresent())
                serviceTask(task.get());
            else
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    logger.error("Can not sleep", e);
                }
        }
    }

    private void serviceTask(TaskDto t) {
        logger.info("New task, starting " + t.getName());
        run(service.getData(t), t);
        service.finished(t);
    }

    private void run(Integer[][] data, TaskDto t) {
        Consensus consensus = new Consensus(data, SIZE, GROUPS_AMOUNT, MAX, 0, t.getCores());
        long start = currentTimeMillis();
        consensus.start(32, 2);
        t.setProceedTimeMillis(currentTimeMillis() - start);
        t.setFinished(true);
        logger.info("Threads: " + t.getCores() + ", time [ms]: " + t.getProceedTimeMillis());
    }
}
