import java.util.List;

public class Manifesto {
    private List<Idea> ideas;

    public Manifesto(List<Idea> ideas){
        this.ideas = ideas;
    }

    public List<Idea> getIdeas() {
        return ideas;
    }

    public float getTotalRating(){
        float totalRating= 0.0F;
        for(Idea idea:ideas) {
            totalRating += idea.getAverageRating();
        }
        return totalRating;
    }

    public boolean isAcceptedManifesto(){
        for(Idea idea:ideas){
            if(idea.lowRatingCount>ElectionConstants.MANIFESTO_ACCEPTANCE_COUNT){
                return false;
            }
        }
        return true;
    }

    void displayManifesto(){
        System.out.println("The Manifesto contains the following ideas");
        int ideaCount= 1;
        for(Idea idea:ideas){
            System.out.println("Idea "+ideaCount++);
            System.out.println("----------");
            idea.displayIdea();
        }
    }

    void displayManifestoStats(){
       for(Idea idea:ideas){
           idea.displayIdeaStats();
       }
    }

    public void addIdea(Idea idea){
        List<Idea> ideas = this.ideas;

        if(ideas.size()==ElectionConstants.MAX_IDEA_COUNT){
            System.out.println("Already 3 ideas are added");
        }
        else{
            ideas.add(idea);
        }
    }
}
