package tk.iatsyk.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Vova Iatsyk
 * Date: 25.10.2015
 */
@Entity
@Table(name = "dishes")
@NamedQueries({
        @NamedQuery(name = "findAllDishesByCafeId",
                query = "SELECT d FROM tk.iatsyk.entities.Dishes d WHERE d.cafeId = :cafeId")
})
public class Dishes implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String currency;
    private String picture;
    private Long cafeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Column(name = "cafe_id")
    public Long getCafeId() {
        return cafeId;
    }

    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }
}
