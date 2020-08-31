package group.unimeb.market.config;

import group.unimeb.market.model.ResponseInfo;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SystemControllerAdvice {
    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<ResponseInfo> parameterError(MissingServletRequestParameterException e) {
        return new ResponseEntity<>(ResponseInfo.buildFailure(1006, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ResponseInfo> methodErrorHandler(HttpRequestMethodNotSupportedException e) {
        return new ResponseEntity<>(ResponseInfo.buildFailure(1004, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(value = DataAccessException.class)
    public ResponseEntity<ResponseInfo> databaseErrorHandler(DataAccessException e) {
        e.printStackTrace();
        return new ResponseEntity<>(ResponseInfo.buildFailure(1005, "Database error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity<ResponseInfo> authMethodErrorHandler(AuthenticationException e) {
        return new ResponseEntity<>(ResponseInfo.buildFailure(1004, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<String> accessDeniedHandler(AccessDeniedException e) {
        return new ResponseEntity<>("403 Forbidden", HttpStatus.FORBIDDEN);
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseInfo> errorHandler(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(ResponseInfo.buildFailure(1000, "Unknown error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(value = JwtException.class)
    public ResponseEntity<String> errorTokenHandler(JwtException e) {
        return new ResponseEntity<>("Token expired", HttpStatus.UNAUTHORIZED);
    }
}
