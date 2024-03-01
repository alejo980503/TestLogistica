package co.com.transport.apirest.exception;

import co.com.transport.model.error.ErrorResponse;
import co.com.transport.model.exception.TokenException;
import co.com.transport.model.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ApplicationException {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException validationException) {

        return getResponseEntity(
                ErrorResponse.builder()
                        .statusCode(validationException.getStatusCode())
                        .message(validationException.getMessage())
                        .technicalDetail(validationException.getTechnicalDetail())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TokenException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorResponse> handleTokenException(TokenException tokenException) {

        return getResponseEntity(
                ErrorResponse.builder()
                        .statusCode(tokenException.getStatusCode())
                        .message(tokenException.getMessage())
                        .technicalDetail(tokenException.getTechnicalDetail())
                        .build(), HttpStatus.UNAUTHORIZED);
    }

    private ResponseEntity<ErrorResponse> getResponseEntity(ErrorResponse errorResponse, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }


}
