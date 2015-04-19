package com.szczerbicki.task;

import com.szczerbicki.config.Keys;
import org.springframework.web.multipart.MultipartFile;

import static java.lang.String.format;

/**
 * Created by pawel on 15.04.15.
 */
public class TaskDto {

    private String id;

    private String name;

    private String fileName;

    private String fileUrl;

    private Double progress;

    private Integer cores = 0;

    private boolean finished;

    private MultipartFile file;

    public TaskDto() {
    }

    public TaskDto(Task t) {
        this.id = t.getId();
        this.name = t.getName();
        this.fileName = t.getFile().getName();
        this.progress = (double) t.getProceeded() / (t.getOverallAmount() == 0 ? 1 : t.getOverallAmount());
        this.cores = t.getCores();
        this.finished = t.isFinished();
        this.fileUrl = format(Keys.DRIVE_URL, t.getFile().getId());
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
