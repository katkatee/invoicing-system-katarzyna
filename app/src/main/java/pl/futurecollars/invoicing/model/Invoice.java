package pl.futurecollars.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Invoice {

  @ApiModelProperty(value = "Invoice id")
  private int id;

  @ApiModelProperty(value = "Date invoice was created", required = true)
  private LocalDate date;

  @ApiModelProperty(value = "Company who bought the product", required = true)
  private Company buyer;

  @ApiModelProperty(value = "Company who is selling the product", required = true)
  private Company seller;

  @ApiModelProperty(value = "List of products", required = true)
  private List<InvoiceEntry> entries;

}
