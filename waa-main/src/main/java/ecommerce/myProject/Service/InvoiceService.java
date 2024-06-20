package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Invoice;
import ecommerce.myProject.Domain.Order;

import java.util.List;


public interface InvoiceService {

    Invoice generateInvoice(List<Order> orders);
}
