package com.opc.aleksa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grad")
public class Grad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grad)) return false;
        Grad grad = (Grad) o;
        return id.equals(grad.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
