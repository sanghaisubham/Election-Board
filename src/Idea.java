
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
        System.out.println("The idea is: "+idea);
    }

    void displayIdeaStats(){
        System.out.println("Idea "+idea);
        for(Map.Entry<String, Integer> rating:ratings.entrySet()){
            System.out.println(rating.getKey()+"\t"+rating.getValue());
        }
    }

    public float getAverageRating(){
        return (float)(totalRating)/(float) (lowRatingCount+highRatingCount);
    }

    void addRating(int rating, Citizen citizen){
        ratings.put(citizen.name,rating);
        totalRating+=rating;
        if(rating<ElectionConstants.HIGH_RATING_THRESHOLD){
            highRatingCount++;
        }
        else{
            lowRatingCount++;
        }
    }

    void removeRating(Citizen citizen){
        int rating = ratings.get(citizen.name);
        ratings.remove(citizen);
        totalRating-=rating;
        if(rating<ElectionConstants.HIGH_RATING_THRESHOLD){
            highRatingCount--;
        }
        else{
            lowRatingCount--;
        }
    }
}
