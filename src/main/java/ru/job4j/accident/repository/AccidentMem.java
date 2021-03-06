package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private static final AtomicInteger ID = new AtomicInteger(4);

    public AccidentMem() {

        AccidentType at = AccidentType.of(1, null);

        addAccidents(Accident.of(1, "Артем", "Велосипедист упал с велосипеда на газон", "г.Москва ул.Кутузовская 15", at));
        addAccidents(Accident.of(2, "Василий", "Спустило колесо", "г.Москва ул.Судостроительная 23", at));
        addAccidents(Accident.of(3, "Елена", "Камень попал в окно", "г.Москва ул.Люсиновская 1", at));
        addAccidents(Accident.of(4, "Евгений", "Отвалился порожек", "г.Москва ул.Тульская 9", at));
    }

    public Collection<Accident> getAccidents() {
        return this.accidents.values();
    }

    public void addAccidents(Accident accident) {
        if(accident.getId() == 0) {
            accident.setId(ID.incrementAndGet());
        }
        this.accidents.put(accident.getId(), accident);
    }

    public Accident findById(int id) {
        return this.accidents.get(id);
    }


}
