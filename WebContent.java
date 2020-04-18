package com.arjun.projects.boredomanalysis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebContent {

  @Id
  private String id;

  private String contentType;
  private String body;


  public WebContent(String contentType, String body){
    this.body = body;
    this.contentType = contentType;
  }

  public String getBody(){
    return body;
  }

}
