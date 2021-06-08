package uz.bahodirsmind.paymentdemo.repository;

import org.springframework.data.repository.CrudRepository;
import uz.bahodirsmind.paymentdemo.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
