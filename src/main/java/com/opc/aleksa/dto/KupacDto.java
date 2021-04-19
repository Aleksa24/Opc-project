package com.opc.aleksa.dto;

import com.opc.aleksa.model.Grad;
import com.opc.aleksa.model.Kartica;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class KupacDto {
    private Long id;
    private String naziv;
    private GradDto grad;
    private Boolean aktivan;
    private List<KarticaDto> kartice;

    public List<GradDto> getDozvoljeniGradovi(){
        List<GradDto> dozvoljeniGradovi = new ArrayList<>();
        kartice.stream()
                .forEach(kartica -> kartica.getDozvoljeniGradovi().stream()
                        .forEach(grad1 -> dozvoljeniGradovi.add(grad1)));
        return dozvoljeniGradovi.stream().distinct().collect(Collectors.toList());
    }
}
