package domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "anime", schema = "", catalog = "mydb")
public class AnimeEntity {

    private int id;
    private String mainImg;
    private String mainTitle;
    private String otherTitle;
    private Date yearProduction;
    private String review;
    private Double average;
    private Integer ranced;
    private Integer voted;
    private ProductionEntity productionByProductionId;
    private AnimeTypesEntity animeTypesByAnimeTypeId;
    private Collection<AnimeGenreEntity> animeGenresById;
    private Collection<ConnectionsEntity> connectionsesById;
    private Collection<ScreenshotsEntity> screenshotsesById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "main_img", nullable = true, insertable = true, updatable = true, length = 255)
    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    @Basic
    @Column(name = "main_title", nullable = false, insertable = true, updatable = true, length = 255)
    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    @Basic
    @Column(name = "other_title", nullable = true, insertable = true, updatable = true, length = 16777215)
    public String getOtherTitle() {
        return otherTitle;
    }

    public void setOtherTitle(String otherTitle) {
        this.otherTitle = otherTitle;
    }

    @Basic
    @Column(name = "year_production", nullable = false, insertable = true, updatable = true)
    public Date getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(Date yearProduction) {
        this.yearProduction = yearProduction;
    }

    @Basic
    @Column(name = "review", nullable = true, insertable = true, updatable = true, length = 16777215)
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Basic
    @Column(name = "average", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    @Basic
    @Column(name = "ranced", nullable = true, insertable = true, updatable = true)
    public Integer getRanced() {
        return ranced;
    }

    public void setRanced(Integer ranced) {
        this.ranced = ranced;
    }

    @Basic
    @Column(name = "voted", nullable = true, insertable = true, updatable = true)
    public Integer getVoted() {
        return voted;
    }

    public void setVoted(Integer voted) {
        this.voted = voted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimeEntity that = (AnimeEntity) o;

        if (average != null ? !average.equals(that.average) : that.average != null) return false;
        if (mainImg != null ? !mainImg.equals(that.mainImg) : that.mainImg != null) return false;
        if (mainTitle != null ? !mainTitle.equals(that.mainTitle) : that.mainTitle != null) return false;
        if (otherTitle != null ? !otherTitle.equals(that.otherTitle) : that.otherTitle != null) return false;
        if (ranced != null ? !ranced.equals(that.ranced) : that.ranced != null) return false;
        if (review != null ? !review.equals(that.review) : that.review != null) return false;
        if (voted != null ? !voted.equals(that.voted) : that.voted != null) return false;
        if (yearProduction != null ? !yearProduction.equals(that.yearProduction) : that.yearProduction != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mainImg != null ? mainImg.hashCode() : 0);
        result = 31 * result + (mainTitle != null ? mainTitle.hashCode() : 0);
        result = 31 * result + (otherTitle != null ? otherTitle.hashCode() : 0);
        result = 31 * result + (yearProduction != null ? yearProduction.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (average != null ? average.hashCode() : 0);
        result = 31 * result + (ranced != null ? ranced.hashCode() : 0);
        result = 31 * result + (voted != null ? voted.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "production_id", referencedColumnName = "id", nullable = false)
    public ProductionEntity getProductionByProductionId() {
        return productionByProductionId;
    }

    public void setProductionByProductionId(ProductionEntity productionByProductionId) {
        this.productionByProductionId = productionByProductionId;
    }

    @ManyToOne
    @JoinColumn(name = "anime_type_id", referencedColumnName = "id", nullable = false)
    public AnimeTypesEntity getAnimeTypesByAnimeTypeId() {
        return animeTypesByAnimeTypeId;
    }

    public void setAnimeTypesByAnimeTypeId(AnimeTypesEntity animeTypesByAnimeTypeId) {
        this.animeTypesByAnimeTypeId = animeTypesByAnimeTypeId;
    }

    @OneToMany(mappedBy = "animeByAnimeId")
    public Collection<AnimeGenreEntity> getAnimeGenresById() {
        return animeGenresById;
    }

    public void setAnimeGenresById(Collection<AnimeGenreEntity> animeGenresById) {
        this.animeGenresById = animeGenresById;
    }

    @OneToMany(mappedBy = "animeByAnimeId")
    public Collection<ConnectionsEntity> getConnectionsesById() {
        return connectionsesById;
    }

    public void setConnectionsesById(Collection<ConnectionsEntity> connectionsesById) {
        this.connectionsesById = connectionsesById;
    }

    @OneToMany(mappedBy = "animeByAnimeId")
    public Collection<ScreenshotsEntity> getScreenshotsesById() {
        return screenshotsesById;
    }

    public void setScreenshotsesById(Collection<ScreenshotsEntity> screenshotsesById) {
        this.screenshotsesById = screenshotsesById;
    }
}
