package fsb.ucar.kidcaremanager.service;


import fsb.ucar.kidcaremanager.dto.ClasseDto;
import fsb.ucar.kidcaremanager.dto.mapping.ClassGetMapping;
import fsb.ucar.kidcaremanager.dto.mapping.ClassPostMapping;
import fsb.ucar.kidcaremanager.entity.Class;
import fsb.ucar.kidcaremanager.exception.NotFoundException;
import fsb.ucar.kidcaremanager.repository.ClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClassService {

    private final ClassRepository classRepository;
    private final ClassGetMapping classGetMapping;
    private final ClassPostMapping classPostMapping;

    public List<ClasseDto> findAllClass(){
        return classRepository
                .findAll()
                .stream()
                .map(classGetMapping)
                .collect(Collectors.toList());
    }

    public ClasseDto findClassById(Long id){
        return classGetMapping
                .apply(
                        findById(id)
                );
    }


    public Map<String, String> addClass(ClasseDto model){
        classRepository.save(classPostMapping.apply(model));
        return Map.of("status","Class Add");
    }

    public Map<String, String> updateClass(Long id, ClasseDto model){
        Class clas = findById(id);
        if(model.nomClasse() != null)
            clas.setNomClasse(model.nomClasse());
        if(model.niveau() != null)
            clas.setNiveau(model.niveau());
        if(model.horaire() != null)
            clas.setHoraire(model.horaire());
        classRepository.save(clas);
        return Map.of("status","Class Update");
    }

    public Map<String, String> deleteClass(Long id){
        findById(id);
        classRepository.deleteById(id);
        return Map.of("status","Class delete");
    }

    private Class findById(Long id){
        return this.classRepository
                .findById(id)
                .orElseThrow(
                        ()-> new NotFoundException("Class Not Found")
                );
    }
}
