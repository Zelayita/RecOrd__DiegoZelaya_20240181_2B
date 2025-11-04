package DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Models.DTO;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class DTOPedidos {

    private Long id_Pedidos;
    private Long id_Cliente;
    private Long id_Producto;
    private int cantidad;
    private LocalDate fechaPedidos;
    private String Estado;
    private double Total;
}
