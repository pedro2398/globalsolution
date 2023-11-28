package globalsolution.globalsolution.model;

import java.sql.Timestamp;

import globalsolution.globalsolution.model.pessoa.Paciente;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    private Long id;
    private Timestamp eventoTime;
    private String valor;
    private String tipo;
    private Paciente paciente;
}
