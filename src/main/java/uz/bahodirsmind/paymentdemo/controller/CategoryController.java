package uz.bahodirsmind.paymentdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.bahodirsmind.paymentdemo.payload.ResponseData;
import uz.bahodirsmind.paymentdemo.payload.dto.CategoryDTO;
import uz.bahodirsmind.paymentdemo.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping
    public ResponseEntity<ResponseData<CategoryDTO>> getProductCategory(@RequestParam(name = "product_id") Long productId) {
        ResponseData<CategoryDTO> result = categoryService.findProductCategory(productId);
        return ResponseEntity.status(result.getCode()).body(result);
    }
}
