package service;

import domain.Candidate;
import domain.Citizen;

import java.util.HashMap;
import java.util.List;

public interface NotificationService {
    void sendNotification(List<Citizen> followers, HashMap<String, Candidate> candidateHashMap);
}
