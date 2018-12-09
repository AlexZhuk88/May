package service;

import dto.NewsFilterDto;
import lombok.RequiredArgsConstructor;
import model.TheNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.theNewsRepo.TheNewsRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TheNewService {

    private final TheNewsRepository theNewsRepository;
    @Transactional
    public Long findCountNews() {
        return theNewsRepository.findCountNews();
    }
    @Transactional
    public Long findCountNewsComment() {
        return theNewsRepository.findCountNewsComment();
    }
    @Transactional
    public NewsFilterDto prepareNewsPage(Integer pagin, int numPage, String starttime, String endtime, String author) {
        List<String> listAuthors = theNewsRepository.findAllAuthors();
        listAuthors.add(0,"Все авторы");
        List<TheNew> listNews = theNewsRepository.findByFilters(pagin, numPage, starttime, endtime, author);
        Long count = theNewsRepository.findCountPage(pagin, numPage, starttime, endtime, author);
        return NewsFilterDto.builder().listAuthors(listAuthors)
                .dataStart(starttime)
                .dataEnd(endtime)
                .countNews(count)
                .listNews(listNews)
                .build();
    }
    @Transactional
    public List<String> findAllAuthors() {
        return theNewsRepository.findAllAuthors();
    }

}
