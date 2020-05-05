package com.vrishank.api.topic;

import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository is default generic repository
 * **/
public interface TopicRepository extends CrudRepository<Topic, String> { 

	
}
