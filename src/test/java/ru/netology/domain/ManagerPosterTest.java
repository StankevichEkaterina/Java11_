package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.*;


class ManagerPosterTest {

    InformFilms first = new InformFilms(0, 1, "Бладшот", "Боевик");
    InformFilms two = new InformFilms(1, 2, "Вперед", "Мультик");
    InformFilms three = new InformFilms(2, 3, "Отель Белград", "Комедия");
    InformFilms four = new InformFilms(3, 4, "Джетельмены", "Боевик");
    InformFilms five = new InformFilms(4, 5, "Человек-невидимка", "Ужасы");
    InformFilms six = new InformFilms(5, 6, "Тролли. Мировой тур", "Мультфильмы");
    InformFilms seven = new InformFilms(6, 7, "Номер один", "Комедия");
    InformFilms eight = new InformFilms(7, 8, "Москва слезам не верит", "Мелодрама");
    InformFilms nine = new InformFilms(8, 9, "Любовь и голуби", "Комедия");
    InformFilms ten = new InformFilms(9, 10, "Один дома", "Комедия");
    InformFilms eleven = new InformFilms(10, 11, "Смерть на Ниле", "Дедектив");

    @Test
    public void shouldAddMovies() {
        ManagerPoster manager = new ManagerPoster();
        manager.save(first);
        manager.save(two);
        InformFilms[] expected = {first, two};
        InformFilms[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldListAllMoviesInTheOrderTheyWereAdded() {
        ManagerPoster manager = new ManagerPoster();
        InformFilms[] films = new InformFilms[]{first, two};
        manager.setFilms(films);
        manager.save(six);
        manager.save(seven);
        InformFilms[] expected = {first, two, six, seven};
        InformFilms[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutputTheLatestAddedMoviesInReverseOrderIfMoreThanTheLimitIsAdded() {
        ManagerPoster manager = new ManagerPoster();
        manager.save(first);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);
        InformFilms[] expected = new InformFilms[]{eleven, ten, nine, eight, seven, six, five, four, three, two};
        InformFilms[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutputLatestAddedMoviesInReverseOrderIfLessThanLimitAdded() {
        ManagerPoster manager = new ManagerPoster();
        manager.save(first);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        InformFilms[] expected = new InformFilms[]{seven, six, five, four, three, two, first};
        InformFilms[] actual = manager.findLast();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void SettingTheOutputLimitAndOutputtingTheLatestAddedMoviesMoreThanTheLimitInReverseOrder() {
        ManagerPoster manager = new ManagerPoster(5);
        manager.save(eleven);
        manager.save(two);
        manager.save(four);
        manager.save(six);
        manager.save(nine);
        manager.save(three);
        manager.save(first);
        InformFilms[] expected = new InformFilms[]{first, three, nine, six, four};
        InformFilms[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void settingTheOutputLimitAndOutputtingTheLatestAddedMoviesLessThanTheLimitInReverseOrder() {
        ManagerPoster manager = new ManagerPoster(5);
        manager.save(eleven);
        manager.save(two);
        manager.save(four);
        InformFilms[] expected = new InformFilms[]{four, two, eleven};
        InformFilms[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddingFilmsToAnExistingListAndDisplayingTheLatestAddedAccordingToTheLimit() {
        ManagerPoster manager = new ManagerPoster(5);
        InformFilms[] films = new InformFilms[]{first, two};
        manager.setFilms(films);
        manager.save(eleven);
        manager.save(three);
        manager.save(four);
        InformFilms[] expected = new InformFilms[]{four, three, eleven, two, first};
        InformFilms[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

}