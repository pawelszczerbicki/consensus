package com.szczerbicki.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import static com.szczerbicki.utils.Keys.DRIVE_URL;
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

    private Long proceedTimeMillis;

    private boolean finished;

    @JsonIgnore
    private MultipartFile file;

    public TaskDto() {
    }

    public TaskDto(String id, String name, String fileName, String fileId, int proceeded, int overallAmount, int cores, boolean finished) {
        this.id = id;
        this.name = name;
        this.fileName = fileName;
        this.progress = (double) proceeded / (overallAmount == 0 ? 1 : overallAmount);
        this.cores = cores;
        this.finished = finished;
        this.fileUrl = format(DRIVE_URL, fileId);
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

    public Long getProceedTimeMillis() {
        return proceedTimeMillis;
    }

    public void setProceedTimeMillis(Long proceedTimeMillis) {
        this.proceedTimeMillis = proceedTimeMillis;
    }
}
