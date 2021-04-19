package com.opc.aleksa.dto;

import com.opc.aleksa.model.Grad;
import lombok.*;

import java.util.Objects;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradDto {

    private Long id;
    private String naziv;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grad)) return false;
        GradDto grad = (GradDto) o;
        return id.equals(grad.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
