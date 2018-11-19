package pl.coderslab.Service;

import pl.coderslab.model.Disease;
import pl.coderslab.model.Suplement;
import pl.coderslab.model.User;

import java.util.List;

public interface SuplementService {

    Suplement save(Suplement u);
    Suplement update(Suplement u);
    List<Suplement> findAll();
    Suplement findByName(String name);
    Suplement findById(Long id);
    void deleteSuplement(Long id);
    List<Suplement> findSuplementByUserId(Long id);
}
