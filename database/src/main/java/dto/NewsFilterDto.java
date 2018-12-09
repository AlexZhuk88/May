package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Concert;
import model.TheNew;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsFilterDto {
    private List<String> listAuthors = new ArrayList<>();
    private List<TheNew> listNews = new ArrayList<>();
    private String dataStart;
    private String dataEnd;
    private Long countNews;
}




