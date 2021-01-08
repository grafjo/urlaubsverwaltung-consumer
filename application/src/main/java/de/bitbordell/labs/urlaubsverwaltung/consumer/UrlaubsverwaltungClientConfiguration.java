package de.bitbordell.labs.urlaubsverwaltung.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.bitbordell.labs.urlaubsverwaltung.client.api.DepartmentApiControllerApi;
import de.bitbordell.labs.urlaubsverwaltung.client.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
class UrlaubsverwaltungClientConfiguration {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public UrlaubsverwaltungClientConfiguration(WebClient webClient, ObjectMapper objectMapper) {
        this.webClient = webClient;
        this.objectMapper = objectMapper;
    }

    @Bean
    ApiClient apiClient() {
        return new ApiClient(webClient, objectMapper, objectMapper.getDateFormat());
    }

    @Bean
    DepartmentApiControllerApi departmentApiControllerApi() {
        return new DepartmentApiControllerApi(apiClient());
    }
}
