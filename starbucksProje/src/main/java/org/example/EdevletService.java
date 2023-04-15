package org.example;

import java.util.ArrayList;
import java.util.List;

public class EdevletService {
    //class ayağa kalkarken staticler çalışacak ve bize nesnelerimizi oluşturacak

    // Burada ki amaç tamamen task'a yönelik bir kullanımdır.
    private static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person("Tarik", "BOZKURT", 1996, "12345"));
        personList.add(new Person("Fatih", "SAHAN", 1996, "123456789"));
        personList.add(new Person("Yusuf", "DEMIRCAN", 1996, "54321"));
        personList.add(new Person("Yusuf", "DORUK", 1996, "987654321"));
    }

    public boolean verify(String name, String lasName, int birthYear, String nationalId) {

        for (Person person : personList) {
            if (person.getNationalId().equals(nationalId) &&
                    person.getBirthYear() == birthYear &&
                    person.getName().equals(name) &&
                    person.getLastName().equals(lasName)
            ) {
                return true;
            }

        }
        return false;

    }

}
