package com.user.exception;

import com.user.dto.ResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerMethods  {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDto> userNotFound(HttpServletRequest request){
        ResponseDto respose=new ResponseDto(404,"user not found!","error","user not registered yet",request.getRequestURI(), LocalDateTime.now());
        return ResponseEntity.ok().body(respose);
    }


}
