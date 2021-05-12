package asif.springdemoamigo.service;

import asif.springdemoamigo.data.PersonData;
import asif.springdemoamigo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonData personData;

    @Autowired
    public PersonService(@Qualifier("fakeData") PersonData personData) {
        this.personData = personData;
    }

    public int addPerson(Person person){
        return personData.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personData.showAllPeople();
    }

    public Optional<Person> getPersonById (UUID id){
        return personData.selectPersonById(id);
    }

    public int deletePersonById (UUID id){
        return personData.deletePersonById(id);
    }

    public int updatePersonById (UUID id, Person person){
        return personData.updatePersonById(id, person);
    }
}
