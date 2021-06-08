package uz.bahodirsmind.paymentdemo.payload.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomError {
    private String field;
    private String reason;
}
