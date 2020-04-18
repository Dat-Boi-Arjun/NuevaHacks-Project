package com.arjun.projects.boredomanalysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoredomAnalysisApplication implements CommandLineRunner {

  @Autowired
  private WebDataRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(BoredomAnalysisApplication.class, args);
  }

  @Override
  public void run(String... args){

      System.out.println("You are feeling bored"); //add support for this to be a notification


  }
}
