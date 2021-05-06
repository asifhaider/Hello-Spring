package asif.springjpacrud.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController // automatically converts any type of return objects into default json
public class TopicController {

    // GET /topics => Gets all topics
    // GET /topics/id => Gets a certain topic
    // POST /topics => Create new topic
    // PUT /topics/id => Updates the topic
    // DELETE /topics/id => Deletes a particular topic

    @Autowired
    private TopicService topicService; // constructor injection needed, performed by Autowired

//  ============================== Applicable without business service structure ==========================
//    public List<Topic> getAllTopics(){
//        return Arrays.asList(
//                // will be converted to json automatically
//                new Topic("1", "Spring", "Backend Java Framework"),
//                new Topic("1", "React", "Frontend Javascript Framework"),
//                new Topic("1", "Python", "Language")
//        );
//    }
//  ========================================================================================================

    // by default GET request inside RequestMapping
    @RequestMapping("/topics") // the plural version of the resource class is a REST API convention
    public List<Topic> getAllTopics(){
        return topicService.getTopics();
    }

    @RequestMapping("/topics/{id}") // { } are used to denote any variable portion of the mapping path
    public Topic getTopic(@PathVariable String id){
        // @PathVariable annotation tells spring to look for the exact variable associated with the class path
        // that needs to be passed inside this method
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST,
    value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        // RequestBody converts the mapped item to a json Topic object
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT,
    value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}