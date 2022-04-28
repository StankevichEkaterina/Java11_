package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformFilms {
    private int id;
    private int filmId;
    private String filmName;
    private String filmGenre;

}
