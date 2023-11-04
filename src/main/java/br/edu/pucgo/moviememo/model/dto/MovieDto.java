package br.edu.pucgo.moviememo.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class MovieDto {

    @NotBlank(message = "The title is required.")
    private String title;

    @NotNull
    @Max(value = 2023, message = "Year is invalid.") @Min(value = 1888, message = "Year is invalid.")
    private Integer year;

    @NotNull @NotBlank(message = "The genre is required.")
    private  String genre;

    @NotNull
    @Max(value = 5, message = "The rating must be between 0 and 5.") @Min(value = 0, message = "The rating must be between 0 and 5.")
    private Integer rating;


}
