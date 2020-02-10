package data.access.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    @Column(nullable = false)
    private String name;
    @ManyToMany
    @JoinTable(name = "film_category",
    joinColumns = @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_film_category_category")),
    inverseJoinColumns = @JoinColumn(name = "film_id", foreignKey = @ForeignKey(name = "fk_film_category_film")),
    indexes = @Index(name = "fk_film_category_category", columnList = "category_id"))
    @JsonIgnore
    private Set<Film> films;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", films=" + films +
                '}';
    }
}
