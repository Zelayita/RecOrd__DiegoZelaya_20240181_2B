package DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Models.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class DTOClientes {


    private Long id_Clientes;
    private String nombreC;
    private String correo;
    private String telefono;
    private LocalDate fecha_Registro;
    private String activo;
}
