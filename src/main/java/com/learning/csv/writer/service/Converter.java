package com.learning.csv.writer.service;


import com.learning.csv.writer.entiy.AllowToWrite;
import com.learning.csv.writer.entiy.Person;

public interface Converter {
    void convert(AllowToWrite... objects);
}
