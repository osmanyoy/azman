package com.allianz.training.wire;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:myproperties.properties")
public class ExecuteConfig {
    
    @Autowired
    private MyApplicationProperties myAppProp;
    
    @Value("${test.my.str}")
    private String str;
    
    @Autowired
    public void testMethodWire(@Value("${test.my.mtr}") String str) {
        System.out.println(str);
        System.out.println(this.str);
        System.out.println(myAppProp.getDbips());
        
    }

    @Bean(name = { "test1", "test2" })
    @Lazy
    @Qualifier("configExecute")
    public IExecute createExecute(InjectionPoint injectionPoint) {
        Class<?> declaringClass = injectionPoint.getMember()
                                                .getDeclaringClass();
        System.out.println(declaringClass);
        return new ExecuteV4();

    }

    @Bean
    @Qualifier("configExecute2")
    public IExecute createExecute2(@Value("${my.execute.version}") int version) {
        switch (version) {
        case 1:
            return new ExecuteV1();
        case 2:
            return new ExecuteV2();
        case 3:
            return new ExecuteV3();
        case 4:
            return new ExecuteV4();

        default:
            return new ExecuteV4();
        }

    }

    @Bean
    @Qualifier("configExecute3")
    public IExecute createExecute3(@Value("#{executerChooser.interfaceVersion()}") int version) {
        switch (version) {
        case 1:
            return new ExecuteV1();
        case 2:
            return new ExecuteV2();
        case 3:
            return new ExecuteV3();
        case 4:
            return new ExecuteV4();

        default:
            return new ExecuteV4();
        }

    }

}
