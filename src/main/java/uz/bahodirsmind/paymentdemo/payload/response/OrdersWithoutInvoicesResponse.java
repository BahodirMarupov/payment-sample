package uz.bahodirsmind.paymentdemo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersWithoutInvoicesResponse {
    private Long id;
    private Data data;
    private BigDecimal sum;
}
