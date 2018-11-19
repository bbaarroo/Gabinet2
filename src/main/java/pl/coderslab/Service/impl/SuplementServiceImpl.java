package pl.coderslab.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.Service.SuplementService;
import pl.coderslab.model.Suplement;
import pl.coderslab.repository.SuplementRepository;
import pl.coderslab.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class SuplementServiceImpl implements SuplementService {

    @Autowired
    private SuplementRepository suplementRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Suplement save(Suplement u) {
        return suplementRepository.save(u);
    }

    @Override
    public Suplement update(Suplement u) {
        return suplementRepository.save(u);
    }

    @Override
    public List<Suplement> findAll() {
        return suplementRepository.findAll();
    }

    @Override
    public Suplement findByName(String name) {
        return suplementRepository.findByName(name);
    }

    @Override
    public Suplement findById(Long id) {
        return suplementRepository.findById(id);
    }

    @Override
    public void deleteSuplement(Long id) {
        suplementRepository.delete(id);
    }

    public List<Suplement> findSuplementByUserId(Long id) {

        return suplementRepository.findByUsers(new HashSet<>(Arrays.asList(userRepository.findById(id))));
    }
}
