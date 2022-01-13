package edu.tpu.khromachu.sushibackend.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 @Api: украсить весь класс и описать роль контроллера
 @ApiOperation: описать метод класса или интерфейс
 @ApiParam: описание одного параметра
 @ApiModel: использовать объекты для получения параметров
 @ApiProperty: при получении параметров с объектом, опишите поле объекта
 @ApiResponse: 1 описание ответа HTTP
 @ApiResponses: общее описание ответа HTTP.
 @ApiIgnore: используйте эту аннотацию, чтобы игнорировать этот API
 @ApiError: информация, возвращаемая при возникновении ошибки
 @ApiImplicitParam: параметр запроса
 @ApiImplicitParams: несколько параметров запроса
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis (RequestHandlerSelectors.basePackage ("edu.tpu.khromachu.sushibackend.controllers")) // Пакет сканирования Swagger
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Sushi-server")
                .description("Swagger build")
                .version("1.0")
                .build();
    }
}
