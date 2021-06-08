package uz.bahodirsmind.paymentdemo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uz.bahodirsmind.paymentdemo.domain.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "select p.id, sum(case when d.quantity is null then 1 else d.quantity end) from products p " +
            "left join details d on p.id = d.pr_id where d.id is not null " +
            "group by p.id having sum(case when d.quantity is null then 1 else d.quantity end) > 10", nativeQuery = true)
    List<Object[]> findAllHighDemandProducts();

    @Query(value = "select p.id, p.price from products p left join details d on p.id = d.pr_id \n" +
            "where d.id is not null group by p.id, p.price \n" +
            "having count(d.id) = count(d.id) filter (where d.quantity > 8)", nativeQuery = true)
    List<Object[]> findAllBulkProducts();
}
