package tk.iatsyk.entities.representationobjects;

import tk.iatsyk.entities.businessentities.Dish;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Vova Iatsyk
 * Date: 25.10.2015
 */
public class DishRO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String currency;
    private String picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public static DishRO parseDish(Dish dish) {
        DishRO dishRO = new DishRO();
        dishRO.setId(dish.getId());
        dishRO.setName(dish.getName());
        dishRO.setDescription(dish.getDescription());
        dishRO.setPrice(dish.getPrice());
        dishRO.setCurrency(dish.getCurrency());
        dishRO.setPicture(dish.getPicture());
        return dishRO;
    }

    public static List<DishRO> parseDishes(List<Dish> dishes) {
        return dishes.stream().map(DishRO::parseDish).collect(Collectors.toList());
    }

}
