package uz.bahodirsmind.paymentdemo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> {
    private boolean success;
    private HttpStatus code;
    private String message;
    private T data;

    public ResponseData(boolean success, HttpStatus code, T data) {
        this.success = success;
        this.code = code;
        this.data = data;
    }

    public ResponseData(boolean success, HttpStatus code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
