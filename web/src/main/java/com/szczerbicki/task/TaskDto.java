package com.szczerbicki.task;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by pawel on 15.04.15.
 */
public class TaskDto {

    private String id;

    private String name;

    private String fileName;

    private Double progress;

    private MultipartFile dataFile;

    public TaskDto() {
    }

    public TaskDto(Task t) {
        this.id = t.getId();
        this.name = t.getName();
        this.fileName = t.getFile().getName();
        this.progress = (double) t.getProceeded() / t.getOverallAmount();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public MultipartFile getDataFile() {
        return dataFile;
    }

    public void setDataFile(MultipartFile dataFile) {
        this.dataFile = dataFile;
    }
}
