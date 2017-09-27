package com.allianz.training.wire;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="com.allianz.prop",ignoreUnknownFields=true)
public class MyApplicationProperties {
    
    private String server;
    private String port;
    private String application;
    private List<String> dbips;
    private Map<String, String> mymap;
    
    public String getServer() {
        return server;
    }
    public void setServer(String server) {
        this.server = server;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getApplication() {
        return application;
    }
    public void setApplication(String application) {
        this.application = application;
    }
    public List<String> getDbips() {
        return dbips;
    }
    public void setDbips(List<String> dbips) {
        this.dbips = dbips;
    }
    public Map<String, String> getMymap() {
        return mymap;
    }
    public void setMymap(Map<String, String> mymap) {
        this.mymap = mymap;
    }
    
    
    
    
}
