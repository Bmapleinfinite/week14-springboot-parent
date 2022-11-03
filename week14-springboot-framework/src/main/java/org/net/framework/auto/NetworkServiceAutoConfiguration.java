package org.net.framework.auto;

import org.net.framework.core.NetworkService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({NetworkService.class})
@EnableConfigurationProperties(NetworkProperties.class)
public class NetworkServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(NetworkService.class)
    public NetworkService networkService(NetworkProperties networkProperties){
        return new NetworkService(networkProperties.getHost(), networkProperties.getPort());
    }
}
