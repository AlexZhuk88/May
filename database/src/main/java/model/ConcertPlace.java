package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "concert")
@Entity
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "concertplace", schema = "smay_db")
public class ConcertPlace extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "concert_id")
    private Concert concert;

    private String city;

    private String place;

    private String entrance;


}
