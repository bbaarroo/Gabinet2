package pl.coderslab.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.pl.PESEL;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String lastName;

//    @PESEL
//    @Column(unique=true)
    private String pesel;

    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Disease> diseaseList;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Suplement> suplements;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Therapist> therapistList;

    private String recommendation;

    private Date nextVisit;

    private String comments;

    private String phnoneNumber;


    // atrybuty filtr



    private String userName;


    private String password;



    // jakby co to jako duzy Boolean
//    private boolean enabled;





    // konstruktor

    public User() {
    }


    // metody

    public String getNextVisitString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(nextVisit);
    }



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

    public Date getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(Date nextVisit) {
        this.nextVisit = nextVisit;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPhnoneNumber() {
        return phnoneNumber;
    }

    public void setPhnoneNumber(String phnoneNumber) {
        this.phnoneNumber = phnoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setHashedPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", diseaseList=" + diseaseList +
                ", suplements=" + suplements +
                ", therapistList=" + therapistList +
                ", recommendation='" + recommendation + '\'' +
                ", nextVisit=" + nextVisit +
                ", comments='" + comments + '\'' +
                '}';
    }
}
