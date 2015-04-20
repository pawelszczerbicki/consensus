package com.szczerbicki.task;

import com.szczerbicki.drive.MediaData;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.IOException;

/**
 * Created by pawel on 14.04.15.
 */
@Document
public class Task {

    @Id
    private String id;

    private String name;

    private MediaData file;

    private Integer overallAmount = 0;

    private Integer proceeded = 0;

    private Integer cores = 0;

    private Long timeMillis = 0l;

    private boolean finished;

    public Task() {
    }

    public Task(TaskDto dto) {
        this.name = dto.getName();
        this.finished = dto.isFinished();
        try {
            this.file = new MediaData(dto.getFile());
        } catch (IOException e) {
            throw new IllegalStateException("Can not create media data from multipart file");
        }
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

    public Integer getOverallAmount() {
        return overallAmount;
    }

    public void setOverallAmount(Integer overallAmount) {
        this.overallAmount = overallAmount;
    }

    public Integer getProceeded() {
        return proceeded;
    }

    public void setProceeded(Integer proceeded) {
        this.proceeded = proceeded;
    }

    public MediaData getFile() {
        return file;
    }

    public void setFile(MediaData file) {
        this.file = file;
    }

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Long getTimeMillis() {
        return timeMillis;
    }

    public void setTimeMillis(Long timeSeconds) {
        this.timeMillis = timeSeconds;
    }
}
