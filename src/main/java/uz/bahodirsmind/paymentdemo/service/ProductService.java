package uz.bahodirsmind.paymentdemo.service;

import uz.bahodirsmind.paymentdemo.payload.response.BulkProductsResponse;
import uz.bahodirsmind.paymentdemo.payload.response.HighDemandProductsResponse;

import java.util.List;

public interface ProductService {
    List<HighDemandProductsResponse> getAllHighDemandProducts();

    List<BulkProductsResponse> getAllBulkProducts();
}
