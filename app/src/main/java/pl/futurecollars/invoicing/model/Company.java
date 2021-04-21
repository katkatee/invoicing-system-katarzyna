package pl.futurecollars.invoicing.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

  private String taxIdentificationNumber;
  private String address;
  private String name;
  
}
