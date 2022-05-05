package domain;

import service.ConsoleUtility;

import java.util.ArrayList;
import java.util.List;

public class Candidate extends Citizen{
    private static int candidateCount=1;

    private int candidateId;
    private String candidateSymbol;
    private Manifesto manifesto;

    private List<Citizen> followers;

    public Candidate(Citizen citizen,String candidateSymbol){
        super(citizen.name);
        this.candidateId=candidateCount++;
        this.candidateSymbol=candidateSymbol;
        this.followers = new ArrayList<>();
    }

    public Manifesto getManifesto() {
        return manifesto;
    }

    public List<Citizen> getFollowers() {
        return followers;
    }

    public boolean isCandidateEligible(){
        return manifesto.isAcceptedManifesto();
    }

    public void addFollower(Citizen follower){
        if(followers.contains(follower)){
            ConsoleUtility.log("The citizen is already a follower");
        }
        else {
            ConsoleUtility.log("Citizen "+follower.name+" is added as a follower of "+this.name);
            followers.add(follower);
        }
    }

    public void addIdea(Idea idea){
       manifesto.addIdea(idea);
    }

    public void createManifesto(){
        ConsoleUtility.log("Please enter the number of ideas(Max 3)");
        int ideaCount = ConsoleUtility.inputNumber();
        List<Idea> ideas= new ArrayList<>();
        for(int i = 1; i<= Math.min(ElectionConstants.MAX_IDEA_COUNT,ideaCount); i++){
            ConsoleUtility.log("Please Enter Idea No: "+i);
            String idea = ConsoleUtility.inputText();
            ideas.add(new Idea(idea));
        }
        this.manifesto = new Manifesto(ideas);
    }

    public void displayCandidate(){
        ConsoleUtility.log("====================CANDIDATE: "+candidateId+" =======================================");
        ConsoleUtility.log("Candidate Name: "+name);
        ConsoleUtility.log("Candidate Symbol: "+candidateSymbol);
        manifesto.displayManifesto();
        ConsoleUtility.log("==========================================================================");
    }
}
