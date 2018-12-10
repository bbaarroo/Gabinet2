package pl.coderslab.dto;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.model.User;

import java.util.Set;

public class SuplementDto {

    private Long id;

    @NotEmpty
    private String name;

    private String suplementDescription;


    private Set<User> users;


    // getter setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuplementDescription() {
        return suplementDescription;
    }

    public void setSuplementDescription(String suplementDescription) {
        this.suplementDescription = suplementDescription;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
