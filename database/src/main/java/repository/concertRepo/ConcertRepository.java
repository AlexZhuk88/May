package repository.concertRepo;

import com.querydsl.core.annotations.QueryType;
import dto.GroopDto;
import model.Concert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.PostUpdate;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ConcertRepository extends CrudRepository<Concert, Long>, CustomConcertRepository {

    Concert findByConcertName(String name);

    @Modifying
    @Query(value = "update smay_db.concert\n" +
            "set concertname = :concertnameQ,\n" +
            "    discription = :discriptionQ,\n" +
            "    time        = :timeQ,\n" +
            "    date        = :dateQ,\n" +
            "    groop_id    = :groopIdQ\n" +
            "where smay_db.concert.id = :idQ", nativeQuery = true)
    void updateConcert(@Param("idQ") Long id,
                       @Param("concertnameQ") String concertname,
                       @Param("discriptionQ") String discription,
                       @Param("timeQ") LocalTime time,
                       @Param("dateQ") LocalDate date,
                       @Param("groopIdQ") Long groopId);

    @Modifying
    @Query(value = "update smay_db.concertplace\n" +
            "set city     = :cityQ,\n" +
            "    place    = :placeQ,\n" +
            "    entrance = :entranceQ\n" +
            "where smay_db.concertplace.concert_id = :idQ", nativeQuery = true)
    void updateConcertPlace(@Param("idQ") Long id,
                            @Param("cityQ") String city,
                            @Param("placeQ") String place,
                            @Param("entranceQ") String entrance);

    @Query(value = "select count (c) from Concert c")
    Long findCountConcert();

    @Query(value = "select count(*)\n" +
            "from smay_db.comment where smay_db.comment.type = 'Concert'", nativeQuery = true)
    Long findCountConcertComment();

    @Query(value = "select distinct cp.city from ConcertPlace cp")
    List<String> findAllCity();

    @Cacheable("concert")
    @Query(value = "select distinct cp.place from ConcertPlace cp")
    List<String> findAllPlace();

    @Query(value = "select distinct g.groopname from Groop g")
    List<String> findAllGroop();

    @Query(value = "select distinct g.groopname from Groop g")
    List<String> findAllGroopy();

}


