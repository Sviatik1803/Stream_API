package ua.sviatik;

import ua.sviatik.entity.ParsedTimeDate;
import ua.sviatik.entity.Racer;
import ua.sviatik.entity.RacerTime;
import ua.sviatik.reader.impl.AbbreviationsFileReader;
import ua.sviatik.reader.impl.TimeDateFileReader;
import ua.sviatik.util.CountLapTime;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacersUtils {
    private final AbbreviationsFileReader abbreviationsFileReader;
    private final TimeDateFileReader timeDateFileReader;

    public RacersUtils(AbbreviationsFileReader abbreviationsFileReader, TimeDateFileReader timeDateFileReader) {
        this.abbreviationsFileReader = abbreviationsFileReader;
        this.timeDateFileReader = timeDateFileReader;
    }

    public Map<RacerTime, String> getLeaderBoard(String abbr, String start, String end) {
        List<Racer> racers = abbreviationsFileReader.readFile(abbr).stream()
                .map(Racer.class::cast)
                .collect(Collectors.toList());

        List<ParsedTimeDate> startTimes = timeDateFileReader.readFile(start).stream()
                .map(ParsedTimeDate.class::cast)
                .collect(Collectors.toList());

        List<ParsedTimeDate> endTimes = timeDateFileReader.readFile(end).stream()
                .map(ParsedTimeDate.class::cast)
                .collect(Collectors.toList());


        List<RacerTime> racerTimeList = makeRacerTimeList(racers, startTimes, endTimes);

        Map<RacerTime, String> map = racerTimeList.stream()
                .collect(Collectors.toMap(racerTime -> racerTime,
                        CountLapTime::countLapTime));

        map = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return map;
    }


    private List<RacerTime> makeRacerTimeList(List<Racer> racers, List<ParsedTimeDate> startTimeDates, List<ParsedTimeDate> endTimeDates) {
        return racers.stream()
                .map(el -> {
                    ParsedTimeDate startTimeDate = findTimeByAbbreviation(startTimeDates, el.getAbbreviation());
                    ParsedTimeDate endTimeDate = findTimeByAbbreviation(endTimeDates, el.getAbbreviation());
                    return new RacerTime(el, startTimeDate, endTimeDate);
                }).collect(Collectors.toList());
    }

    private ParsedTimeDate findTimeByAbbreviation(List<ParsedTimeDate> parsedTimeDateList, String abbreviation) {
        List<ParsedTimeDate> oneElementList = parsedTimeDateList.stream()
                .filter(parsedTimeDate -> parsedTimeDate.getAbbreviations().equals(abbreviation))
                .collect(Collectors.toList());
        return oneElementList.get(0);
    }


}