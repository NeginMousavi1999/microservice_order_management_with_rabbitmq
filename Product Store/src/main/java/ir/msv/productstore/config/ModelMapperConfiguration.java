package ir.msv.productstore.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Negin Mousavi 1/23/2025 - Thursday
 */
@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().
                setMatchingStrategy(MatchingStrategies.STRICT).
                setAmbiguityIgnored(true);
        return mapper;
    }
}
