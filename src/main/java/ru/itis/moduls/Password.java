package ru.itis.moduls;

public class Password {
    private int id;
    private String badPassword;

    public Password(String badPassword) {
        this.badPassword = badPassword;
    }

    public Password(int id, String badPassword) {
        this.id = id;
        this.badPassword = badPassword;
    }

    public int getId() {
        return id;
    }

    public String getBadPassword() {
        return badPassword;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBadPassword(String badPassword) {
        this.badPassword = badPassword;
    }
}
