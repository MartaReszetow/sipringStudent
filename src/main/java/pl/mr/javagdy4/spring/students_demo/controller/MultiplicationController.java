package pl.mr.javagdy4.spring.students_demo.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

// RestController - jeśli wynikiem jest treść (json) (rest api)
// Controller - jeśli wynikiem jest widok (html, jsp,...)
@Controller // jest różnica między controller vs rest controller
@RequestMapping(path = "/") // - prefix
public class MultiplicationController {
    // 1. request parameters
    // 2. attributes
    // 3. mappings

// #################
// # REQUEST PARAM#
// #################


    // localhost:8080/
    // localhost:8080/?imie=baca -> Welcome baca!
//    @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String indexPage(Model model, @RequestParam(name = "imie", required = false) String imie){
        model.addAttribute("moje_imie", imie);
        return "index";
    }


// #################
// # PATH VARIABLE #
// #################
// localhost:8080/welcome/     - Heloł heloł maj frend!
// localhost:8080/welcome/baca -> Welcome baca!
//
    @GetMapping("/welcome/{imie_param}")
    public String indexPagePathVariable(Model model, @PathVariable(name = "imie_param", required = false) String imie){
        model.addAttribute("moje_imie", imie);
        return "index";
    }

// #################
// # Multiply fORM #
// #################

    // GET - wyświetl formularz
    @GetMapping("/multiply")
    public String multiplyForm(){
        return "multiplication";
    }

    // POST - odbierz dane z wypełnionego formularza i wyświelt tabliczkę mnożenia
    @PostMapping("/multiply")
    public String multiply(Model model,
                           @RequestParam(name="rows", defaultValue = "10") int rows, @RequestParam(name="cols", defaultValue = "10") int cols){
        model.addAttribute("rowNum", rows);
        model.addAttribute("colNum", cols);
        return "multiplication";
    }

}