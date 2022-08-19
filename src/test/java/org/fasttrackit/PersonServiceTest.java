package org.fasttrackit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService();
        personService.addPerson("Mircea", "Mirceau", 28, "Oradea");
        personService.addPerson("Marcel", "Marcelus", 16, "Cluj");
        personService.addPerson("Marius", "Mariusus", 37, "Timisoara");
        personService.addPerson("Ariana", "Arianus", 23, "Oradea");
        personService.addPerson("Adina", "Adi", 68, "Cluj");
    }

    @Test
    void testAddPerson() {
        org.assertj.core.api.Assertions.assertThat(personService.getPersonList()).containsExactly(
                new Person("Mircea", "Mirceau", 28, "Oradea"),
                new Person("Marcel", "Marcelus", 16, "Cluj"),
                new Person("Marius", "Mariusus", 37, "Timisoara"),
                new Person("Ariana", "Arianus", 23, "Oradea"),
                new Person("Adina", "Adi", 68, "Cluj")
        );
    }

    @Test
    void testPersonNames() {
        Assertions.assertEquals("Mircea " + "Mirceau", personService.personNames().get(0));
        Assertions.assertEquals("Adina " + "Adi", personService.personNames().get(4));
    }

    @Test
    void testPersonsThatAreMajor() {
        org.assertj.core.api.Assertions.assertThat(personService.personsThatAreMajor()).containsExactly(
                new Person("Mircea", "Mirceau", 28, "Oradea"),
                new Person("Marius", "Mariusus", 37, "Timisoara"),
                new Person("Ariana", "Arianus", 23, "Oradea"),
                new Person("Adina", "Adi", 68, "Cluj")
        );
    }

    @Test
    void testPersonsFromOradea() {
        org.assertj.core.api.Assertions.assertThat(personService.personsFromOradea()).containsExactly(
                new Person("Mircea", "Mirceau", 28, "Oradea"),
                new Person("Ariana", "Arianus", 23, "Oradea")
        );
    }

    @Test
    void testPersonsFromOradeaOrCluj() {
        org.assertj.core.api.Assertions.assertThat(personService.personsFromOradeaOrCluj()).containsExactly(
                new Person("Mircea", "Mirceau", 28, "Oradea"),
                new Person("Marcel", "Marcelus", 16, "Cluj"),
                new Person("Ariana", "Arianus", 23, "Oradea"),
                new Person("Adina", "Adi", 68, "Cluj")
        );
    }

    @Test
    void testFirstNamesCapitalised() {
        org.assertj.core.api.Assertions.assertThat(personService.firstNamesCapitalised()).containsExactly(
                "MIRCEA", "MARCEL", "MARIUS", "ARIANA", "ADINA"
        );
    }

    @Test
    void testFirstNameFirstLetterFromLastName() {
        org.assertj.core.api.Assertions.assertThat(personService.firstNameFirstLetterFromLastName()).containsExactly(
                "Mircea M.", "Marcel M.", "Marius M.", "Ariana A.", "Adina A."
        );
    }

    @Test
    void testPersonsOlderThan18YoungerThan60() {
        org.assertj.core.api.Assertions.assertThat(personService.personsOlderThan18YoungerThan60()).containsExactly(
                new Person("Mircea", "Mirceau", 28, "Oradea"),
                new Person("Marius", "Mariusus", 37, "Timisoara"),
                new Person("Ariana", "Arianus", 23, "Oradea")
        );
    }

    @Test
    void testPersonsWhoseNameStartsWithA() {
        org.assertj.core.api.Assertions.assertThat(personService.personsWhoseNameStartsWithA()).containsExactly(
                new Person("Ariana", "Arianus", 23, "Oradea"),
                new Person("Adina", "Adi", 68, "Cluj")
        );
    }

    @Test
    void testListFirstNamesInSet() {
        org.assertj.core.api.Assertions.assertThat(personService.listFirstNamesInSet()).contains(
                "Mircea","Marcel", "Marius", "Ariana", "Adina"
        );
    }

    @Test
    void testPersonsByFirstName() {
        org.assertj.core.api.Assertions.assertThat(personService.personsSortedByFirstName()).containsExactly(
                new Person("Adina", "Adi", 68, "Cluj"),
                new Person("Ariana", "Arianus", 23, "Oradea"),
                new Person("Marcel", "Marcelus", 16, "Cluj"),
                new Person("Marius", "Mariusus", 37, "Timisoara"),
                new Person("Mircea", "Mirceau", 28, "Oradea")
        );
    }

    @Test
    void testPersonsByLastName() {
        org.assertj.core.api.Assertions.assertThat(personService.personsSortedByLastName()).containsExactly(
                new Person("Adina", "Adi", 68, "Cluj"),
                new Person("Ariana", "Arianus", 23, "Oradea"),
                new Person("Marcel", "Marcelus", 16, "Cluj"),
                new Person("Marius", "Mariusus", 37, "Timisoara"),
                new Person("Mircea", "Mirceau", 28, "Oradea")
        );
    }

    @Test
    void testPersonsSortedByFirstNameThenLastNameThenAge() {
        org.assertj.core.api.Assertions.assertThat(personService.personsSortedByFirstNameThenLastNameThenAge()).containsExactly(
                new Person("Adina", "Adi", 68, "Cluj"),
                new Person("Ariana", "Arianus", 23, "Oradea"),
                new Person("Marcel", "Marcelus", 16, "Cluj"),
                new Person("Marius", "Mariusus", 37, "Timisoara"),
                new Person("Mircea", "Mirceau", 28, "Oradea")
        );
    }
}
