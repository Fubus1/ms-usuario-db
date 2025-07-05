package cl.duoc.ms_usuario_db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration

public class SwaggerConfig {
    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI()
                   .info(new Info().title("API de usuario (ms-usuario-db)")
                                    .description(" Microservicio tipo DB ( Database ) es el componente responsable la gestión y persistencia de los datos relacionados con los usuarios del sistema."
                                    + "Este microservicio forma parte de la capa de backend y se encarga exclusivamente del acceso, almacenamiento y actualización de la información en la base de datos correspondiente.")
                                    .version("1.0.0"));
    }

}
