package com.learning.csv.writer.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class CSVWriter implements Writer {
    private String path;

    public CSVWriter(String path) {
        this.path = path;
    }

    @Override
    public void write(String str) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));) {
            writer.write(str);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
