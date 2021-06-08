package uz.bahodirsmind.paymentdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bahodirsmind.paymentdemo.payload.response.BulkProductsResponse;
import uz.bahodirsmind.paymentdemo.payload.response.HighDemandProductsResponse;
import uz.bahodirsmind.paymentdemo.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // N: 7
    @GetMapping("/high_demand_products")
    public List<HighDemandProductsResponse> getAllHighDemandProducts() {
        return productService.getAllHighDemandProducts();
    }

    // N:8
    @GetMapping("/bulk_products")
    public List<BulkProductsResponse> getAllBulkProducts(){
        return productService.getAllBulkProducts();
    }
}
