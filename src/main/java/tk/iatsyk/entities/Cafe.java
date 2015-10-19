package tk.iatsyk.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Vova Iatsyk
 * Date: 18.10.2015
 */
//@DynamicUpdate
@Entity
@Table(name = "cafe")
public class Cafe implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Double attitude;
    private Double longitude;

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

    @Column(name = "attitude")
    public Double getAttitude() {
        return attitude;
    }

    public void setAttitude(Double attitude) {
        this.attitude = attitude;
    }

    @Column(name = "longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
