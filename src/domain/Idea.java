package domain;

import service.ConsoleUtility;

import java.util.HashMap;
import java.util.Map;

public class Idea {
    String idea;
    HashMap<String,Integer> ratings;
    int lowRatingCount;
    int highRatingCount;
    int totalRating;

    public Idea(String idea){
        this.idea=idea;
        this.ratings = new HashMap<>();
        this.lowRatingCount=0;
        this.highRatingCount=0;
        this.totalRating=0;
    }

    void displayIdea(){
        ConsoleUtility.log("The idea is: "+idea);
    }

    void displayIdeaStats(){
        ConsoleUtility.log("Idea "+idea);
        ConsoleUtility.log("----------");
        for(Map.Entry<String, Integer> rating:ratings.entrySet()){
            ConsoleUtility.log(rating.getKey()+"\t"+rating.getValue());
        }
        ConsoleUtility.log("");
        ConsoleUtility.log("Low rating count: "+lowRatingCount);
        ConsoleUtility.log("High rating count: "+highRatingCount);
        ConsoleUtility.log("Total rating: "+totalRating);
        ConsoleUtility.log("Average rating: "+getAverageRating());
    }

    public float getAverageRating(){
        int totalRatingCount = lowRatingCount+highRatingCount;
        if(totalRatingCount==0)
            return 0.0F;
        return (float)(totalRating)/(float) (lowRatingCount+highRatingCount);
    }

    void addRating(int rating, Citizen citizen){
        ratings.put(citizen.name,rating);
        totalRating+=rating;
        if(rating< ElectionConstants.GOOD_IDEA_THRESHOLD){
            lowRatingCount++;
        }
        else{
            highRatingCount++;
        }
    }

    void removeRating(Citizen citizen){
        if(!ratings.containsKey(citizen.name)){
            ConsoleUtility.log("Citizen "+citizen+" does not have a rating for the idea");
            return;
        }
        int rating = ratings.get(citizen.name);
        ratings.remove(citizen.name);
        totalRating-=rating;
        if(rating< ElectionConstants.GOOD_IDEA_THRESHOLD){
            lowRatingCount--;
        }
        else{
            highRatingCount--;
        }
    }
}
