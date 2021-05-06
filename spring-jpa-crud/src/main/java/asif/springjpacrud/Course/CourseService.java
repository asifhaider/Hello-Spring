package asif.springjpacrud.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// A singleton spring business service of Topic type of resource

@Service
public class CourseService { // instance of this should be found in the TopicController Class

    @Autowired  // automatically injects this repository class while service class initiates
    private CourseRepository courseRepository;

    public List<Course>getCourses(String topicID){
        // creating an arraylist to store all topics retrieved from the repository in iterator form
        // implementing the interface method defined for this task
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicID).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){
        // retrieves the topic object from optional type of object returned by repository
        // it is latest, using additional get() to retrieve the main topic

        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course){
        courseRepository.save(course);    // adding data into the database
    }

    public void updateCourse (Course course){
        // This is amazing. Repository automatically detects if there is something with the same id or not
        // If so, it performs update, if not, creates new data. So no need to specify id separately.
        // save method does the both
        courseRepository.save(course);
    }

    public void deleteCourse (String id){
        courseRepository.deleteById(id);     // deletes by id
    }
}
