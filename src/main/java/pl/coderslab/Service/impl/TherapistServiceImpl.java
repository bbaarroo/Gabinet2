package pl.coderslab.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.Service.TherapistService;
import pl.coderslab.model.Disease;
import pl.coderslab.model.Therapist;
import pl.coderslab.repository.TherapistRepository;
import pl.coderslab.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class TherapistServiceImpl implements TherapistService {

    @Autowired
    private TherapistRepository therapistRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Therapist save(Therapist u) {
        return therapistRepository.save(u);
    }

    @Override
    public Therapist update(Therapist u) {
        return therapistRepository.save(u);
    }

    @Override
    public List<Therapist> findAll() {
        return therapistRepository.findAll();
    }

    @Override
    public Therapist findByName(String name) {
        return therapistRepository.findByName(name);
    }

    @Override
    public Therapist findById(Long id) {
        return therapistRepository.findById(id);
    }

    @Override
    public void deleteTherapist(Long id) {
        therapistRepository.delete(id);
    }




}
