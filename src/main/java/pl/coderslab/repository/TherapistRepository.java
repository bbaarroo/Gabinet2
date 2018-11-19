package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Disease;
import pl.coderslab.model.Suplement;
import pl.coderslab.model.Therapist;
import pl.coderslab.model.User;

import java.util.List;
import java.util.Set;

@Repository
public interface TherapistRepository extends JpaRepository<Therapist, Long> {

    Therapist findByName(String name);
    Therapist findById(Long id);

;
}
