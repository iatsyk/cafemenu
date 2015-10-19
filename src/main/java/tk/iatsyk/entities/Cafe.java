package tk.iatsyk.entities;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Vova Iatsyk
 * Date: 18.10.2015
 */
@DynamicUpdate
@Table(name = "cafe")
public class Cafe implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private Double attitude;
    private Double longitude;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getAttitude() {
        return attitude;
    }

    public void setAttitude(Double attitude) {
        this.attitude = attitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
