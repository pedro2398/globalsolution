package globalsolution.globalsolution.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaParcial {
    private Long id;
    private Integer quantidade;
    private Timestamp horario;
    private Integer frequencia;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Medicamento medicamento;
}
