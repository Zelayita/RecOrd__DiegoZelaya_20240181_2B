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
public class DTOProductos {


    private Long id_Productos;
    private String nombreP;
    private String Descripcion;
    private double precio;
    private int Stock;
    private String Categoria;
    private LocalDate fecha_creacion;
}
