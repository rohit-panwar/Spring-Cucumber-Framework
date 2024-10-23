package com.qa.automation.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class Generics {

    ObjectMapper mapper= new ObjectMapper();

    public JsonNode getJsonNodeObject(String jsonString){
        JsonNode jsonObj= null;
        try {
            jsonObj = mapper.readTree(jsonString.replaceAll("\\\\", ""));
        } catch (Exception e){
            e.printStackTrace();
        }
        return jsonObj;
    }

    public ObjectMapper getMapper(){
        mapper.findAndRegisterModules();
        //mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        //mapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        return mapper;
    }
}
