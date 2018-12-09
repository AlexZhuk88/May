package model;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorValue("Concert")
public class ConcertComment extends Comment {

    @OneToOne
    @JoinColumn(name = "concert_id")
    private Concert concert;

    public ConcertComment(User user, Timing timing, String discription, Concert concert) {
        super(user, timing, discription);
        this.concert = concert;
    }
}