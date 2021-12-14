package kinoxp.repositories;

import kinoxp.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    void getActivity() throws Exception{
        /*Tjekker DB for hvor mange activities der er. Husk at sætte "spring.jpa.hibernate.ddl-auto=update"
        i application properties når vi tester */

        List<Movie> movieList = movieRepository.findAll();
        assertEquals(3, movieList.size());
    }



}