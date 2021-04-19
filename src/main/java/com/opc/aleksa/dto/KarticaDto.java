package com.opc.aleksa.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KarticaDto {
    private Long id;
    private Long broj_kartice;
    private List<GradDto> dozvoljeniGradovi;

    @Override
    public String toString() {
        return "Kartica{" +
                "id=" + id +
                ", broj_kartice=" + broj_kartice +
                ", dozvoljeniGradovi=" + dozvoljeniGradovi +
                '}';
    }
}
