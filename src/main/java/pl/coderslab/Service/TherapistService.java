package pl.coderslab.Service;

import pl.coderslab.model.Suplement;
import pl.coderslab.model.Therapist;
import pl.coderslab.model.User;

import java.util.List;

public interface TherapistService {

    Therapist save(Therapist u);
    Therapist update(Therapist u);
    List<Therapist> findAll();
    Therapist findByName(String name);
    Therapist findById(Long id);
    void deleteTherapist(Long id);

}
