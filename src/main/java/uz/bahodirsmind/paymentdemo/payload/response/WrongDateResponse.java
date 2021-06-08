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
public class WrongDateResponse {
    private Long id;
    private Date issued;
    private Long orderId;
    private Date date;
}
