package pl.edu.wszib.demo;

import org.springframework.web.bind.annotation.*;
@RequestMapping("helloworld")
@RestController
public class HelloWorldController {

    // /katalog/2022/03/05


    @GetMapping("/get/{asdf}/prefix/{super}")
    public String helloWorld(@PathVariable("asdf") String param,
                             @PathVariable ("super") String param2){
        return "Hello World " + param + param2;
    }
    @GetMapping("/upper/{tekst}")
    public String helloWorld(@PathVariable("tekst") String param3){
        return "Hello World " + param3;
    }
    @PostMapping("/{param5}")
    public String wypisz(@RequestParam(value = "test", required = false) String[] param4,
                         @RequestParam String[] param5){
        String out = "";
        for(String t  : param4){
            out += t;
        }
        return out;
    }
    public static class ObiektDoWyslania{
        private int numer;
        private String tekst;
        private float zmiennoprzecinkowa;
        @Override
        public String toString() {
            return "ObiektDoWyslania{" +
                    "numer=" + numer +
                    ", tekst='" + tekst + '\'' +
                    ", zmiennoprzecinkowa=" + zmiennoprzecinkowa +
                    '}';
        }
        public void setNumer(int numer) {
            this.numer = numer;
        }
        public String getTekst() {
            return tekst;
        }

        public void setTekst(String tekst) {
            this.tekst = tekst;
        }
        public float getZmiennoprzecinkowa() {
            return zmiennoprzecinkowa;
        }
        public void setZmiennoprzecinkowa(float zmiennoprzecinkowa) {
            this.zmiennoprzecinkowa = zmiennoprzecinkowa;
        }
    }
    @PostMapping("/obiekt")
    public String dodajObiekt(@RequestParam ObiektDoWyslania obiekt){
        return obiekt.numer + obiekt.tekst + obiekt.zmiennoprzecinkowa;
    }
    @PatchMapping("/")
    public String patchujemy(@RequestBody ObiektDoWyslania  param){
        return "Hello World PATCH " + param;
    }
    @PutMapping("/")
    public String putujemy(@RequestHeader("TestHeader") String param){
        return "Hello World PUT " + param;
    }
    @DeleteMapping ("/")
    public String usuwamy(){
        return "Hello World DELETE";
    }
       @ExceptionHandler
    public String obsluz(Exception e){
        return "Ups, coś nie działa";
    }
}
