package pl.coderslab.controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.Service.DiseaseService;
import pl.coderslab.Service.SuplementService;
import pl.coderslab.Service.TherapistService;
import pl.coderslab.Service.UserService;
import pl.coderslab.dto.UserDto;
import pl.coderslab.model.Disease;
import pl.coderslab.model.Suplement;
import pl.coderslab.model.Therapist;
import pl.coderslab.model.User;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Stream;

@Controller
@RequestMapping("/app/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SuplementService suplementService;

    @Autowired
    private TherapistService therapistService;

    @Autowired
    private DiseaseService diseaseService;


    @RequestMapping(path = "/showall", method = RequestMethod.GET)
    public String showAll(Model model) {

        model.addAttribute("users", userService.findAll());

        return "UserList";
    }


    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addUser(Model model) {

        model.addAttribute("user", new User());
        return "form/AddUser";
    }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String save(@Valid UserDto userDto, BindingResult result) {

        if (result.hasErrors()) {
            return "form/AddUser";
        }

        if (userDto.getId() == null) {
            User user = new User();
            user.setName(userDto.getName());
            user.setLastName(userDto.getLastName());
            user.setPesel(userDto.getPesel());
            user.setDiseaseList(userDto.getDiseaseList());
            user.setSuplements(userDto.getSuplements());
            user.setTherapistList(userDto.getTherapistList());
            user.setRecommendation(userDto.getRecommendation());
            user.setComments(userDto.getComments());
            user.setPhnoneNumber(userDto.getPhnoneNumber());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setNextVisit(formatter.parse(userDto.getNextVisit()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            userService.save(user);

        } else {
            User user = userService.findById(userDto.getId());
            user.setName(userDto.getName());
            user.setLastName(userDto.getLastName());
            user.setPesel(userDto.getPesel());
            user.setDiseaseList(userDto.getDiseaseList());
            user.setSuplements(userDto.getSuplements());
            user.setTherapistList(userDto.getTherapistList());
            user.setRecommendation(userDto.getRecommendation());
            user.setComments(userDto.getComments());
            user.setPhnoneNumber(userDto.getPhnoneNumber());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setNextVisit(formatter.parse(userDto.getNextVisit()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            userService.save(user);
        }

        return "redirect:showall";

    }


    @ModelAttribute("diseases")
    public List<Disease> getDiseases() {

        return diseaseService.findAll();
    }


    @ModelAttribute("suplements")
    public List<Suplement> getSuplements() {

        return suplementService.findAll();
    }


    @ModelAttribute("therapists")
    public List<Therapist> getTherapists() {

        return therapistService.findAll();
    }

    @RequestMapping(path = "/showOne/{id}", method = RequestMethod.GET)
    public String showOne(Model model, @PathVariable Long id) {

        List<Suplement> suplements = suplementService.findSuplementByUserId(id);

        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("suplements", suplements);
        return "UserShowOne";

    }


    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {

        userService.deleteUser(id);

        return "redirect:../showall";
    }


    @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable long id) {

        User user = userService.findById(id);


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        try {
            String nextVisit = user.getNextVisitString();
            user.setNextVisit(formatter.parse(nextVisit));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("user", user);
        return "form/AddUser";
    }


    @RequestMapping(path = "/toPdf/{id}", method = RequestMethod.GET)
    public void toPdf(@PathVariable long id, HttpServletResponse response) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("/home/bbi/Pulpit/maven/Gabinet2/file.pdf"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();

//        Font font = FontFactory.getFont(FontFactory.TIMES, 12, BaseColor.BLACK);
//        Chunk chunk = new Chunk(userService.findById(id).toString(), font);

        PdfPTable table = new PdfPTable(8);
        addTableHeader(table, id);
        addRows(table, id);


        try {
//            document.add(chunk);
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();

        try {
            // get your file as InputStream
            File initialFile = new File("/home/bbi/Pulpit/maven/Gabinet2/file.pdf");
            InputStream is = new FileInputStream(initialFile);
            // copy it to response's OutputStream
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.setContentType("application/pdf");
            response.flushBuffer();

        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        }

    }


    private void addTableHeader(PdfPTable table, Long id) {
        Stream.of("imie", "nazwisko", "pesel", "nast.wizyta", "choroby", "suplementy", "terapeuci", "zalecenia")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, Long id) {
        table.addCell(userService.findById(id).getName());
        table.addCell(userService.findById(id).getLastName());
        table.addCell(userService.findById(id).getPesel());
        table.addCell(userService.findById(id).getNextVisitString());
        table.addCell(userService.findById(id).getDiseaseList().toString());
        table.addCell(userService.findById(id).getSuplements().toString());
        table.addCell(userService.findById(id).getTherapistList().toString());
        table.addCell(userService.findById(id).getRecommendation());


    }

}
