package org.example;

public class Clients {

    private int id;
    private String name;

    public Clients(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Clients(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
