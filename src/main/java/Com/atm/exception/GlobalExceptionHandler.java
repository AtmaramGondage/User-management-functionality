package Com.atm.exception;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFoundException() {
        ApiError error = new ApiError(400,"User not found",new Date());
    	
        return new ResponseEntity<ApiError>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleUserAlreadyExistsException() {
        ApiError error = new ApiError(400,"User not found",new Date());
    	
        return new ResponseEntity<ApiError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

