package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentMem {

    HashMap<Integer, Accident> accidents;
    List<Rule> rules;

    public AccidentMem() {
        this.accidents = new HashMap<>();
        this.rules = new ArrayList<>();

        AccidentType at = AccidentType.of(1, null);

        rules.add(Rule.of(1, "Статья. 1"));
        rules.add(Rule.of(2, "Статья. 2"));
        rules.add(Rule.of(3, "Статья. 3"));

        create(Accident.of(1, "Артем", "Велосипедист упал с велосипеда на газон", "г.Москва ул.Кутузовская 15", at));
        create(Accident.of(2, "Василий", "Спустило колесо", "г.Москва ул.Судостроительная 23", at));
        create(Accident.of(3, "Елена", "Камень попал в окно", "г.Москва ул.Люсиновская 1", at));
        create(Accident.of(4, "Евгений", "Отвалился порожек", "г.Москва ул.Тульская 9", at));
    }

    public HashMap<Integer, Accident> getAccidents() {
        return accidents;
    }

    public void create(Accident accident) {
        this.accidents.put(accident.getId(), accident);
    }

    public void update(Accident accident) {
        this.accidents.replace(accident.getId(), accident);
    }

    public Accident findById(int id) {
        return this.accidents.get(id);
    }

    public List<AccidentType> getTypes() {
        List<AccidentType> types = new ArrayList<>();
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
        return types;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public Rule getRuleById(int id) {
        Rule result = null;
        for(Rule rule : this.rules) {
            if(rule.getId() == id) {
                result = rule;
                break;
            }
        }
        return result;
    }
}
