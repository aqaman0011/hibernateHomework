package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "country")
    private Set<City> cities;

    public Country() {
        this.cities = new HashSet<>();
    }


    public void addCity(City city) {
        cities.add(city);
        city.setCountry(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}
