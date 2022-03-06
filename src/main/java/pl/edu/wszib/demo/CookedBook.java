package pl.edu.wszib.demo;

import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
@RequestMapping("/Cooked")
@RestController
public class CookedBook {
    private Integer id;
    private String nazwa;
    private String[] składniki;
    private int czasPrzygotowania;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public String[] getSkładniki() {
        return składniki;
    }
    public void setSkładniki(String[] składniki) {
        this.składniki = składniki;
    }
    public int getCzasPrzygotowania() {
        return czasPrzygotowania;
    }
    public void setCzasPrzygotowania(int czasPrzygotowania) {
        this.czasPrzygotowania = czasPrzygotowania;
    }
    private Integer idCounter = 1;
    private Map<Integer, CookedBook> kontener = new HashMap<>();

    @PostMapping
    public CookedBook create(@RequestBody CookedBook cookedBook){
        cookedBook.id = idCounter++;
        kontener.put(cookedBook.id, cookedBook);
        return cookedBook;
    }

    @GetMapping
    public CookedBook[] list(){
        return kontener.values().toArray(new CookedBook[0]);
    }
    @GetMapping("/{id}")
    public CookedBook get(@PathVariable Integer id){
        return kontener.get(id);
    }
    @PutMapping
    public CookedBook update(@RequestBody CookedBook cookedBook){
        if (kontener.containsKey(cookedBook.id)){
            kontener.put(cookedBook.id, cookedBook);
            return cookedBook;
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        kontener.remove(id);
    }
}

