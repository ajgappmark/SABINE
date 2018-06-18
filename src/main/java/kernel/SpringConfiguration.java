package kernel;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"bean", "bot", "dao", "kernel", "runnable", "supervisor"})
public class SpringConfiguration {
}
