package com.learning.csv.writer.service;

import com.learning.csv.writer.entiy.AllowToWrite;
import com.learning.csv.writer.entiy.Interaction;
import com.learning.csv.writer.entiy.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriterFactoryTest {

    WriterFactory writerFactory;
    CSVWriter csvWriter;
    AllowToWrite object;

    @BeforeEach
    void prepare(){
        this.writerFactory = new WriterFactory();
    }

    @Test
    void CheckPathIOfObjectInstanceOfPerson() {
        object = new Person();
        writerFactory.getWriter(object);

        String actualPath = writerFactory.getPath();
        assertEquals("Person" , actualPath);
    }

    @Test
    void CheckPathIOfObjectInstanceOfInteraction() {
        object = new Interaction();
        writerFactory.getWriter(object);

        String actualPath = writerFactory.getPath();
        assertEquals("Interaction" , actualPath);

    }

    @Test
    void checkWriterIfSendPerson(){
        object = new Person();
        Writer writer = writerFactory.getWriter(object);
        csvWriter = new CSVWriter("Person.csv");
        assertEquals(csvWriter , writer);
    }
    @Test
    void checkWriterIfSendInteraction(){
        object = new Interaction();
        Writer writer = writerFactory.getWriter(object);
        csvWriter = new CSVWriter("Interaction.csv");
        assertEquals(csvWriter , writer);
    }
}