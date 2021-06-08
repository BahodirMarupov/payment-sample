package uz.bahodirsmind.paymentdemo.service;

import uz.bahodirsmind.paymentdemo.payload.ResponseData;
import uz.bahodirsmind.paymentdemo.payload.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAll();

    ResponseData<CategoryDTO> findProductCategory(Long productId);
}
