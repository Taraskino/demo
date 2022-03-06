package pl.edu.wszib.demo;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/calculator")
@RestController
public class CalculatorController {

    @PostMapping("/dodaj")
    public Integer dodawanie(@RequestHeader Integer liczba1,
                             @RequestHeader Integer liczba2){
        return liczba1 + liczba2;
    }
    @PostMapping("/odejmij")
    public Integer odejmowanie(@RequestBody Integer[] liczby){
        Integer pierwsza = liczby[0];
        for (int i = 1; i < liczby.length ; ++i) {
            pierwsza -= liczby[i];
        }
        return pierwsza;
    }
    public static class Operacja{
        private int liczba1;
        private int liczba2;

        public int getLiczba1() {
            return liczba1;
        }

        public void setLiczba1(int liczba1) {
            this.liczba1 = liczba1;
        }

        public int getLiczba2() {
            return liczba2;
        }

        public void setLiczba2(int liczba2) {
            this.liczba2 = liczba2;
        }
    }

    @PostMapping("/pomnoz")
    public Integer mnozymy(@RequestBody Operacja operacja){
        return operacja.liczba1 * operacja.liczba2;
    }

    @PostMapping("/podziel")
       public Integer dzielimy(@RequestHeader Integer liczba1,
                            @RequestHeader Integer liczba2){
        return liczba1 / liczba2;
    }
    @ExceptionHandler
    public String obsugaBlędu(ArithmeticException e){
        return "Nie wolno dzielic na 0";
    }
    @PostMapping("/potęga")
    public Integer podnosimyDoPotęgi(@RequestHeader Integer liczba1,
                                     @RequestHeader Integer liczba2){
        return (int)Math.pow(liczba1, liczba2);
    }
}

