package ua.sviatik.entity;

public class RacerTime {
    private final Racer racer;
    private final ParsedTimeDate startParsedTimeDate;
    private final ParsedTimeDate endParsedTimeDate;

    public RacerTime(Racer racer, ParsedTimeDate startParsedTimeDate, ParsedTimeDate endParsedTimeDate) {
        this.racer = racer;
        this.startParsedTimeDate = startParsedTimeDate;
        this.endParsedTimeDate = endParsedTimeDate;
    }

    public Racer getRacer() {
        return racer;
    }

    public ParsedTimeDate getStartParsedTimeDate() {
        return startParsedTimeDate;
    }

    public ParsedTimeDate getEndParsedTimeDate() {
        return endParsedTimeDate;
    }
}
