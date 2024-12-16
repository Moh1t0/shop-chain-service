package org.javaacademy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customApi() {
        Info description = new Info().title("API для сети продуктовых магазинов 'Семерочка' & 'Девяточка' ")
                .contact(new Contact().email("molodykoproducts@mail.ru").name("MolodykoProducts"))
                .description("По всем вопросам обращайтесь на почту: ");
        return new OpenAPI().info(description);
    }

}
