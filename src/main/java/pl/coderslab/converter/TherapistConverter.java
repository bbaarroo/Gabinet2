package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Service.TherapistService;
import pl.coderslab.model.Therapist;
import pl.coderslab.model.User;

public class TherapistConverter implements Converter<String, Therapist> {

    @Autowired
    private TherapistService therapistService;


    @Override
    public Therapist convert(String s) {
        return therapistService.findById(Long.parseLong(s));
    }
}
