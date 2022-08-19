package org.fasttrackit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(String firstName, String lastName, int age, String city) {
        personList.add(new Person(firstName, lastName, age, city));
    }

    public List<String> personNames() {
        return personList.stream()
                .map(person -> person.firstName() + " " + person.lastName())
                .toList();
    }

    public List<Person> personsThatAreMajor() {
        return personList.stream()
                .filter(person -> person.age() >= 18)
                .toList();
    }

    public List<Person> personsFromOradea() {
        return personList.stream()
                .filter(person -> person.city().equals("Oradea"))
                .toList();
    }

    public List<Person> personsFromOradeaOrCluj() {
        return personList.stream()
                .filter(person -> person.city().equals("Oradea") || person.city().equals("Cluj"))
                .toList();
    }

    public List<String> firstNamesCapitalised() {
        return personList.stream()
                .map(person -> person.firstName().toUpperCase())
                .toList();
    }

    public List<String> firstNameFirstLetterFromLastName() {
        return personList.stream()
                .map(person -> person.firstName() + " " + person.lastName().charAt(0) + ".")
                .toList();
    }

    public List<Person> personsOlderThan18YoungerThan60() {
        return personList.stream()
                .filter(person -> person.age() > 18 && person.age() < 60)
                .toList();
    }

    public List<Person> personsWhoseNameStartsWithA() {
        return personList.stream()
                .filter(person -> person.firstName().charAt(0) == 'A')
                .toList();
    }

    public Set<String> listFirstNamesInSet() {
        return personList.stream()
                .map(Person::firstName)
                .collect(Collectors.toSet());
    }

    public List<Person> personsSortedByFirstName() {
        return personList.stream()
                .sorted(Comparator.comparing(Person::firstName))
                .toList();
    }

    public List<Person> personsSortedByLastName() {
        return personList.stream()
                .sorted(Comparator.comparing(Person::lastName))
                .toList();
    }

    public List<Person> personsSortedByFirstNameThenLastNameThenAge() {
        return personList.stream()
                .sorted(Comparator.comparing(Person::firstName).thenComparing(Person::lastName).thenComparing(Person::age))
                .toList();
    }
}

record Person(String firstName, String lastName, int age, String city) {

}
