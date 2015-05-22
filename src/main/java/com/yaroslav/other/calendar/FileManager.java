package com.yaroslav.other.calendar;

import java.io.*;

/**
 * Created by Yaroslav on 21.05.2015.
 */
public class FileManager {

    public void saveToFile(String fileName, String content) {
        try {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName), "utf-8"))) {
                writer.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
