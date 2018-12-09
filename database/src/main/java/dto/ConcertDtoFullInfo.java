package dto;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConcertDtoFullInfo {

    private String concertName;
    private String groopname;
    private String city;
    private String place;
    private String entrance;
    private String discription;
    private String date;
    private String time;
}
