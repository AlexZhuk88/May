package service;

import lombok.RequiredArgsConstructor;
import model.Groop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.groopRepo.GroopRepository;


@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GroopService {

    private final GroopRepository groopRepository;

    public Groop findByName(String name) {
        return groopRepository.findByGroopname(name);
    }
}
