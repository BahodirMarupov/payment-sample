package uz.bahodirsmind.paymentdemo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BulkProductsResponse {
    private Long id;
    private BigDecimal price;
}
