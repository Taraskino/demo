package pl.edu.wszib.demo;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ToDo")
@RestController
public class MójCrud {
    public enum Status {
        NEW,
        IN_PROGRESS,
        DONE
    }
    public static class ToDo {
        public Integer id;
        public String nazwa;
        @NotNull
        public Status status;

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

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
    }
       public Integer idCounter = 1;
        public Map<Integer, ToDo> kontener = new HashMap<>();

    @PostMapping
    public MójCrud.ToDo create(@RequestBody MójCrud.ToDo toDo){
        toDo.id = idCounter++;
        kontener.put(toDo.id, toDo);
        return toDo;
    }
    @GetMapping
    public List<ToDo> list(@RequestParam(required = false) MójCrud.Status status ){
        if (status == null){
            return new ArrayList<>(kontener.values());
        }
        List<ToDo> pasują = new ArrayList<>();
        for (ToDo toDo : kontener.values()){
            if (toDo.getStatus() == status){
                pasują.add(toDo);
            }
        }
        return pasują;
    }
    @GetMapping("/{id}")
    public MójCrud.ToDo  get(@PathVariable Integer id){
        return kontener.get(id);
    }
    @PutMapping
    public MójCrud.ToDo  update(@RequestBody MójCrud.ToDo  toDo){
        if (kontener.containsKey(toDo.id)){
            kontener.put(toDo.id, toDo);
            return toDo;
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        kontener.remove(id);
    }
}




