package domain;

import javax.persistence.*;

@Entity
@Table(name = "screenshots", schema = "", catalog = "mydb")
public class ScreenshotsEntity {

    private int id;
    private String url;
    private AnimeEntity animeByAnimeId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url", nullable = false, insertable = true, updatable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScreenshotsEntity that = (ScreenshotsEntity) o;

        if (id != that.id) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
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
}
