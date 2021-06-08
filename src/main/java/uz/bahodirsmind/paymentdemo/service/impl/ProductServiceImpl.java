package uz.bahodirsmind.paymentdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uz.bahodirsmind.paymentdemo.payload.response.BulkProductsResponse;
import uz.bahodirsmind.paymentdemo.payload.response.HighDemandProductsResponse;
import uz.bahodirsmind.paymentdemo.repository.ProductRepository;
import uz.bahodirsmind.paymentdemo.service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<HighDemandProductsResponse> getAllHighDemandProducts() {
        List<HighDemandProductsResponse> highDemandProducts = new ArrayList<>();
        try {
            List<Object[]> objects = productRepository.findAllHighDemandProducts();
            for (Object[] object : objects) {
                highDemandProducts.add(new HighDemandProductsResponse(
                        object[0] != null ? Long.parseLong(object[0].toString()) : null,
                        object[1] != null ? Integer.parseInt(object[1].toString()) : null
                ));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return highDemandProducts;
    }

    @Override
    public List<BulkProductsResponse> getAllBulkProducts() {
        List<BulkProductsResponse> bulkProducts = new ArrayList<>();
        try {
            List<Object[]> objects = productRepository.findAllBulkProducts();
            for (Object[] object : objects) {
                bulkProducts.add(new BulkProductsResponse(
                        object[0] != null ? Long.parseLong(object[0].toString()) : null,
                        object[1] != null ? new BigDecimal(object[1].toString()) : null
                ));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return bulkProducts;
    }
}
