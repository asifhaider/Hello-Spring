package asif.springdemoamigo.data;

import asif.springdemoamigo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonData {

    // person with id
    int insertPerson(UUID id, Person person);

    // person without id
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> showAllPeople();
    int deletePersonById (UUID id);
    int updatePersonById (UUID id, Person person);
    Optional<Person> selectPersonById (UUID id);    // what is it?
}
