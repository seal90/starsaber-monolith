package org.seal.starsaber.sealstarsaberinitializer.initializer.config;

import io.spring.initializr.metadata.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigInitializr {
    @Bean
    public InitializrMetadataProvider initializrMetadataProvider(InitializrProperties properties) {
        InitializrMetadata metadata = InitializrMetadataBuilder.fromInitializrProperties(properties).build();
        return new SimpleInitializrMetadataProvider(metadata);
    }
}
