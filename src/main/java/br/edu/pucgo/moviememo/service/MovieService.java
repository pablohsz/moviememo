package br.edu.pucgo.moviememo.service;

import br.edu.pucgo.moviememo.dao.MovieDao;
import br.edu.pucgo.moviememo.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MovieService {

    @Autowired
    private MovieDao movieDao;

    public List<Movie> getAll() {return (List<Movie>) movieDao.findAll();}

    public Movie insertMovie(Movie movie){
        return  movieDao.save(movie);
    }

    public Movie update(Movie movie){
        return  movieDao.save(movie);
    }

    public Optional<Movie> getById(Long id){
        return movieDao.findById(id);
    }

    public List<Movie> getByGenre(String genre){
        return movieDao.findByGenre(genre);
    }

    public void deleteMovie(Long id){
        movieDao.deleteById(id);
    }
}
