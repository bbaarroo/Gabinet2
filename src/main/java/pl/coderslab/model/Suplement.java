package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "suplements")
public class Suplement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String suplementDescription;


    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "suplements")
    private Set<User> users;


    // gettery i settery



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

    public String getSuplementDescription() {
        return suplementDescription;
    }

    public void setSuplementDescription(String suplementDescription) {
        this.suplementDescription = suplementDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suplement suplement = (Suplement) o;
        return Objects.equals(id, suplement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
