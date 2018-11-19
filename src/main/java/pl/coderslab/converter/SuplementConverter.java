package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Service.SuplementService;
import pl.coderslab.model.Suplement;

public class SuplementConverter implements Converter<String, Suplement> {

    @Autowired
    private SuplementService suplementService;

    @Override
    public Suplement convert(String s) {
        return suplementService.findById(Long.parseLong(s));
    }
}
