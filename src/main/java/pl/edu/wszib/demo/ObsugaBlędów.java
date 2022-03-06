package pl.edu.wszib.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ObsugaBlędów {
   @ExceptionHandler
    public ResponseEntity handle (Exception e){
       return ResponseEntity.status(483).body("Korzystam z body");
 }
    @ExceptionHandler
    public String handle(ArithmeticException e){
        return "Nie dziel przez zero";
    }
}
