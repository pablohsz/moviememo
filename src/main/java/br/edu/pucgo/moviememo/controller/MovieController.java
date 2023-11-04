package br.edu.pucgo.moviememo.controller;


import br.edu.pucgo.moviememo.model.Movie;
import br.edu.pucgo.moviememo.model.dto.MovieDto;
import br.edu.pucgo.moviememo.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Validated
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;



    @GetMapping
    public List<Movie> getAllMovies(){
        List<Movie> listMovie = movieService.getAll();
        return  listMovie;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Optional<Movie> findedCategory = movieService.getById(id);
        if(findedCategory.isEmpty()){
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok(findedCategory.get());
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMovieByGenre(@PathVariable String genre){
        return movieService.getByGenre(genre);
    }

    /*
    @Valid é utilizado para fazer a validação do objeto que vai ser enviado no body.
    A validação é feita de acordo com as annotations definidas na classe model.
     */
    @PostMapping
    public Movie createCategory(@Valid @RequestBody MovieDto movieDto){
        Movie movie = Movie.setData(movieDto);
        return movieService.insertMovie(movie);
    }

    @PutMapping
    public Movie updateCategory(@Valid @RequestBody Movie movie){
        return movieService.update(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        movieService.deleteMovie(id);
    }

}
