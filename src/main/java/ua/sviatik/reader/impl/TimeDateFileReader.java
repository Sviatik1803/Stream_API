package ua.sviatik.reader.impl;

import ua.sviatik.entity.ParsedTimeDate;
import ua.sviatik.reader.FileReader;
import ua.sviatik.util.Reader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimeDateFileReader implements FileReader {
    @Override
    public List<Object> readFile(String file) {
        Reader reader = new Reader();
        List<String> list = new ArrayList<>(reader.readFileLineByLine(file));

        return list.stream()
                .map(str -> {
                    String abbreviation = str.substring(0, 3);
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
                    LocalDateTime localDateTime = LocalDateTime.parse(str.substring(3), dateTimeFormatter);
                    return new ParsedTimeDate(abbreviation, localDateTime);
                })
                .collect(Collectors.toList());
    }
}
