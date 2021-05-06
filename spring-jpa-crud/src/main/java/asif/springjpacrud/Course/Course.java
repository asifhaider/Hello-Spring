package asif.springjpacrud.Course;
import asif.springjpacrud.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// this class is the data to be stored in table/database
// this is our model to be presented to JPA
@Entity
public class Course {

    @Id // this indicates the primary key of the database
    private String id;
    private String name;
    private String description;

    // Entity relationship mapping should be established here
    @ManyToOne  // There can be many courses related to one topic, as we have designed
    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Course(String id, String name, String description, String topicID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicID, "", "");
    }

    public Course() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
