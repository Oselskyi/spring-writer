package com.learning.csv.writer.service;

import com.learning.csv.writer.entiy.AllowToWrite;
import com.learning.csv.writer.entiy.Interaction;
import com.learning.csv.writer.entiy.Person;

public class WriterFactory {
    private String path = " ";
    public Writer getWriter(AllowToWrite object){

        if (object instanceof Person){
            path = object.getClass().getSimpleName();
        } else if (object instanceof Interaction){
            path = object.getClass().getSimpleName();
        }

        return new CSVWriter(path + ".csv");
    }

    public String getPath() {
        return path;
    }
}
