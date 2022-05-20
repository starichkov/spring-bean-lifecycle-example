package org.starichkov.java.examples.spring;

import java.util.concurrent.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Vadim Starichkov
 * @since 11.08.2019 13:18
 */
@Component
@Slf4j
public class SampleBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
    InitializingBean, BeanPostProcessor, DisposableBean {

  private final String sampleProperty1;
  private String sampleProperty2;

  /**
   * Step 1. Bean instantiating
   */
  public SampleBean(@Value("${custom.properties.property1}") String sampleProperty1) {
    this.sampleProperty1 = sampleProperty1;
    log.info("Step 1. Instantiating bean with property: {}", sampleProperty1);
    pause();
  }

  /**
   * Step 2. Injecting values and bean references into the bean’s properties
   */
  @Value("${custom.properties.property2}")
  public void setSampleProperty2(String sampleProperty2) {
    log.info("Step 2. Setting properties: {}", sampleProperty2);
    this.sampleProperty2 = sampleProperty2;
    pause();
  }

  /**
   * Step 3. {@link BeanNameAware} implemented, Spring passes the bean’s ID to the setBeanName()
   * method
   */
  @Override
  public void setBeanName(String beanName) {
    log.info("Step 3. BeanNameAware.setBeanName: {}", beanName);
    pause();
  }

  /**
   * Step 4. {@link BeanFactoryAware} implemented, Spring calls the setBeanFactory() method, passing
   * in the bean factory itself
   */
  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    log.info("Step 4. BeanFactoryAware.setBeanFactory: {}", beanFactory.toString());
    pause();
  }

  /**
   * Step 5. {@link ApplicationContextAware}, Spring calls the setApplicationContext() method,
   * passing in a reference to the enclosing application context
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    log.info("Step 5. ApplicationContextAware.setApplicationContext: {}",
        applicationContext.getDisplayName());
    pause();
  }

  /**
   * Step 6. {@link PostConstruct} annotated method, Spring calls this custom initialization method
   */
  @PostConstruct
  public void init() {
    log.info("Step 6. @PostConstruct - init()");
    pause();
  }

  /**
   * Step 7. {@link InitializingBean} implemented, Spring calls afterPropertiesSet()
   */
  @Override
  public void afterPropertiesSet() {
    log.info("Step 7. InitializingBean.afterPropertiesSet()");
    pause();
  }

  /**
   * Step 8. {@link BeanPostProcessor} implemented, Spring calls postProcessBeforeInitialization()
   */
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    log.info("Step 8. BeanPostProcessor.postProcessBeforeInitialization: {}, {}", bean, beanName);
    pause();
    return bean;
  }

  /**
   * Step 9. {@link BeanPostProcessor} implemented, Spring calls postProcessAfterInitialization()
   */
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    log.info("Step 9. BeanPostProcessor.postProcessAfterInitialization: {}, {}", bean, beanName);
    pause();
    return bean;
  }

  /**
   * Step 10. {@link PreDestroy} annotated method, Spring calls this custom pre-destroy method
   */
  @PreDestroy
  public void preDestroy() {
    log.info("Step 10. @PreDestroy - preDestroy()");
    pause();
  }

  /**
   * Step 11. {@link DisposableBean} implemented, Spring calls destroy() method
   */
  @Override
  public void destroy() {
    log.info("Step 11. DisposableBean.destroy()");
    pause();
  }

  private void pause() {
    try {
      TimeUnit.MILLISECONDS.sleep(50);
    } catch (InterruptedException e) {
      log.error(e.getMessage(), e);
    }
  }
}
