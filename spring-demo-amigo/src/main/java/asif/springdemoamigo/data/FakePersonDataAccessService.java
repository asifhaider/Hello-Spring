package asif.springdemoamigo.data;

import asif.springdemoamigo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Doing initially with array lists, so named fake
// Original one will be implemented with postgresql

@Repository("fakeData")
public class FakePersonDataAccessService implements PersonData{

    private static List<Person> personList = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personList.add(new Person(
                id, person.getName()
        ));
        return 1;
    }

    @Override
    public List<Person> showAllPeople() {
        return personList;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person>personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty())
            return 0;
        personList.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(person1 -> {
            int indexOfPersonToUpdate = personList.indexOf(person1);
            if(indexOfPersonToUpdate >= 0){
                personList.set(indexOfPersonToUpdate, new Person(id, person.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return personList.stream().filter(
                person -> person.getId().equals(id)
        ).findFirst();
    }
}
