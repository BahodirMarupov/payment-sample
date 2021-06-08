package uz.bahodirsmind.paymentdemo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NumberOfOrdersResponse {
    private String country;
    private Integer totalNumber;
}
