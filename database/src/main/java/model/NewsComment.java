package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@DiscriminatorValue("TheNew")
public class NewsComment extends Comment {

    @OneToOne
    @JoinColumn(name = "news_id")
    private TheNew theNew;

    public NewsComment(User user, Timing timing, String discription, TheNew theNew) {
        super(user, timing, discription);
        this.theNew = theNew;
    }
}