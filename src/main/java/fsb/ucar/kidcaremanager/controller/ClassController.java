package fsb.ucar.kidcaremanager.controller;


import fsb.ucar.kidcaremanager.dto.ClasseDto;
import fsb.ucar.kidcaremanager.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/class")
@AllArgsConstructor
public class ClassController {

    private final ClassService classService;
    @GetMapping
    public ResponseEntity<List<ClasseDto>> doFindAllClass(){
        return ResponseEntity.ok(classService.findAllClass());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasseDto> doFindClasById(@PathVariable Long id){
        return ResponseEntity.ok(classService.findClassById(id));
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> doAddClas(@RequestBody ClasseDto model){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        this.classService.addClass(model)
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> doUpdateClas(@PathVariable Long id, @RequestBody ClasseDto model){
        return ResponseEntity.ok(classService.updateClass(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> doDeleteClasById(@PathVariable Long id){
        return ResponseEntity.ok(classService.deleteClass(id));
    }


}
