package uz.bahodirsmind.paymentdemo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uz.bahodirsmind.paymentdemo.domain.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "select * from orders o left join details d where d.id is null and o.date < '2016-09-06'", nativeQuery = true)
    List<Order> findAllOrdersWithoutDetails();

    @Query(value = "select c.country, count(o.id) from customers c left join orders o on c.id = o.customer_id " +
            "where o.id is not null and o.date between '2016-01-01' and '2016-12-31' group by c.country ", nativeQuery = true)
    List<Object[]> findNumberOfOrders();

    @Query(value = "select o.id, sum(case when d.quantity is null then p.price else d.quantity * p.price end) from orders o " +
            "left join invoices i on o.id = i.order_id " +
            "left join details d on o.id = d.ord_id " +
            "left join products p on p.id = d.pr_id " +
            "where i.id is null and d.id is not null group by o.id", nativeQuery = true)
    List<Object[]> findAllOrdersWithoutInvoices();
}
