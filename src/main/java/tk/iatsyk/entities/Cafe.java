package tk.iatsyk.entities;

import org.hibernate.annotations.Entity;

import java.io.Serializable;

/**
 * User: Vova Iatsyk
 * Date: 18.10.2015
 */
@Entity
public class Cafe implements Serializable {

    private Integer uuid;
    private String name;
    private String description;
    private Double attitude;
    private Double longitude;



}
