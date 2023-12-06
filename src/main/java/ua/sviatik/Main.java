package ua.sviatik;

import ua.sviatik.entity.RacerTime;
import ua.sviatik.reader.impl.AbbreviationsFileReader;
import ua.sviatik.reader.impl.TimeDateFileReader;

import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File abbreviations = new File("src/main/resources/abbreviations.txt");
        File start = new File("src/main/resources/start.log");
        File end = new File("src/main/resources/end.log");

        RacersUtils racersUtils = new RacersUtils(new AbbreviationsFileReader(), new TimeDateFileReader());
        Map<RacerTime, String> map = racersUtils.getLeaderBoard(abbreviations.getAbsolutePath(),
                start.getAbsolutePath(), end.getAbsolutePath());

        RacersBoardGenerator racersBoardGenerator = new RacersBoardGenerator();
        System.out.println(racersBoardGenerator.outputRacersBoard(map));


    }
}