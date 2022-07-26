package com.learning.csv.writer.service;

import com.learning.csv.writer.entiy.Interaction;
import com.learning.csv.writer.entiy.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import static org.mockito.Mockito.*;

class CSVConverterTest {
    private static final Interaction INTERACTION = new Interaction("1", Time.valueOf(LocalTime.now().minusHours(1)),
            Time.valueOf(LocalTime.now()), "src/java/com/learning",
            "HP", List.of("1", "2", "3"));
    private static final Person ANTOHA = new Person(1, "Antoha", "MC", 15);
    private static final Person MAX = new Person(2, "Max", "Last", 43);
    private static final Person VICTOR = new Person(3, "Victor", "Shtil", 32);
    String expectedPersonHeader = "id,firstName,lastName,age";
    String expectedInteractionHeader = "id,startTime,stopTime,archivingLocation,initiator,participants";
    List<Interaction> list;

//    @InjectMocks
    private WriterFactory writerFactory;
    private CSVWriter csvWriter;
    Converter converter;

    @BeforeEach
    public void setUp() throws Exception {
        this.writerFactory = Mockito.mock(WriterFactory.class);
        this.csvWriter = mock(CSVWriter.class);
        this.converter = new CSVConverter(writerFactory);
    }

    @Test
    void Check() {
        when(writerFactory.getWriter(ANTOHA)).thenReturn(csvWriter);

        converter.convert(ANTOHA);
        converter.convert(ANTOHA);


        verify(csvWriter, times(2)).write(anyString());
    }

    @Test
    void CheckInteraction() {
        when(writerFactory.getWriter(ANTOHA)).thenReturn(csvWriter);

        converter.convert(ANTOHA);
        converter.convert(ANTOHA);


        verify(csvWriter, times(2)).write(anyString());
    }

}