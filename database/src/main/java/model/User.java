package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = {"setMeeting","setNews"})
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

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<TheNew> setNews = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_meeting", schema = "smay_db",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "meeting_id"))
    private Set<Meeting> setMeeting = new HashSet<>();

}
