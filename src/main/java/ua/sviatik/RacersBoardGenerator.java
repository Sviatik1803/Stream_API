package ua.sviatik;

import ua.sviatik.entity.RacerTime;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacersBoardGenerator {
    public String outputRacersBoard(Map<RacerTime, String> map) {
        return String.join("\n", makeListOfString(map));
    }

    private List<String> makeListOfString(Map<RacerTime, String> map) {
        int maxNameSize = getMaxNameSize(map);
        int teamNameSize = getMaxTeamNameSize(map);
        return map.keySet().stream()
                .map(key -> key.getRacer().getName() + getSpaces(maxNameSize, key.getRacer().getName()) + "|" + key.getRacer().getTeamName()
                        + getSpaces(teamNameSize, key.getRacer().getTeamName()) + "|" + map.get(key))
                .collect(Collectors.toList());
    }

    private Integer getMaxNameSize(Map<RacerTime, String> map) {
        return map.keySet().stream().map(key -> key.getRacer().getName().length()).sorted(Comparator.reverseOrder()).limit(1).
                collect(Collectors.toList()).get(0);
    }

    private Integer getMaxTeamNameSize(Map<RacerTime, String> map) {
        return map.keySet().stream().map(key -> key.getRacer().getTeamName().length()).sorted(Comparator.reverseOrder()).limit(1).
                collect(Collectors.toList()).get(0);
    }

    private String getSpaces(Integer maxSize, String str) {
        return " ".repeat(maxSize - str.length());
    }

}
