
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
        System.out.println("----------");
        for(Map.Entry<String, Integer> rating:ratings.entrySet()){
            System.out.println(rating.getKey()+"\t"+rating.getValue());
        }
        System.out.println("");
        System.out.println("Low rating count: "+lowRatingCount);
        System.out.println("High rating count: "+highRatingCount);
        System.out.println("Total rating: "+totalRating);
    }

    public float getAverageRating(){
        return (float)(totalRating)/(float) (lowRatingCount+highRatingCount);
    }

    void addRating(int rating, Citizen citizen){
        ratings.put(citizen.name,rating);
        totalRating+=rating;
        if(rating<ElectionConstants.GOOD_IDEA_THRESHOLD){
            lowRatingCount++;
        }
        else{
            highRatingCount++;
        }
    }

    void removeRating(Citizen citizen){
        if(!ratings.containsKey(citizen.name)){
            System.out.println("Citizen "+citizen+" does not have a rating for the idea");
            return;
        }
        int rating = ratings.get(citizen.name);
        ratings.remove(citizen.name);
        totalRating-=rating;
        if(rating<ElectionConstants.GOOD_IDEA_THRESHOLD){
            lowRatingCount--;
        }
        else{
            highRatingCount--;
        }
    }
}
