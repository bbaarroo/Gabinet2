package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.Service.DiseaseService;
import pl.coderslab.dto.DiseaseDto;
import pl.coderslab.dto.TherapistDto;
import pl.coderslab.model.Disease;
import pl.coderslab.model.Therapist;

@Controller
@RequestMapping("/app/diseases")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @RequestMapping(path = "/showall", method = RequestMethod.GET)
    public String showAll(Model model) {

        model.addAttribute("diseases", diseaseService.findAll());

        return "DiseaseList";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {

        diseaseService.deleteDisease(id);

        return "redirect:../showall";
    }


    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addUser(Model model) {

        model.addAttribute("disease", new Disease());
        return "form/AddDisease";
    }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String save(@ModelAttribute DiseaseDto diseaseDto ) {
//    public String saveBook(@Valid UserDto userDto, BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "form/AddUser";
//        }



        if (diseaseDto.getId() == null) {
            Disease disease = new Disease();

            disease.setName(diseaseDto.getName());

            diseaseService.save(disease);

        } else {
            Disease disease = diseaseService.findById(diseaseDto.getId());

            disease.setName(diseaseDto.getName());

            diseaseService.save(disease);
        }




        return "redirect:showall";

    }


    @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {

        Disease disease = diseaseService.findById(id);

        model.addAttribute("disease",disease);
        return "form/AddDisease";
    }
}
