package com.scaler.productservice.controllerAdvices;

import com.scaler.productservice.dtos.ArithmeticExceptionDto;
import com.scaler.productservice.dtos.ExceptionDto;
import com.scaler.productservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException(){
        ArithmeticExceptionDto arithmeticExceptionDto = new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("zero se diveide nahi karte Lodu");
        return new ResponseEntity<>(arithmeticExceptionDto, HttpStatus.OK);

    }

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException message){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(message.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);

    }



}
