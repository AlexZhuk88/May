package repository.ConcertRepo;

import model.Concert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConcertRepository extends CrudRepository<Concert, Long>, CustomConcertRepository {

    Concert findByConcertName(String name);

    @Query(value = "select distinct cp.city from ConcertPlace cp")
    List<String> findAllCity();

    @Query(value = "select distinct cp.place from ConcertPlace cp")
    List<String> findAllPlace();

    @Query(value = "select distinct g.groopname from Groop g")
    List<String> findAllGroop();

//
//    Movie findByNameAndDirectorFirstName(String name, String firstName);
//
//    @Query("select m " +
//            "from Movie m " +
//            "join m.director d " +
//            "where m.name = :name and d.firstName = :firstName")
//    Optional<Movie> customMethod(@Param("name") String movieName, @Param("firstName") String directorName);
//
//    @Query(value = "select m.* " +
//            "from movie_storage.movie m " +
//            "join movie_storage.director d " +
//            "   on m.director_id = d.id " +
//            "where m.name = :name and d.first_name = :firstName", nativeQuery = true)
//    Optional<Movie> customMethodNative(@Param("name") String movieName, @Param("firstName") String directorName);
//
//    @Query(value = "select m.name as name, d.id as directorId " +
//            "from movie_storage.movie m " +
//            "join movie_storage.director d " +
//            "   on m.director_id = d.id " +
//            "where m.name = :name and d.first_name = :firstName", nativeQuery = true)
//    Optional<MovieSecondDto> customMethodNative2(@Param("name") String movieName, @Param("firstName") String directorName);
//
//    @Query("select new com.matveyenka.spring.dto.MovieSecondDto(m.name, d.id) " +
//            "from Movie m " +
//            "join m.director d " +
//            "where m.name = :name and d.firstName = :firstName")
//    Optional<MovieSecondDto> customMethodNative3(@Param("name") String movieName, @Param("firstName") String directorName);
//
//
//    List<Movie> findAllByReleaseYearBetweenOrderByName(int startYear, int endYear, Pageable pageable);

}


