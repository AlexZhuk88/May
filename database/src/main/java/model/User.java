package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


@Data
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = "setMeeting")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user", schema = "smay_db")
public class User extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<TheNew> setNews = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_meeting", schema = "smay_db",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "meeting_id"))
    private Set<Meeting> setMeeting = new HashSet<>();

}
