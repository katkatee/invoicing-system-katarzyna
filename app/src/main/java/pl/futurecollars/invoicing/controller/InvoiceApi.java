package pl.futurecollars.invoicing.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.futurecollars.invoicing.model.Invoice;

@RequestMapping(value = "invoices", produces = {"application/json;charset=UTF-8"})
@Api(value = "Invoice Controller", tags = "invoices")
public interface InvoiceApi {

  @GetMapping()
  @ApiOperation(value = "Get all invoices", notes = "Get all invoices fron the database.")
  List<Invoice> getAll();

  @PostMapping
  @ApiOperation(value = "Add an invoice")
  int add(@RequestBody Invoice invoice);

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "Get invoice bby id")
  ResponseEntity<Invoice> getById(@PathVariable int id);

  @DeleteMapping("/{id}")
  @ApiOperation(value = "Delete invoice by id")
  ResponseEntity<?> deleteById(@PathVariable int id);

  @PutMapping("/{id}")
  @ApiOperation(value = "Update an invoice")
  ResponseEntity<?> update(@PathVariable int id, @RequestBody Invoice invoice);
}
