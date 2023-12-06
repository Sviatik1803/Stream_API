package ua.sviatik.entity;

import java.time.LocalDateTime;

public class ParsedTimeDate {
    private final String abbreviations;
    private final LocalDateTime localDateTime;


    public ParsedTimeDate(String abbreviations, LocalDateTime localDateTime) {
        this.abbreviations = abbreviations;
        this.localDateTime = localDateTime;
    }

    public String getAbbreviations() {
        return abbreviations;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
