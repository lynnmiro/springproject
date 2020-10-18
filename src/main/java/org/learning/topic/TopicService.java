package org.learning.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JavaScript Description")));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        for (Topic topic: topics){
            String temp = topic.getId();
            if (temp.equals(id)){
                return topic;
            }
        }

        return null;
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id){
        for(int i = 0; i < topics.size(); i++){
            Topic topic1 = topics.get(i);
            if(topic1.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id){
        for(int i = 0; i < topics.size(); i++){
            Topic topic1 = topics.get(i);
            if(topic1.getId().equals(id)){
                topics.remove(topic1);
                return;
            }
        }
    }
}
