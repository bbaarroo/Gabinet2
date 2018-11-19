package pl.coderslab.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class TherapistDto {


    private Long id;
    @NotEmpty
    private String name;

    @NotEmpty
    private String specialization;


    // getter setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
