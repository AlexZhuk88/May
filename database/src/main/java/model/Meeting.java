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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@ToString(exclude = "setUser")
@NoArgsConstructor
@Builder
@Entity
@Table(name = "meeting", schema = "smay_db")
public class Meeting extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String meetingName;

    @ManyToMany(mappedBy = "setMeeting")
    private Set<User> setUser = new HashSet<>();
}
