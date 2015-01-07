package home.privatik.spring.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "directed", schema = "", catalog = "my_db")
public class DirectedEntity {

    private int id;
    private String name;
    private String resources;
    private Collection<AnimesEntity> animesesById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "resources", nullable = true, insertable = true, updatable = true, length = 255)
    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectedEntity that = (DirectedEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (resources != null ? !resources.equals(that.resources) : that.resources != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (resources != null ? resources.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "directedByDirectedId")
    public Collection<AnimesEntity> getAnimesesById() {
        return animesesById;
    }

    public void setAnimesesById(Collection<AnimesEntity> animesesById) {
        this.animesesById = animesesById;
    }
}
