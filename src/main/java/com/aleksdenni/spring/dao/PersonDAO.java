package com.aleksdenni.spring.dao;
import com.aleksdenni.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people=new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom"));
        people.add(new Person(++PEOPLE_COUNT,"Bob"));
        people.add(new Person(++PEOPLE_COUNT,"Mike"));
        people.add(new Person(++PEOPLE_COUNT,"Katy"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person personUpdate) {
        Person personToByUpdate = show(id);
        personToByUpdate.setName(personUpdate.getName());
    }

    public void delete(int id) {
        people.remove(id-1); // or
        ///people.removeIf(p -> p.getId() == id);
    }
}