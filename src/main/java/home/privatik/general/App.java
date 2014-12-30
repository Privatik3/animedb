package home.privatik.general;

import home.privatik.dao.AnimeDao;
import home.privatik.domain.AnimeEntity;
import home.privatik.domain.AnimeGenreEntity;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        Factory instance = Factory.getInstance();
        AnimeDao animeDao = instance.getAnimeDao();

        AnimeEntity anime = animeDao.getAnimeById("50");

        System.out.println("Main title: " + anime.getMainTitle());
        System.out.println("Other_title: " + anime.getOtherTitle());
        System.out.println("Main img: " + anime.getMainImg());
        System.out.println("Year production: " + anime.getYearProduction());
        System.out.println("Review: " + anime.getReview());
        System.out.println("Average: " + anime.getAverage());
        System.out.println("Ranced: " + anime.getRanced());
        System.out.println("Voted: " + anime.getVoted());
        System.out.println("Genre: ");

        for (AnimeGenreEntity genre : anime.getAnimeGenresById()) {
            System.out.print(genre.getGenresByGenresId().getName() + " ");
        }
        System.out.println();

        System.out.println("Screenshots: size=" + anime.getScreenshotsesById().size());
        System.out.println("Connections: size=" + anime.getConnectionsesById().size());

    }
}
