package pl.futurecollars.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEntry {

  @ApiModelProperty(value = "Product description", required = true)
  private String description;

  @ApiModelProperty(value = "Number of items", required = true)
  private int quantity;

  @ApiModelProperty(value = "Product net price", required = true)
  private BigDecimal price;

  @ApiModelProperty(value = "Product tax value", required = true)
  private BigDecimal vatValue;

  @ApiModelProperty(value = "Tax rate", required = true)
  private Vat vatRate;

}
