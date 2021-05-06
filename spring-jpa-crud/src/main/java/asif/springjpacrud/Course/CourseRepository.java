package asif.springjpacrud.Course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// getAllTopics (), getTopic (String id), updateTopic (Topic t), deleteTopic (String id)
// Spring Data JPA will implement this repository implementation for us
// We just need to create such an interface
// The generic type is the model object type and the primary key type
// Using embedded Apache Derby for now

public interface CourseRepository extends CrudRepository <Course, String> {
    // automatically spring JPA will implement and utilize methods of it
    // we might add our custom methods if needed
    // while mapping topics to courses, we need a method that returns all courses associated with any topicID
    // we can name this methods in a particular way to take help from spring data
    // e.g. getSomeObjectBySomeAttribute()

    List<Course> findByTopicId(String topicID);

}
