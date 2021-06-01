package pl.futurecollars.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  public Invoice(LocalDate date, Company buyer, Company seller, List<InvoiceEntry> entries) {
    this.date = date;
    this.buyer = buyer;
    this.seller = seller;
    this.entries = entries;
  }

}
