package com.example.ideabox.User;

public class User {

    private long id;
    private String name;
    private String company;

    //  Constructor ---
    public User(){}

    public User(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public User(long id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }


    // Getter Setter ---
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // Build in
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
