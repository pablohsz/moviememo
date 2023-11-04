package br.edu.pucgo.moviememo.dao;

import br.edu.pucgo.moviememo.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieDao extends CrudRepository<Movie, Long> {

    List<Movie> findByGenre(String genre);
}
