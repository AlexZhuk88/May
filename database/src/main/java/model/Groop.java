package model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "groop", schema = "smay_db")
public class Groop extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groopname;

    private String discription;

    @OneToMany(mappedBy = "groop", fetch = FetchType.LAZY)
    private Set<Concert> setConcert = new HashSet<>();

}
