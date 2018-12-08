package model;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"groop", "concertPlace", "timing"})
@Entity
@Builder
@Table(name = "concert", schema = "smay_db")
public class Concert extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String concertName;

    @ManyToOne
    @JoinColumn(name = "groop_id")
    private Groop groop;

    @OneToOne(mappedBy = "concert", cascade = CascadeType.ALL)
    private ConcertPlace concertPlace;

    private String discription;

    @Embedded
    private Timing timing;

}
