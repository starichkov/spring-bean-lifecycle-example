Spring Bean Lifecycle sample application
=
This sample application show all steps of Spring bean's lifecycle.

Whole example was inspired by the book of Craig Walls - Spring in Action 4th edition (ISBN 9781617291203).

### Multiple errors found ?

Probably I have found multiple errors in this book. In chapter "1.2.2 A Bean's life" author writes:

> `6.` If the bean implements the BeanPostProcessor interface, Spring calls its postProcessBeforeInitialization() method.

> `7.` If the bean implements the InitializingBean interface, Spring calls its afterPropertiesSet() method.
Similarly, if the bean was declared with an init method, then the specified initialization method is called.

> `8.` If the bean implements BeanPostProcessor, Spring calls its postProcessAfterInitialization() method.

On deal, Spring calls these methods in a following order:

1. Custom init method
1. `afterPropertiesSet()`
1. Both `postProcessBeforeInitialization()` and `postProcessAfterInitialization()` for each bean

Run this example to see it yourself in the output log.

### Technical details

| Language/Library/Framework | Version |
|----------------------------|---------|
| Java                       | 11      |
| Spring                     | 5.3.x   |
| Spring Boot                | 2.5.x   |
