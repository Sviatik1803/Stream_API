package ua.sviatik.reader.impl;

import ua.sviatik.entity.Racer;
import ua.sviatik.reader.FileReader;
import ua.sviatik.util.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AbbreviationsFileReader implements FileReader {
    @Override
    public List<Object> readFile(String file) {
        Reader reader = new Reader();
        List<String> list = new ArrayList<>(reader.readFileLineByLine(file));
        List<String[]> arrayList = list.stream()
                .map(x -> x.split("_"))
                .collect(Collectors.toList());

        List<Object> listAbbreviations = new ArrayList<>();
        for (String[] strings : arrayList) {
            listAbbreviations.add(new Racer(strings[0], strings[1], strings[2]));
        }

        return listAbbreviations;
    }

}
