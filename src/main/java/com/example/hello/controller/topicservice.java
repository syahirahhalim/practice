package com.example.hello.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class topicservice {
    
    List<topic> topics = new ArrayList<>(Arrays.asList(
        new topic("spring", "Spring Framework", "Spring Framework Description"),
        new topic("java", "Core Java", "Core Java Description"),
        new topic("javascript", "Javascript", "Javascript Description")
        ));
 
        public List<topic> getAllTopics(){
            return topics;
        }

        public topic getTopic(String id){
            return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
        }

        public void addTopic(topic topic) {
            topics.add(topic);
        }

        public void updateTopic(String id, topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

        public void deleteTopic(String id) {
            topics.removeIf(t -> t.getId().equals(id));
        }
}   