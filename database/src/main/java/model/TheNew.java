package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "news", schema = "smay_db")
public class TheNew extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String newsname;

    @Embedded
    private Timing timing;

    private String discription;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;

}
