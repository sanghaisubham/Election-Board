package domain;

import java.time.LocalDateTime;

public class Rating {
    int rating;
    Citizen votedBy;
    LocalDateTime ratingCreationTime;

    public Rating(int rating, Citizen votedBy, LocalDateTime ratingCreationTime){
        this.rating=rating;
        this.votedBy = votedBy;
        this.ratingCreationTime = ratingCreationTime;
    }
}
