package kr.com.djam.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final String name;
    private final String location;
    private final Long id;
    private List<MenuItem> menuItems = new ArrayList<>();

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

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItem(List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems ) {
            addMenuItem(menuItem);
        }
    }
}
