package pl.futurecollars.invoicing;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import pl.futurecollars.invoicing.config.Config;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.db.file.FileBasedDatabase;
import pl.futurecollars.invoicing.db.file.IdService;
import pl.futurecollars.invoicing.model.Company;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.model.InvoiceEntry;
import pl.futurecollars.invoicing.model.Vat;
import pl.futurecollars.invoicing.service.InvoiceService;
import pl.futurecollars.invoicing.utils.FilesService;
import pl.futurecollars.invoicing.utils.JsonService;

public class App {

  public static void main(String[] args) {

    FilesService filesService = new FilesService();
    IdService idService = new IdService(Path.of(Config.ID_FILE_LOCATION), filesService);
    JsonService jsonService = new JsonService();
    Database db = new FileBasedDatabase(Path.of(Config.DATABASE_LOCATION), idService, filesService, jsonService);

    InvoiceService invoiceService = new InvoiceService(db);

    Company buyer = new Company("5213861303", "ul. Bukowińska 24d/7 02-703 Warszawa, Polska", "iCode Trust Sp. z o.o");
    Company seller = new Company("552-168-66-00", "32-005 Niepolomice, Nagietkowa 19", "Piotr Kolacz Development");

    List<InvoiceEntry> products =
        List.of(new InvoiceEntry("Programming course", 1, BigDecimal.valueOf(10000), BigDecimal.valueOf(2300), Vat.VAT_23));

    Invoice invoice = new Invoice(LocalDate.now(), buyer, seller, products);

    int id = invoiceService.save(invoice);

    invoiceService.getById(id).ifPresent(System.out::println);

    System.out.println(invoiceService.getAll());

    invoiceService.delete(id);

  }
}
