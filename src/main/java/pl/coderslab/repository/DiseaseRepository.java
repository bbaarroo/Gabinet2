package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Disease;
import pl.coderslab.model.Suplement;
import pl.coderslab.model.User;

import java.util.List;
import java.util.Set;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    Disease findByName(String name);
    Disease findById(Long id);



}
