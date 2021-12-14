package kinoxp.repositories;

import kinoxp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

//We extend the JPA repository, so we can use all methods connected to an JPA database -- example ".save" or ".deleteById"
public interface MovieRepository extends JpaRepository<Movie, Integer> {//In the <generics> we define : <Which class will be the table , What is datetype is the primary key>
}
