package io.javabrains.springbootstarter.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.models.Topics;

@Service
public class TopicService {
	private List<Topics> topics = new ArrayList<>(Arrays.asList(
		new Topics("spring", "Spring Boot Framework", "Spring Boot Framework Description"),
		new Topics("java", "Core Java", "Core Java Description"),
		new Topics("javascript", "JavaScript", "JavaScript Description")
	));
	
	public List<Topics> getAllTopics() 
	{
		return topics;
	}
	
	public Topics getTopic(String id) 
	{
		return topics.stream().filter(x -> x.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topics topic) {
		topics.add(topic);
	}

	public void updateTopic(Topics topic, String id) {
		Topics existingTopic = this.getTopic(id);
		if (existingTopic != null) {
			existingTopic.setName(topic.getName());
			existingTopic.setDescription(topic.getDescription());
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(x -> x.getId().equals(id));
	}
}