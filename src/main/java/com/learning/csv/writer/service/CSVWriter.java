package com.learning.csv.writer.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


public class CSVWriter implements Writer {
    private String path;

    public CSVWriter(String path) {
        this.path = path;
    }

    @Override
    public void write(String str) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(str);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CSVWriter csvWriter = (CSVWriter) o;
        return Objects.equals(path, csvWriter.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }
}
