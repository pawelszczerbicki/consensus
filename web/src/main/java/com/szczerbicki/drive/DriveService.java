package com.szczerbicki.drive;

import com.szczerbicki.config.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.szczerbicki.config.Keys.DRIVE_FOLDER_ID;
import static com.szczerbicki.config.Keys.DRIVE_UPLOAD_ENABLED;

/**
 * Created by pawel on 11.04.15.
 */
@Service
public class DriveService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ConfigService config;

    public MediaData store(MediaData media) {
        if (config.propertyAsBoolean(DRIVE_UPLOAD_ENABLED))
            logger.info("Drive upload disabled. exiting");
        else
            try {
                DriveClient client = new DriveClient(config).authorize();
                media.setId(client.send(media.getBytes(), media.getName(), config.property(DRIVE_FOLDER_ID)).getId());
            } catch (IOException e) {
                logger.error("Error during storing file in drive", e);
                return media;
            }
        return media;
    }
}
