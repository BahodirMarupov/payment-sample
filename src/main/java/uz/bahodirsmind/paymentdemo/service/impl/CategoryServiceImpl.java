package uz.bahodirsmind.paymentdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.bahodirsmind.paymentdemo.domain.Category;
import uz.bahodirsmind.paymentdemo.domain.Product;
import uz.bahodirsmind.paymentdemo.payload.ResponseData;
import uz.bahodirsmind.paymentdemo.payload.dto.CategoryDTO;
import uz.bahodirsmind.paymentdemo.repository.CategoryRepository;
import uz.bahodirsmind.paymentdemo.repository.ProductRepository;
import uz.bahodirsmind.paymentdemo.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<CategoryDTO> getAll() {
        final Iterable<Category> all = categoryRepository.findAll();
        List<CategoryDTO> categories = new ArrayList<>();
        all.forEach(category -> categories.add(category.mapToDTO()));
        return categories;
    }

    @Override
    public ResponseData<CategoryDTO> findProductCategory(Long productId) {
        try {
            final Optional<Product> product = productRepository.findById(productId);
            return product.map(value -> new ResponseData<>(true, HttpStatus.OK, value.getCategory().mapToDTO())).orElseGet(() -> new ResponseData<>(false, HttpStatus.BAD_REQUEST, "product not exist!"));
        } catch (Exception e) {
            logger.error("/category : " + e.getMessage());
            return new ResponseData<>(false, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
