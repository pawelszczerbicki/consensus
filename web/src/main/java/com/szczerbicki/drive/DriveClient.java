package com.szczerbicki.drive;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.ParentReference;
import com.szczerbicki.config.ConfigService;

import java.io.IOException;

import static com.szczerbicki.config.Keys.*;
import static java.util.Collections.singletonList;

/**
 * Created by pawel on 11.04.15.
 */
public class DriveClient {

    private ConfigService config;

    private Drive drive;

    private NetHttpTransport t =  new NetHttpTransport();

    private JacksonFactory j = new JacksonFactory();

    public DriveClient(ConfigService config) {
        this.config = config;
    }

    public DriveClient authorize() throws IOException {
        GoogleCredential c = new GoogleCredential.Builder().setTransport(t).setJsonFactory(j)
                .setClientSecrets(config.property(DRIVE_CLIENT_ID), config.property(DRIVE_CLIENT_SECRET)).build()
                .setRefreshToken(config.property(DRIVE_REFRESH_TOKEN));
        c.refreshToken();
        drive = new Drive.Builder(t, j, new GoogleCredential().setAccessToken(c.getAccessToken())).setApplicationName(config.property(DRIVE_APP_NAME)).build();
        return this;
    }

    public File send(byte[] data, String title, String parentFolderId) throws IOException {
        File driveFile = new File()
                .setTitle(title)
                .setParents(singletonList(new ParentReference().setId(parentFolderId)));
        return drive.files().insert(driveFile, new ByteArrayContent("", data)).execute();
    }

    public File createFolder(String name) throws IOException {
        File folder = new File()
                .setTitle(name)
                .setMimeType("application/vnd.google-apps.folder")
                .setParents(singletonList(new ParentReference().setId(config.property(DRIVE_FOLDER_ID))));
        return drive.files().insert(folder).execute();
    }
}
