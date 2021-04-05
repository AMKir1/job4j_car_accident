package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentMem {

    HashMap<Integer, Accident> accidents;

    public AccidentMem() {
        this.accidents = new HashMap<>();

        AccidentType at = AccidentType.of(1, null);

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


}
