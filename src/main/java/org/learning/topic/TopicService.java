package org.learning.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JavaScript Description")));

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        Iterable<Topic> itr = topicRepository.findAll();
        for (Topic topic: itr){
            topics.add(topic);
        }
        return topics;
    }

    public Topic getTopic(String id){
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id){
        topicRepository.save(topic);
    }

    public void deleteTopic(String id){
        topicRepository.delete(id);
    }
}
