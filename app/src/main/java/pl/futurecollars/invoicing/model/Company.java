package pl.futurecollars.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {

  @ApiModelProperty(value = "Nip", required = true, example = "555-555-55-55")
  private String taxIdentificationNumber;

  @ApiModelProperty(value = "Company address", required = true, example = "ul. Puławska 22, 02-200 Warszawa")
  private String address;

  @ApiModelProperty(value = "Company name", required = true, example = "Future Collars")
  private String name;

}
