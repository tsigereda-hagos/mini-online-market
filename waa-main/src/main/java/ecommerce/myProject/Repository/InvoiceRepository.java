package ecommerce.myProject.Repository;

import ecommerce.myProject.Domain.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
