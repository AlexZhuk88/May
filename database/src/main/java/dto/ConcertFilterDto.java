package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Concert;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConcertFilterDto {
    private List<String> listPlace = new ArrayList<>();
    private List<String> listCity = new ArrayList<>();
    private List<String> listGroop = new ArrayList<>();
    private List<Concert> listConcert = new ArrayList<>();
    private Long countConcert;
}




