package com.allianz.training.wire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ExecuterChooser {

    // @Value("${my.execute.version}")
    // private int version;

    @Autowired
    private Environment environment;

    public int interfaceVersion() {
        String property = environment.getProperty("my.execute.version");
        if (property == null || property.isEmpty()) {
            // DB git
            return 1;
        }
        return Integer.parseInt(property);
    }

}
