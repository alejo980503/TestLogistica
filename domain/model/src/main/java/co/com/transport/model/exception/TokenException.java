package co.com.transport.model.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TokenException extends RuntimeException {

    private final String statusCode;
    private final String technicalDetail;

    public TokenException(String statusCode, String message, String technicalDetail) {
        super( message );
        this.statusCode = statusCode;
        this.technicalDetail = technicalDetail;
    }
}
