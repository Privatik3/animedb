package home.privatik.domain;

import javax.persistence.*;

@Entity
@Table(name = "anime_genre", schema = "", catalog = "mydb")
public class AnimeGenreEntity {

    private int id;
    private AnimeEntity animeByAnimeId;
    private GenresEntity genresByGenresId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimeGenreEntity that = (AnimeGenreEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Anime_id", referencedColumnName = "id", nullable = false)
    public AnimeEntity getAnimeByAnimeId() {
        return animeByAnimeId;
    }

    public void setAnimeByAnimeId(AnimeEntity animeByAnimeId) {
        this.animeByAnimeId = animeByAnimeId;
    }

    @ManyToOne
    @JoinColumn(name = "genres_id", referencedColumnName = "id", nullable = false)
    public GenresEntity getGenresByGenresId() {
        return genresByGenresId;
    }

    public void setGenresByGenresId(GenresEntity genresByGenresId) {
        this.genresByGenresId = genresByGenresId;
    }
}
