package service;

import domain.Candidate;
import domain.Citizen;

import java.util.HashMap;
import java.util.List;
public class NotificationServiceImpl implements NotificationService {

    HashMap<String,Boolean> visited = new HashMap<>();

    @Override
    public void sendNotification(List<Citizen> followers,HashMap<String, Candidate> candidateHashMap){
        if(followers.isEmpty())
            return;
        for (Citizen citizen:followers){
            if(visited.containsKey(citizen.name)){
                continue;
            }
            visited.put(citizen.name,true);
            System.out.println("Sending notification to citizen: "+citizen.name);
            if(!candidateHashMap.containsKey(citizen.name))
                continue;
            sendNotification(candidateHashMap.get(citizen.name).getFollowers(),candidateHashMap);
        }
    }
}
