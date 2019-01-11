import com.acornejo.springDataDemo.Pojo.Person;
import com.acornejo.springDataDemo.Service.PersonRepositoryImpl;
import com.mongodb.MongoClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MongoApp {

    private static final Log log = LogFactory.getLog(MongoApp.class);

    public static void main(String[] args) {
        PersonRepositoryImpl pRepo = new PersonRepositoryImpl();
        MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "personas"));
        List<Person> people = new ArrayList<>();

        Person p = new Person("Oscar", "Rodriguez");
        pRepo.save(p);
       /* people.add(p);
        Person p2 = new Person("Asier", "Cornejo");
        people.add(p2);
        Person p3 = new Person("Raúl", "Abejón");
        people.add(p3);

        pRepo.saveAll(people);*/

        //findAll
        people = pRepo.findAll();
        for (Person person :
                people) {
            log.info(person.toString());
        }


        // FindByName
        people = pRepo.findByName("Asier");
        log.info("Found " + people.toString());


        //findById
        Optional<Person> optionalPerson = pRepo.findById(p.getId().toString());
        System.out.println(optionalPerson.toString());
        log.info("Found: " + optionalPerson);


        people = pRepo.findFirst3ByLastname("Cornejo", new Sort(new Sort.Order(Sort.Direction.ASC, "apellidos")));
        log.info("Found " + people.toString());


        // Check that deletion worked
     /*   List<Person> people = mongoOps.findAll(Person.class);
        log.info("Number of people = : " + people.size());*/


    }
}