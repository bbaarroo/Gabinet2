package pl.coderslab.Service;

import pl.coderslab.model.Disease;
import pl.coderslab.model.Therapist;
import pl.coderslab.model.User;

import java.util.List;

public interface DiseaseService {

    Disease save(Disease u);
    Disease update(Disease u);
    List<Disease> findAll();
    Disease findByName(String name);
    Disease findById(Long id);
    void deleteDisease(Long id);

}
