package org.letuslearn.cabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.letuslearn")
public class CabApplication {
  public static void main(String[] args) {
    SpringApplication.run(CabApplication.class, args);
  }
}
