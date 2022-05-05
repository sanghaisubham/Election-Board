import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ElectionBoard {
    private List<Candidate> candidates;
    private List<Citizen> citizens;
    private HashMap<String,Candidate> candidateHashMap;
    private HashMap<String,Citizen> citizenHashMap;
    Scanner sc = new Scanner(System.in);

    ElectionBoard(){
        candidates = new LinkedList<>();
        citizens = new LinkedList<>();
        candidateHashMap = new HashMap<>();
        citizenHashMap = new HashMap<>();
    }

    void decideWinner(){
        Candidate winnerCandidate=null;
        float highestRating=0;
        for(Candidate candidate:candidates){
            float candidateRating=candidate.getManifesto().getTotalRating();
           if(candidateRating>highestRating){
               highestRating=candidateRating;
               winnerCandidate=candidate;
           }
        }
        if(winnerCandidate==null){
            System.out.println("No Winner decided yet");
        }
        else {
            System.out.println("The Winner is : " + winnerCandidate.name + " with total rating as " + winnerCandidate.getManifesto().getTotalRating());
        }
    }

    void addCitizens() {
        System.out.println("Enter the number of citizens in the city");
        int citizenCount = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <=citizenCount; i++) {
            System.out.println("Print name of Citizen" + i);
            String citizenName=sc.nextLine();
            Citizen citizen = new Citizen(citizenName);
            citizens.add(citizen);
            citizenHashMap.put(citizen.name,citizen);
        }
    }

    void addCandidates(){
        System.out.println("Enter the number of citizens who want to contest the election");

        int candidateCount = Integer.parseInt(sc.nextLine());

        for (int i = 1; i<=candidateCount; i++) {
            System.out.println("Candidate "+i);
            System.out.println("===========================================================");
            System.out.println("Enter name of Citizen who wants to contest");
            String candidateName= sc.nextLine();
            if(!isValidCitizen(candidateName)){
                return;
            }

            if(candidateHashMap.get(candidateName)!=null){
                System.out.println("Citizen is already a candidate");
                continue;
            }
            System.out.println("Enter Candidate Symbol");
            String candidateSymbol= sc.nextLine();

            System.out.println("Enter Candidate Manifesto");
            Citizen citizen = citizenHashMap.get(candidateName);
            Candidate candidateObj = new Candidate(citizen,candidateSymbol);
            candidateObj.createManifesto();
            candidates.add(candidateObj);
            candidateHashMap.put(candidateName,candidateObj);
          }
        }

    void electionDetails(){
        for(Candidate candidate:candidates){
            candidate.displayCandidate();
        }
    }

    void addRating(){
            System.out.println("Enter the name of citizen who wants to add rating");
            String citizen = sc.nextLine();
            if(!isValidCitizen(citizen))
            return;

            System.out.println("Enter the name of candidate he wants to add rating for");
            String candidate= sc.nextLine();
            if(!isValidCandidate(candidate))
            return;

            Candidate candidateObj = candidateHashMap.get(candidate);
            System.out.println("Enter the idea number he wants to add rating for");
            int ideaNumber = Integer.parseInt(sc.nextLine());

            System.out.println("Enter the rating he wants to give");
            int rating = Integer.parseInt(sc.nextLine());
            citizenHashMap.get(citizen).rateIdea(candidateObj,candidateObj.getManifesto().getIdeas().get(ideaNumber-1),rating);
            checkAndRemoveCandidate(candidateObj,candidate);
            candidateObj.getManifesto().displayManifestoStats();
    }

    void checkAndRemoveCandidate(Candidate candidateObj, String candidateName){
        if(!candidateObj.isCandidateEligible()){
            System.out.println("Removing "+candidateName+" from elections");
            candidateHashMap.remove(candidateName);
            this.candidates.remove(candidateObj);
        }
    }

    void removeRating(){
        System.out.println("Enter the name of citizen who wants to remove his rating");
        String citizen = sc.nextLine();
        if(!isValidCitizen(citizen))
            return;

        System.out.println("Enter the name of candidate, he wants to remove rating for");
        String candidate= sc.nextLine();
        if(!isValidCandidate(candidate))
            return;

        Candidate candidateObj = candidateHashMap.get(candidate);
        System.out.println("Enter the idea number he wants to remove rating for");
        int ideaNumber = Integer.parseInt(sc.nextLine());

        citizenHashMap.get(citizen).unRateIdea(candidateObj,candidateObj.getManifesto().getIdeas().get(ideaNumber-1));
        candidateObj.getManifesto().displayManifestoStats();
    }


    void addIdea(){
        System.out.println("Enter the name of candidate who wants to add an idea");
        String candidate = sc.nextLine();

        if(!isValidCandidate(candidate))
            return;

        System.out.println("Enter the idea he wants to add");
        String idea = sc.nextLine();

        Candidate candidateObj = candidateHashMap.get(candidate);
        candidateObj.addIdea(new Idea(idea));
        candidateObj.displayCandidate();
    }

    boolean isValidCandidate(String candidate){
        if(!candidateHashMap.containsKey(candidate)){
            System.out.println(candidate+"is not a valid candidate in the city");
            return false;
        }
        return true;
    }

    boolean isValidCitizen(String citizen){
        if(!citizenHashMap.containsKey(citizen)){
            System.out.println(citizen+"is not a valid citizen in the city");
            return false;
        }
        return true;
    }

}
