import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.min;

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

    public boolean isCandidateEligible(){
        return manifesto.isAcceptedManifesto();
    }

    void displayCandidate(){
        System.out.println("====================CANDIDATE: "+candidateId+" =======================================");
        System.out.println("Candidate Name: "+name);
        System.out.println("Candidate Symbol: "+candidateSymbol);
        manifesto.displayManifesto();
        System.out.println("==========================================================================");
    }

    void addFollower(Citizen follower){
        if(followers.contains(follower)){
            System.out.println("The citizen is already a follower");
        }
        else {
            System.out.println("Citizen "+follower.name+" is added as a follower of "+this.name);
            followers.add(follower);
        }
    }

    void addIdea(Idea idea){
       manifesto.addIdea(idea);
       sendNotification(followers);
    }

    void sendNotification(List<Citizen> followers){
        if(followers.isEmpty())
            return;
        for (Citizen citizen:followers){
            System.out.println("Sending notification to citizen: "+citizen.name);
            //sendNotification(citizen);
        }
    }

    void createManifesto(){
        System.out.println("Please enter the number of ideas(Max 3)");
        Scanner sc = new Scanner(System.in);
        int ideaCount = Integer.parseInt(sc.nextLine());
        List<Idea> ideas= new ArrayList<>();
        for(int i=1;i<=min(ElectionConstants.MAX_IDEA_COUNT,ideaCount);i++){
            System.out.println("Please Enter Idea No: "+i);
            String idea = sc.nextLine();
            ideas.add(new Idea(idea));
        }
        this.manifesto = new Manifesto(ideas);
    }



}
