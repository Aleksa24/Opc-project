package com.opc.aleksa.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kartica")
public class Kartica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "broj_kartice")
    private Long broj_kartice;

//    @ManyToOne
//    @JoinColumn(name = "kupac_id")
//    private Kupac kupac;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "karticadozvoljengrad",
            joinColumns = @JoinColumn(name = "kartica_id"),
            inverseJoinColumns = @JoinColumn(name = "grad_id")
    )
    private List<Grad> dozvoljeniGradovi;

    @Override
    public String toString() {
        return "Kartica{" +
                "id=" + id +
                ", broj_kartice=" + broj_kartice +
                ", dozvoljeniGradovi=" + dozvoljeniGradovi +
                '}';
    }
}
