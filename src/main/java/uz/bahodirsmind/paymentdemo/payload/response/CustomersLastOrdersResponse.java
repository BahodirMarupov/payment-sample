package uz.bahodirsmind.paymentdemo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomersLastOrdersResponse {
    private Long id;
    private String name;
    private Date date;
}
