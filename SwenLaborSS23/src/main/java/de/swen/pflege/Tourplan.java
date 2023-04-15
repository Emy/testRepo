package de.swen.pflege;

import de.swen.pflege.CentralClientFinder;
import de.swen.pflege.SapService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Ein de.swen.pflege.Tourplan enthält eine Liste von Klienten, die
 * von der Pflegefachkfraft behandelt werden sollten.
 * Im de.swen.pflege.Tourplan sollten keine redundanten Klientennamen
 * enthalten sein. Die Liste der Klienten wird in zwei
 * Diensten geführt.
 */
public class Tourplan {
    private CentralClientFinder centralFinder;
    private SapService service;
    private String name;

    Tourplan(String name, CentralClientFinder f, SapService s) {
        this.name = name;
        if (name.length() < 3) {
            throw new IllegalArgumentException("Der Name muss mindestens 3 Zeichen lang sein!");
        } else if (name.length() > 31) {
            throw new IllegalArgumentException("Der Name darf maximal 31 Zeichen lang sein!");
        } else if (name == null) {
            throw new IllegalArgumentException("Name darf nicht leer sein!");
        }
        centralFinder = f;
        service = s;
    }

    /**
     * @return List der Klienten (ohne Duplikate)
     */
    public List<String> getClients() {

        List<String> list = new ArrayList<String>();
        list.addAll(centralFinder.getClients(name));
        list = addWithoutDuplicates(list, service.getSapClientsForName(name));

        if (list.isEmpty()) {
            return (list);
        }

        return (list);
    }

    /**
     * @param list erste Liste mit Klienten
     * @param l    zweite Liste mit Klienten
     * @return bereinigte Liste der Klienten (keine Duplikate enthalten)
     */
    private List<String> addWithoutDuplicates(List<String> list, List<String> l) {
        // TODO noch werden keine Duplikate entfernt ...
        l = list.stream().distinct().collect(Collectors.toList());
        // List<String> result = new ArrayList<String>();
        // List<String> newList = new ArrayList<>();
        //newList.addAll(list);
        // newList.addAll(l);
        //for (String string : newList) {
        // boolean found = false;
        //for (String elem : result) {
        //   if (string.equals(elem)) {
        //     found = true;
        //  }
        //  if(!found) result.add(string);
        // }
//}
        // return (result);
        //}
        return (l);
    }
}