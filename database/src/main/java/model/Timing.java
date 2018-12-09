package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Embeddable
@Inheritance(strategy = InheritanceType.JOINED)
public class Timing {

    private LocalDate date;

    private LocalTime time;

}
