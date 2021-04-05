package ru.job4j.accident.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentMem;

@Controller
public class IndexControl {

    @Autowired
    AccidentMem accidentMem;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list", accidentMem.getAccidents());
        return "index";
    }
}
