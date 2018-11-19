package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Suplement;
import pl.coderslab.model.User;

import java.util.List;
import java.util.Set;

@Repository
public interface SuplementRepository extends JpaRepository<Suplement, Long> {

    Suplement findByName(String name);
    Suplement findById(Long id);

    List<Suplement> findByUsers(Set<User> user);




}
