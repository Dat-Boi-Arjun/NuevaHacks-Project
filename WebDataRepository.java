package com.arjun.projects.boredomanalysis;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WebDataRepository extends MongoRepository<WebContent, String> {

  public List<WebContent> findByContentType(String contentType);
}
