package data.access.model;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(name = "idx_fk_film_id", columnList = "store_id")})
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;
    @ManyToOne
    @JoinColumn(name = "store_id", foreignKey = @ForeignKey(name = "fk_inventory_store"))
    private Store store;
    @ManyToOne
    @JoinColumn(name = "film_id", foreignKey = @ForeignKey(name = "fk_inventory_film"))
    private Film film;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", store=" + store +
                ", film=" + film +
                '}';
    }
}
