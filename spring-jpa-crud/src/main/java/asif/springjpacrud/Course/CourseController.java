package asif.springjpacrud.Course;

import asif.springjpacrud.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // automatically converts any type of return objects into default json
public class CourseController {

    // GET /topics => Gets all topics
    // GET /topics/id => Gets a certain topic
    // POST /topics => Create new topic
    // PUT /topics/id => Updates the topic
    // DELETE /topics/id => Deletes a particular topic

    @Autowired
    private CourseService courseService; // constructor injection needed, performed by Autowired

    // by default GET request inside RequestMapping
    @RequestMapping("/topics/{id}/courses") // the plural version of the resource class is a REST API convention
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getCourses(id);
    }

    @RequestMapping("/topics/{topicID}/courses/{id}") // { } are used to denote any variable portion of the mapping path
    public Course getCourse(@PathVariable String id){
        // @PathVariable annotation tells spring to look for the exact variable associated with the class path
        // that needs to be passed inside this method
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST,
    value = "/topics/{topicID}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicID){
        // RequestBody converts the mapped item to a json Topic object
        course.setTopic(new Topic(topicID, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT,
    value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id,
                             @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}