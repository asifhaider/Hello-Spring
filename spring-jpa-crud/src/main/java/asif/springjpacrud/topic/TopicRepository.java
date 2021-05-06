package asif.springjpacrud.topic;

import org.springframework.data.repository.CrudRepository;

// getAllTopics (), getTopic (String id), updateTopic (Topic t), deleteTopic (String id)
// Spring Data JPA will implement this repository implementation for us
// We just need to create such an interface
// The generic type is the model object type and the primary key type
// Using embedded Apache Durby for now

public interface TopicRepository extends CrudRepository<Topic, String> {
    // automatically spring JPA will implement and utilize methods of it
}
