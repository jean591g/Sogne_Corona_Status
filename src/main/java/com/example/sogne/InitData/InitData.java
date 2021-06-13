package com.example.sogne.InitData;

import com.example.sogne.model.Kommune;
import com.example.sogne.model.Sogn;
import com.example.sogne.repository.KommuneRepository;
import com.example.sogne.repository.SogneRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class InitData
{
    private final KommuneRepository kommuneRepository;
    private final SogneRepository sogneRepository;

    @Bean
    public void InitializeDataForDatabase()
    {
        var kommune1 = kommuneRepository.save(new Kommune("København"));
        var kommune2 = kommuneRepository.save(new Kommune("Århus"));
        var kommune3 = kommuneRepository.save(new Kommune("Odense"));
        var kommune4 = kommuneRepository.save(new Kommune("Aalborg"));
        var kommune5 = kommuneRepository.save(new Kommune("Esbjerg"));
        var kommune6 = kommuneRepository.save(new Kommune("Randers"));
        var kommune7 = kommuneRepository.save(new Kommune("Kolding"));
        var kommune8 = kommuneRepository.save(new Kommune("Horsens"));
        var kommune9 = kommuneRepository.save(new Kommune("Vejle"));
        var kommune10 = kommuneRepository.save(new Kommune("Roskilde"));
        var kommune11 = kommuneRepository.save(new Kommune("Herning"));


        var sogn1 = new Sogn(1,"Test Sogn 1",50.5, LocalDate.now().minusDays(3));
        sogn1.setKommune(kommune1);
        sogneRepository.save(sogn1);

        var sogn2 = new Sogn(2, "Test Sogn 2",42.3, LocalDate.now().plusDays(3));
        sogn2.setKommune(kommune2);
        sogneRepository.save(sogn2);

        var sogn3 = new Sogn(3, "Test Sogn 3",22.8, LocalDate.now().plusDays(6));
        sogn3.setKommune(kommune3);
        sogneRepository.save(sogn3);

        var sogn4 = new Sogn(4, "Test Sogn 4",120.2, LocalDate.now().plusDays(5));
        sogn4.setKommune(kommune4);
        sogneRepository.save(sogn4);

        var sogn5 = new Sogn(5, "Test Sogn 5",12.5, LocalDate.now().minusDays(1));
        sogn5.setKommune(kommune5);
        sogneRepository.save(sogn5);

        var sogn6 = new Sogn(6, "Test Sogn 6",37.5, LocalDate.now().minusDays(2));
        sogn6.setKommune(kommune6);
        sogneRepository.save(sogn6);

        var sogn7 = new Sogn(7, "Test Sogn 7",18.5, LocalDate.now().plusDays(4));
        sogn7.setKommune(kommune7);
        sogneRepository.save(sogn7);

        var sogn8 = new Sogn(8, "Test Sogn 8",8.5, LocalDate.now().minusDays(2));
        sogn8.setKommune(kommune8);
        sogneRepository.save(sogn8);

        var sogn9 = new Sogn(9, "Test Sogn 9",220.5, LocalDate.now().plusDays(6));
        sogn9.setKommune(kommune9);
        sogneRepository.save(sogn9);

        var sogn10 = new Sogn(10, "Test Sogn 10",35.5, LocalDate.now().minusDays(1));
        sogn10.setKommune(kommune10);
        sogneRepository.save(sogn10);

        var sogn11 = new Sogn(11, "Test Sogn 11",2.5, LocalDate.now().plusDays(1));
        sogn11.setKommune(kommune11);
        sogneRepository.save(sogn11);
    }
}
