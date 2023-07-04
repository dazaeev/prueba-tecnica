package mx.com.boot.springframework.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Nazario Dazaeev
 *
 */
@Configuration
@EnableSwagger2
@ConditionalOnWebApplication
public class SwaggerConfig {

        /**
         * @return Constructor de la interfaz primaria SWAGGER.
         */
        @Bean
        public Docket productApi() {
                return new Docket(DocumentationType.SWAGGER_2).select()
                                .apis(RequestHandlerSelectors.withClassAnnotation(ControllerDocumentation.class))
                                .build().apiInfo(metadata())
                                .globalOperationParameters(Collections.singletonList(new ParameterBuilder()
                                                .name("Authorization").modelRef(new ModelRef("string"))
                                                .parameterType("header").required(true).hidden(true).build()));
        }

        /**
         * @return Información general del API.
         */
        private static ApiInfo metadata() {
                Collection<VendorExtension> vendors = new ArrayList<>();
                vendors.add(new StringVendorExtension("Template", "Template company"));
                return new ApiInfo("MiddlewareAPI", "Middleware API para ... ", "1.0.0",
                                "URL de Terminos de servicio",
                                new Contact("Template", "https://sites.google.com/site/framecodegenjavagenerator", ""),
                                "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", vendors);
        }

}
