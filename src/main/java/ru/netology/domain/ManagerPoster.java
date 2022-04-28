package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ManagerPoster {

    private int numberRecentlyAddedFilms = 10;

    private InformFilms[] films = new InformFilms[0];

    public ManagerPoster(int numberRecentlyAddedFilms) {
        this.numberRecentlyAddedFilms = numberRecentlyAddedFilms;
    }

    public void save(InformFilms film) {
        int length = films.length + 1;
        InformFilms[] newFilm = new InformFilms[length];
        for (int i = 0; i < films.length; i++) {
            newFilm[i] = films[i];
        }
        int lastFilm = newFilm.length - 1;
        newFilm[lastFilm] = film;
        films = newFilm;

    }

    public InformFilms[] findAll() {
        return films;

    }

    public InformFilms[] findLast() {
        int resultLength = films.length;
        if (resultLength > numberRecentlyAddedFilms) {
            resultLength = numberRecentlyAddedFilms;
        }
        InformFilms[] result = new InformFilms[resultLength];
        int index = films.length - 1;
        for (int i = 0; i < resultLength; i++) {
            result[i] = films[index - i];
        }
        films = result;
        return result;
    }

}
