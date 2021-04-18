package com.opc.aleksa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "kupac")
public class Kupac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @ManyToOne
    @JoinColumn(name = "grad_id")
    private Grad grad;

    @Column(name = "aktivan")
    private Boolean aktivan;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "kupac_id")
    private List<Kartica> kartice;

    public List<Grad> getDozvoljeniGradovi(){
        List<Grad> dozvoljeniGradovi = new ArrayList<>();
        kartice.stream()
                .forEach(kartica -> kartica.getDozvoljeniGradovi().stream()
                        .forEach(grad1 -> dozvoljeniGradovi.add(grad1)));
        return dozvoljeniGradovi.stream().distinct().collect(Collectors.toList());
    }

}
