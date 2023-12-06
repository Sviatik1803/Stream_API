package ua.sviatik.util;

import ua.sviatik.entity.RacerTime;

import java.time.Duration;


public class CountLapTime {
    public static String countLapTime(RacerTime racerLapTime) {
        Duration duration = Duration.between(
                racerLapTime.getStartParsedTimeDate().getLocalDateTime(),
                racerLapTime.getEndParsedTimeDate().getLocalDateTime());
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.toSeconds() % 60;
        long mls = duration.toMillis() % 1000;

        return minutes + ":" + seconds + "." + mls;
    }
}
