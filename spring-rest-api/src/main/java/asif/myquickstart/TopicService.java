package asif.myquickstart;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A singleton spring business service of Topic type of resource

@Service
public class TopicService { // instance of this should be found in the TopicController Class

    // Arraylist type is mutable, so we can apply POST request or add element to this data structure
    // Arrays are immutable on the other hand
    // Both ways, these are hard-coded for now
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
                // will be converted to json automatically
                new Topic("1", "Spring", "Backend Java Framework"),
                new Topic("2", "React", "Frontend Javascript Framework"),
                new Topic("3", "Python", "Language")
        ));
    public List<Topic>getTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(topic -> topic.getId().equals(id))
                .findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic){
        for (int i=0; i<topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic (String id){
        topics.removeIf(t -> t.getId().equals(id));
    }
}
