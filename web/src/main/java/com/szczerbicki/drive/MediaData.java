package com.szczerbicki.drive;

import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Pawel on 2014-07-23.
 */
public class MediaData {

    private String id;

    @Transient
    private byte[] bytes;

    private String name;

    private String url;

    private long size;

    public MediaData(MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
        this.name = file.getOriginalFilename();
        this.size = file.getSize();
    }

    public MediaData() {
    }

    public byte[] getBytes() {
        return bytes;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public MediaData setUrl(String url) {
        this.url = url;
        return this;
    }
}
