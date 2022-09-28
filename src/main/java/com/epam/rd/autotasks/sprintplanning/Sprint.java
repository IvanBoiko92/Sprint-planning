package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {
    public int capacity;
    public int e;
    public int t;
    public int ticketsLimit;
    Ticket [] tickets;
    //public int pos = tickets.length;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        tickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {

        if ((userStory != null)&&(!userStory.isCompleted())&&(e+userStory.getEstimate()  <= capacity)&&(t < ticketsLimit)&& checkAllDependenciesAdded(userStory)){
            tickets [t++] = userStory;
            e += userStory.getEstimate();
            return true;
        }

        return false;
    }

    private boolean checkAllDependenciesAdded(UserStory userStory){
        for (UserStory dependent:userStory.getDependencies()){
            if (dependent.isCompleted() == false){
                boolean contains = false;
                for (int i = 0; i < t; i++){
                    if (tickets[i].equals(dependent)){
                        contains = true;
                    }
                }
                if (contains == false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean addBug(Bug bugReport) {

        if ((bugReport != null)&&(!bugReport.isCompleted())&&(t < ticketsLimit)&&(e+bugReport.getEstimate() < capacity)){
            tickets [t++] = bugReport;
            e += bugReport.getEstimate();
            return true;
        }
        return false;
    }

    public Ticket[] getTickets() {
        int countLength = 0;
        for (Ticket value : tickets) {
            if (value != null) {
                countLength++;
            }
        }
        Ticket[] newArray = Arrays.copyOf(tickets, countLength);
        return newArray;
    }

    public int getTotalEstimate() {
        return e;
    }


}
