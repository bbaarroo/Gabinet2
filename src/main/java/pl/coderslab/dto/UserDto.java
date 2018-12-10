package pl.coderslab.dto;

import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.model.Disease;
import pl.coderslab.model.Suplement;
import pl.coderslab.model.Therapist;

import javax.validation.constraints.Size;
import java.util.Set;

public class UserDto {


    private Long id;
    @Size(min = 3, max = 30)
    private String name;
    @Size(min = 3, max = 30)
    private String lastName;

    @PESEL
    private String pesel;

    private Set<Disease> diseaseList;

    private Set<Suplement> suplements;

    private Set<Therapist> therapistList;

    private String recommendation;

    private String nextVisit;

    private String comments;

    private String phnoneNumber;


    // gettery i settery


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Set<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(Set<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public Set<Suplement> getSuplements() {
        return suplements;
    }

    public void setSuplements(Set<Suplement> suplements) {
        this.suplements = suplements;
    }

    public Set<Therapist> getTherapistList() {
        return therapistList;
    }

    public void setTherapistList(Set<Therapist> therapistList) {
        this.therapistList = therapistList;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(String nextVisit) {
        this.nextVisit = nextVisit;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhnoneNumber() {
        return phnoneNumber;
    }

    public void setPhnoneNumber(String phnoneNumber) {
        this.phnoneNumber = phnoneNumber;
    }
}
