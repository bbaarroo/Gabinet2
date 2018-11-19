package pl.coderslab.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.Service.DiseaseService;
import pl.coderslab.model.Disease;
import pl.coderslab.model.Suplement;
import pl.coderslab.repository.DiseaseRepository;
import pl.coderslab.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Disease save(Disease u) {
        return diseaseRepository.save(u);
    }

    @Override
    public Disease update(Disease u) {
        return diseaseRepository.save(u);
    }

    @Override
    public List<Disease> findAll() {
        return diseaseRepository.findAll();
    }

    @Override
    public Disease findByName(String name) {
        return diseaseRepository.findByName(name);
    }

    @Override
    public Disease findById(Long id) {
        return diseaseRepository.findById(id);
    }

    @Override
    public void deleteDisease(Long id) {
        diseaseRepository.delete(id);
    }






}
