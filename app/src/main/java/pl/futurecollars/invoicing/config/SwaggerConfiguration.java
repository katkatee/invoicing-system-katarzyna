package pl.futurecollars.invoicing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("pl.futurecollars"))
          .paths(PathSelectors.any())
          .build()
          .tags(new Tag("invoice-controller", "Controler used to list/add/update/delete invoices."))
          .apiInfo(customApiInfo());
  }

  private ApiInfo customApiInfo() {
    return new ApiInfoBuilder()
          .title("Invoices System by FC")
          .description("Some description...")
          .contact(contactInfo())
          .version("v1")
          .build();
  }

  private Contact contactInfo() {
    return new Contact("Future Collars", "fc.com", "xxx@info.pl");
  }
}
