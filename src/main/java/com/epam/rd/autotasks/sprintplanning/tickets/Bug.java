package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {
    private int id;
    private String name;
    private int estimate;
    private UserStory userStory;

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.userStory = userStory;
    }

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {

        if (userStory == null || userStory.isCompleted()) {
            return new Bug(id, name, estimate, userStory);
        }
        return null;
    }

    @Override
    public String toString() {
        return ("[Bug " + id + "]" + " " + userStory.getName() + ": " + name);
    }
}
