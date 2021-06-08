package uz.bahodirsmind.paymentdemo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uz.bahodirsmind.paymentdemo.domain.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query(value = "select c.* from customers c left join " +
            "(select * from orders o where o.date between '2016-01-01' and '2016-12-31')  " +
            "as o1 on c.id = o1.customer_id", nativeQuery = true)
    List<Customer> findAllCustomersWithoutOrders();

    @Query(value = "select c.id,c.name, max(o.date) from customers c " +
            "left join orders o on c.id = o.customer_id " +
            "where o.id is not null group by c.id, c.name", nativeQuery = true)
    List<Object[]> findCustomersLastOrders();
}
