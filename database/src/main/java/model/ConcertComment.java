package model;

import lombok.*;

import javax.persistence.*;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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