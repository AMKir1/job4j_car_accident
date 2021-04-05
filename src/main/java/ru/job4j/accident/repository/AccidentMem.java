package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import java.util.HashMap;

@Repository
public class AccidentMem {

    HashMap<Integer, Accident> accidents;

    public AccidentMem() {
        this.accidents = new HashMap<>();
        create(Accident.of(1, "Артем", "Велосипедист упал с велосипеда на газон", "г.Москва ул.Кутузовская 15"));
        create(Accident.of(2, "Василий", "Спустило колесо", "г.Москва ул.Судостроительная 23"));
        create(Accident.of(3, "Елена", "Камень попал в окно", "г.Москва ул.Люсиновская 1"));
        create(Accident.of(4, "Евгений", "Отвалился порожек", "г.Москва ул.Тульская 9"));
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


}
