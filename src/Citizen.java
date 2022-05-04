public class Citizen {

    protected String name;

    public Citizen(String name){
        this.name=name;
    }

    void rateIdea(Candidate candidate, Idea idea, int rating){
        idea.addRating(rating,this);
        if(rating>ElectionConstants.HIGH_RATING_THRESHOLD){
            candidate.addFollower(this);
        }
    }

    void unRateIdea(Candidate candidate, Idea idea){
        idea.removeRating(this);
    }

    void displayCitizen(){
        System.out.println("Citizen Name:"+name);
    }

    void nominateSelf(){

    }

}
