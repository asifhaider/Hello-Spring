package asif.springjpacrud.topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A singleton spring business service of Topic type of resource

@Service
public class TopicService { // instance of this should be found in the TopicController Class

    @Autowired  // automatically injects this repository class while service class initiates
    private TopicRepository topicRepository;

    public List<Topic>getTopics(){
        // creating an arraylist to store all topics retrieved from the repository in iterator form
        // iterating over the retrieved values and using lambda expressions to add each topics into the list
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        // retrieves the topic object from optional type of object returned by repository
        // it is latest, using additional get() to retrieve the main topic
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);    // adding data into the database
    }

    public void updateTopic(String id, Topic topic){
        // This is amazing. Repository automatically detects if there is something with the same id or not
        // If so, it performs update, if not, creates new data. So no need to specify id separately.
        // save method does the both
        topicRepository.save(topic);
    }

    public void deleteTopic (String id){
        topicRepository.deleteById(id);     // deletes by id
    }
}
