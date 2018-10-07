package org.seal.starsaber.arch.conf.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Configuration
@EnableConfigurationProperties(ObjectMapperProperties.class)
public class ObjectMapperConfig {

    @Autowired
    private ObjectMapperProperties objectMapperProperties;

    @Bean("filterTypeObjectMapper")
    public ObjectMapper filterTypeObjectMapper(){
        List<String> ignoreClass = objectMapperProperties.getIgnoreClass();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            if(ignoreClass.size()>0) {
                SimpleModule module = new SimpleModule();
                for(String str : ignoreClass) {
                    module.addSerializer(new ClassStdSerializer(Class.forName(str)));
                }
                objectMapper.registerModule(module);
            }
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).
                    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}


