package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Service.DiseaseService;
import pl.coderslab.model.Disease;

public class DiseaseConverter implements Converter<String, Disease> {

    @Autowired
    private DiseaseService diseaseService;

    @Override
    public Disease convert(String s) {
        return diseaseService.findById(Long.parseLong(s));
    }
}
