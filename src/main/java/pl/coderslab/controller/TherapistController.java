package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.Service.TherapistService;
import pl.coderslab.dto.SuplementDto;
import pl.coderslab.dto.TherapistDto;
import pl.coderslab.model.Suplement;
import pl.coderslab.model.Therapist;

import javax.validation.Valid;

@Controller
@RequestMapping("/app/therapists")
public class TherapistController {

    @Autowired
    private TherapistService therapistService;

    @RequestMapping(path = "/showall", method = RequestMethod.GET)
    public String showAll(Model model) {

        model.addAttribute("therapists", therapistService.findAll());

        return "TherapistList";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {

        therapistService.deleteTherapist(id);

        return "redirect:../showall";
    }


    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addUser(Model model) {

        model.addAttribute("therapist", new Therapist());
        return "form/AddTherapist";
    }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String save(@Valid TherapistDto therapistDto, BindingResult result) {

        if (result.hasErrors()) {
            return "form/AddTherapist";
        }

        if (therapistDto.getId() == null) {

            Therapist therapist = new Therapist();

            therapist.setName(therapistDto.getName());
            therapist.setSpecialization(therapistDto.getSpecialization());

            therapistService.save(therapist);


        } else {

            Therapist therapist = therapistService.findById(therapistDto.getId());

            therapist.setName(therapistDto.getName());
            therapist.setSpecialization(therapistDto.getSpecialization());

            therapistService.save(therapist);

        }
        return "redirect:showall";
    }


    @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {

        Therapist therapist = therapistService.findById(id);

        model.addAttribute("therapist",therapist);
        return "form/AddTherapist";
    }

}
