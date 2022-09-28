package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {

    private UserStory[] dependsOn;
    private int id;
    private String name;
    private int estimate;
    private UserStory [] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id,name,estimate);
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.dependsOn = dependsOn;
    }

    @Override
    public void complete() {
        int count = 0;
        for(Ticket value : dependsOn) {
            if(!value.isCompleted()) {
                count++;
            }
        }
        if(count==0) {super.complete();}
    }

    public UserStory[] getDependencies() {

        dependencies = new UserStory[dependsOn.length];
        System.arraycopy(dependsOn, 0, dependencies, 0, dependsOn.length);
        return dependencies;
    }

    @Override
    public String toString() {
    return ("[US "+id+"] "+name);
    }
}
