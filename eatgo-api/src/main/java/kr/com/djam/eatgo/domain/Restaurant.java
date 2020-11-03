package kr.com.djam.eatgo.domain;

public class Restaurant {

    private final String name;
    private final String location;
    private final Long id;

    public Restaurant(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return location;
    }

    public String getInformation() {
        return name+" in "+location;
    }

    public Long getId() { return id;}
}
