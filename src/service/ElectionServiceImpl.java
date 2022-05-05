package service;

import domain.Candidate;
import domain.Citizen;
import domain.ElectionConstants;
import domain.Idea;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ElectionServiceImpl implements ElectionService{

    private List<Candidate> candidates;
    private HashMap<String,Candidate> candidateHashMap;
    private HashMap<String,Citizen> citizenHashMap;
    
    public ElectionServiceImpl(){
        candidates = new LinkedList<>();
        candidateHashMap = new HashMap<>();
        citizenHashMap = new HashMap<>();
    }

    @Override
    public void decideWinner(){
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
            ConsoleUtility.log("No Winner decided yet");
        }
        else {
            ConsoleUtility.log("The Winner is : " + winnerCandidate.name + " with total rating as " +
                    winnerCandidate.getManifesto().getTotalRating());
        }
    }

    @Override
    public void addCitizens() {
        ConsoleUtility.log("Enter the number of citizens in the city");
        int citizenCount = ConsoleUtility.inputNumber();
        for (int i = 1; i <=citizenCount; i++) {
            ConsoleUtility.log("Print name of Citizen "+i);
            String citizenName= ConsoleUtility.inputText();
            Citizen citizen = new Citizen(citizenName);
            citizenHashMap.put(citizen.name,citizen);
        }
    }

    @Override
    public void addCandidates(){
        ConsoleUtility.log("Enter the number of citizens who want to contest the election");

        int candidateCount = ConsoleUtility.inputNumber();

        for (int i = 1; i<=candidateCount; i++) {
            ConsoleUtility.log("Candidate "+i);
            ConsoleUtility.log("===========================================================");
            ConsoleUtility.log("Enter name of Citizen who wants to contest");
            String candidateName= ConsoleUtility.inputText();
            if(!isValidCitizen(candidateName)){
                return;
            }

            if(candidateHashMap.get(candidateName)!=null){
                ConsoleUtility.log("Citizen is already a candidate");
                continue;
            }

            ConsoleUtility.log("Enter Candidate Symbol");
            String candidateSymbol= ConsoleUtility.inputText();

            ConsoleUtility.log("Enter Candidate Manifesto");
            Citizen citizen = citizenHashMap.get(candidateName);
            Candidate candidateObj = new Candidate(citizen,candidateSymbol);
            candidateObj.createManifesto();
            candidates.add(candidateObj);
            candidateHashMap.put(candidateName,candidateObj);
        }
    }

    public void getElectionDetails(){
        for(Candidate candidate:candidates){
            candidate.displayCandidate();
        }
    }

    @Override
    public void addRating(){
        ConsoleUtility.log("Enter the name of citizen who wants to add rating");
        String citizenName = ConsoleUtility.inputText();
        if(!isValidCitizen(citizenName))
            return;

        ConsoleUtility.log("Enter the name of candidate he wants to add rating for");
        String candidateName= ConsoleUtility.inputText();
        if(!isValidCandidate(candidateName))
            return;

        Candidate candidate = candidateHashMap.get(candidateName);
        ConsoleUtility.log("Enter the idea number he wants to add rating for");
        int ideaNumber = ConsoleUtility.inputNumber();

        ConsoleUtility.log("Enter the rating he wants to give");
        int rating = ConsoleUtility.inputNumber();
        Citizen citizen= citizenHashMap.get(citizenName);
        citizen.rateIdea(candidate.getManifesto().getIdeas().get(ideaNumber-1),rating);
        if(rating> ElectionConstants.GOOD_IDEA_THRESHOLD){
            candidate.addFollower(citizen);
        }
        checkAndRemoveCandidate(candidate,candidateName);
        candidate.getManifesto().displayManifestoStats();
    }

    @Override
    public void removeRating(){
        ConsoleUtility.log("Enter the name of citizen who wants to remove his rating");
        String citizenName = ConsoleUtility.inputText();
        if(!isValidCitizen(citizenName))
            return;

        ConsoleUtility.log("Enter the name of candidate, he wants to remove rating for");
        String candidateName= ConsoleUtility.inputText();
        if(!isValidCandidate(candidateName))
            return;

        Candidate candidate = candidateHashMap.get(candidateName);
        ConsoleUtility.log("Enter the idea number he wants to remove rating for");
        int ideaNumber = ConsoleUtility.inputNumber();

        citizenHashMap.get(citizenName).unRateIdea(candidate.getManifesto().getIdeas().get(ideaNumber-1));
        candidate.getManifesto().displayManifestoStats();
    }

    @Override
    public void addIdea(){
        ConsoleUtility.log("Enter the name of candidate who wants to add an idea");
        String candidateName = ConsoleUtility.inputText();

        if(!isValidCandidate(candidateName))
            return;

        ConsoleUtility.log("Enter the idea he wants to add");
        String idea = ConsoleUtility.inputText();

        Candidate candidate = candidateHashMap.get(candidateName);
        candidate.addIdea(new Idea(idea));
        NotificationServiceImpl ns = new NotificationServiceImpl();
        ns.sendNotification(candidate.getFollowers(),candidateHashMap);
        candidate.displayCandidate();
    }


    boolean isValidCandidate(String candidate){
        if(!candidateHashMap.containsKey(candidate)){
            ConsoleUtility.log(candidate+"is not a valid candidate in the city");
            return false;
        }
        return true;
    }

    boolean isValidCitizen(String citizen){
        if(!citizenHashMap.containsKey(citizen)){
            ConsoleUtility.log(citizen+"is not a valid citizen in the city");
            return false;
        }
        return true;
    }

    void checkAndRemoveCandidate(Candidate candidate, String candidateName){
        if(!candidate.isCandidateEligible()){
            ConsoleUtility.log("Removing "+candidateName+" from elections");
            candidateHashMap.remove(candidateName);
            candidates.remove(candidate);
        }
    }
}
