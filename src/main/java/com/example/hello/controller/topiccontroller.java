package com.example.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class topiccontroller {
        
     @Autowired
        private topicservice topicservice;
    
        @RequestMapping ("/topics")
        public List<topic> getAllTopics(){
             return topicservice.getAllTopics();
        }
        
        @RequestMapping ("/topics/{id}")
        public topic getTopic(@PathVariable String id) {
             return topicservice.getTopic(id);
        }

        @RequestMapping(method=RequestMethod.POST, value ="/topics")
        public void addTopic(@RequestBody topic topic) {
             topicservice.addTopic(topic);
        }

        @RequestMapping(method=RequestMethod.PUT, value ="/topics/{id}")
        public void updateTopic(@RequestBody topic topic, @PathVariable String id) {
             topicservice.updateTopic(id, topic);
    }

        @RequestMapping(method=RequestMethod.DELETE, value ="/topics/{id}")
        public void deleteTopic(@PathVariable String id) {
        topicservice.deleteTopic(id);
    }

}