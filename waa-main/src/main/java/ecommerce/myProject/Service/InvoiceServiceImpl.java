package ecommerce.myProject.Service;

import ecommerce.myProject.Domain.Invoice;
import ecommerce.myProject.Domain.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    @Override
    public Invoice generateInvoice(List<Order> orders) {
        return null;
    }
}
