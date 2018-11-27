package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Embeddable
public class Timing {

    private LocalDate date;

    private LocalTime time;

}
