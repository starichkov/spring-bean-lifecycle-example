package org.starichkov.java.examples.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Vadim Starichkov
 * @since 11.08.2019 15:12
 */
@Slf4j
public class SpringBeansLifecycleApplication {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        "org.starichkov.java.examples.spring");

    log.info("Do some really cool stuff...");

    context.destroy();
  }
}
