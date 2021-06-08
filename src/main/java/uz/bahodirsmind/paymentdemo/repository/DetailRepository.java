package uz.bahodirsmind.paymentdemo.repository;

import org.springframework.data.repository.CrudRepository;
import uz.bahodirsmind.paymentdemo.domain.Detail;

public interface DetailRepository extends CrudRepository<Detail, Long> {

}
