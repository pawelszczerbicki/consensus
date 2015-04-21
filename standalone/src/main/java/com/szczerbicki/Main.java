package com.szczerbicki;

import com.szczerbicki.task.TaskService;
import com.szczerbicki.task.TaskWorker;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello clustering");
        new TaskWorker(new TaskService()).start();
    }
}