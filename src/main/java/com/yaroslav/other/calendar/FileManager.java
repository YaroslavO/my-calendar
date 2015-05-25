package com.yaroslav.other.calendar;

import java.io.*;
import java.nio.file.Files;

/**
 * Created by Yaroslav on 21.05.2015.
 */
public class FileManager {

    public void saveToFile(String fileName, String content) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName), "utf-8"))) {
                writer.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile(String fileName) {

        return " ";
    }

    private void createUploadDirIfNotExist(String pathToDir) {
        File dir = new File(pathToDir);
        if (!dir.exists()) {
            try {
                Files.createDirectories(dir.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
