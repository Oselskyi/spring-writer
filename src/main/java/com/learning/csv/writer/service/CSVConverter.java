package com.learning.csv.writer.service;

import com.learning.csv.writer.entiy.AllowToWrite;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CSVConverter implements Converter {

    private Writer writer;

    private final WriterFactory writerFactory;

    public CSVConverter(WriterFactory writerFactory) {
        this.writerFactory = writerFactory;
    }

    @Override
    public final void convert(AllowToWrite... objects) {

        StringBuilder sb = new StringBuilder();
        String header = getHeader(objects[0]);

        String path = objects[0].getClass().getSimpleName() + ".csv";
        writer = writerFactory.getWriter(objects[0]);

        Arrays.stream(objects)
                .forEach(m -> {
                    sb.append(m);
                    sb.append('\n');
                });

        if (!Files.exists(Path.of(path))) {
            writer.write(header);
        }

        writer.write(sb.toString());
    }


    private String getHeader(AllowToWrite obj) {

        Field[] fields = obj.getClass().getDeclaredFields();

        return Arrays.stream(fields)
                .map(Field::getName)
                .collect(Collectors.joining(",", "", "\n"));
    }

}
