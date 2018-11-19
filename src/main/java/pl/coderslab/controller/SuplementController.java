package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Service.SuplementService;
import pl.coderslab.dto.SuplementDto;
import pl.coderslab.dto.UserDto;
import pl.coderslab.model.Suplement;
import pl.coderslab.model.User;
import pl.coderslab.utils.CsvUtils;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/app/suplements")
public class SuplementController {


    @Autowired
    private SuplementService suplementService;


    @RequestMapping(path = "/showall", method = RequestMethod.GET)
    public String showAll(Model model) {

        model.addAttribute("suplements", suplementService.findAll());

        return "SuplementList";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {

        suplementService.deleteSuplement(id);

        return "redirect:../showall";
    }



    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addUser(Model model) {

        model.addAttribute("suplement", new Suplement());
        return "form/AddSuplement";
    }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String save(@ModelAttribute SuplementDto suplementDto) {
//    public String saveBook(@Valid UserDto userDto, BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "form/AddUser";
//        }

        if (suplementDto.getId() == null) {
            Suplement suplement = new Suplement();

            suplement.setName(suplementDto.getName());
            suplement.setSuplementDescription(suplementDto.getSuplementDescription());

            suplementService.save(suplement);
        } else {

            Suplement suplement = suplementService.findById(suplementDto.getId());

            suplement.setName(suplementDto.getName());
            suplement.setSuplementDescription(suplementDto.getSuplementDescription());

            suplementService.save(suplement);
        }


        return "redirect:../suplements/showall";

    }


    @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {

        Suplement suplement = suplementService.findById(id);

        model.addAttribute("suplement",suplement);
        return "form/AddSuplement";
    }


    @RequestMapping(path = "/readCsv")
            public String readSuplements(Model model) {


        File initialFile = new File("/home/bbi/Pulpit/maven/Gabinet2/src/main/webapp/static/Suplementy.csv");
        InputStream targetStream = null;
        try {
            targetStream = new FileInputStream(initialFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            List<Suplement> suplements = CsvUtils.read(Suplement.class, targetStream, ';');


            for (Suplement s: suplements) {
                suplementService.save(s);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        return "redirect:../suplements/showall";
    }

}
