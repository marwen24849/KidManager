package fsb.ucar.kidcaremanager.dto.mapping;

import fsb.ucar.kidcaremanager.dto.ClasseDto;
import fsb.ucar.kidcaremanager.entity.Class;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClassPostMapping implements Function<ClasseDto, Class> {



    @Override
    public Class apply(ClasseDto classeDto) {
        Class classe = Class
                .builder()
                .nomClasse(classeDto.nomClasse())
                .niveau(classeDto.niveau())
                .horaire(classeDto.horaire())
                .build();
        return classe;
    }
}
