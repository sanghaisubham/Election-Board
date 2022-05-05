package domain;

import service.ConsoleUtility;

public class Citizen {
    public String name;

    public Citizen(String name){
        this.name=name;
    }

    public void rateIdea(Idea idea, int rating){
        idea.addRating(rating,this);
    }

    public void unRateIdea(Idea idea){
        idea.removeRating(this);
    }

    void displayCitizen(){
        ConsoleUtility.log("Citizen Name:"+name);
    }

}
