package pl.edu.wszib.demo;
//Create
//Read
//Update
//Delete

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/zasób")
@RestController
public class CrudController {
    public static class Zasób{
        private Integer id;
        public Integer getId() {
            return id;}
        public void setId(Integer id) {
            this.id = id;}
    }
    private Integer idCounter = 1;
    private Map<Integer, Zasób> kontener = new HashMap<>();

    @PostMapping
    public Zasób create(@RequestBody Zasób zasób){
        zasób.id = idCounter++;
        kontener.put(zasób.id, zasób);
        return zasób;
    }
    @GetMapping
    public Zasób[] list(){
        return kontener.values().toArray(new Zasób[0]);
    }
    @GetMapping("/{id}")
    public Zasób get(@PathVariable Integer id){
        return kontener.get(id);
    }
    @PutMapping
    public Zasób update(@RequestBody Zasób zasób){
        if (kontener.containsKey(zasób.id)){
            kontener.put(zasób.id, zasób);
            return zasób;
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        kontener.remove(id);
    }
}
