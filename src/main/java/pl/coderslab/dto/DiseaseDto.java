package pl.coderslab.dto;

import pl.coderslab.model.User;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

public class DiseaseDto {


    private Long id;
    private String name;

    private Set<User> infected;



    // getter setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getInfected() {
        return infected;
    }

    public void setInfected(Set<User> infected) {
        this.infected = infected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
