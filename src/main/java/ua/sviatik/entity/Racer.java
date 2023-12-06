package ua.sviatik.entity;


public class Racer {
    private final String abbreviation;
    private final String name;
    private final String teamName;

    public Racer(String abbreviation, String name, String teamName) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
