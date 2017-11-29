package ru.cbr.config;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.cbr.dto.*;
import ru.cbr.model.BNKSEEK;

import java.util.Objects;

@Configuration
@ComponentScan("ru.cbr.service")
@PropertySource(value = {"classpath:application.properties"}, ignoreResourceNotFound = true)
public class ConfigService {
    @Bean
    public MapperFacade mapperFacade() {
        MapperFacade mapperFacade = new ConfigurableMapper() {
            protected ConfigurableMapper getThis() {
                return this;
            }

            @Override
            protected void configure(MapperFactory factory) {

                factory.classMap(BNKSEEK.class, BnkseekDto.class)
                        .exclude("real")
                        .exclude("pzn")
                        .exclude("uer")
                        .exclude("rgn")
                        .exclude("tnp")
                        .customize(new CustomMapper<BNKSEEK, BnkseekDto>() {
                            @Override
                            public void mapAtoB(BNKSEEK entity, BnkseekDto dto, MappingContext context) {
                                if (Objects.nonNull(entity.getReal())) {
                                    dto.setReal(
                                            new RealDto(
                                                    entity.getReal().getId(),
                                                    entity.getReal().getReal()
                                            )
                                    );
                                }
                                if (Objects.nonNull(entity.getPzn())) {
                                    dto.setPzn(
                                            new PznDto(
                                                    entity.getPzn().getId(),
                                                    entity.getPzn().getName()
                                            ));
                                }
                                if (Objects.nonNull(entity.getUer())) {
                                    dto.setUer(
                                            new UerDto(
                                                    entity.getUer().getId(),
                                                    entity.getUer().getUerName())
                                    );
                                }
                                if (Objects.nonNull(entity.getRgn())) {
                                    dto.setRgn(
                                            new RgnDto(
                                                    entity.getRgn().getId(),
                                                    entity.getRgn().getName())
                                    );
                                }
                                if (Objects.nonNull(entity.getTnp())) {
                                    dto.setTnp(
                                            new TnpDto(
                                                    entity.getTnp().getId(),
                                                    entity.getTnp().getFullName())
                                    );
                                }
                            }
                        })
                        .byDefault()
                        .register();
            }
        };
        return mapperFacade;
    }
}
