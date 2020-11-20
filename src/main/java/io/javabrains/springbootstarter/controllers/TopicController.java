package io.javabrains.springbootstarter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.models.Topics;
import io.javabrains.springbootstarter.services.TopicService;

@RestController
public class TopicController {
	@Autowired
	private TopicService _topicService;
	
	@RequestMapping("/topics")
	public List<Topics> getAllTopics(){
		List<Topics> topics = _topicService.getAllTopics();
		return topics;
	}
	
	@RequestMapping("/topics/{id}")
	public Topics getTopic(@PathVariable String id){
		Topics topic = _topicService.getTopic(id);
		return topic;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topics topic){
		_topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topics topic, @PathVariable String id){
		_topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id){
		_topicService.deleteTopic(id);
	}
}