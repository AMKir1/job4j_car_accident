package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypeRepository;
import ru.job4j.accident.repository.RuleRepository;

import javax.servlet.http.HttpServletRequest;

import java.util.*;

@Controller
public class AccidentControl {

    private final AccidentRepository accidents;
    private final AccidentTypeRepository types;
    private final RuleRepository rules;

    private Set<Rule> ruleSet = new HashSet<>();
    private Set<AccidentType> typeSet = new HashSet<>();

    public AccidentControl(AccidentRepository accidents, RuleRepository rules, AccidentTypeRepository types) {
        this.accidents = accidents;
        this.rules = rules;
        this.types = types;

        rules.findAll().forEach(ruleSet::add);
        types.findAll().forEach(typeSet::add);
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("rules", ruleSet);
        model.addAttribute("types", typeSet);
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        if(req.getParameterValues("rIds") != null) {
            String[] ids = req.getParameterValues("rIds");
            for (int i = 0; i < ids.length; i++) {
                accident.addRule(rules.findById(Integer.parseInt(ids[i])).get());
            }
        }
        if(!accidents.existsById(accident.getId()) || accident.getId() == 0) {
            accident.setId((int) accidents.count() + 1);
        }
        accident.setType(types.findById(accident.getType().getId()).get());
        accidents.save(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam int key, Model model) {
        model.addAttribute("rules", ruleSet);
        model.addAttribute("types", typeSet);
        model.addAttribute("accident", accidents.findById(key).get());
        return "accident/edit";
    }
}
