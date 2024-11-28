package fsb.ucar.kidcaremanager.dto.mapping;

import fsb.ucar.kidcaremanager.dto.ClasseDto;
import fsb.ucar.kidcaremanager.entity.Class;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClassGetMapping implements Function<Class, ClasseDto> {
    @Override
    public ClasseDto apply(Class clas) {
        return new ClasseDto(
                clas.getNomClasse(),
                clas.getNiveau(),
                clas.getHoraire()
        );
    }
}
