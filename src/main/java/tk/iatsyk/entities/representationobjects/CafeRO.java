package tk.iatsyk.entities.representationobjects;

import tk.iatsyk.entities.businessentities.Cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Vova Iatsyk
 * Date: 25.10.2015
 */
public class CafeRO {

    private Long id;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private String address;

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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static CafeRO parseCafe(Cafe cafe) {
        CafeRO cafeRO = new CafeRO();
        cafeRO.setId(cafe.getId());
        cafeRO.setName(cafe.getName());
        cafeRO.setDescription(cafe.getDescription());
        cafeRO.setLatitude(cafe.getLatitude());
        cafeRO.setLongitude(cafe.getLongitude());
        cafeRO.setAddress(cafe.getAddress());
        return cafeRO;
    }

    public static List<CafeRO> parseCafes(List<Cafe> cafes) {
        return cafes.stream().map(CafeRO::parseCafe).collect(Collectors.toList());
    }
}
