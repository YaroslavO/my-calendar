package com.yaroslav.other.calendar;

import java.io.*;

/**
 * Created by employee on 5/21/15.
 */
public class FileManager {

    public void makeFile(String fileName, String content) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
