package DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Table(name = "PEDIDOS")
public class EntitesPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " PEDIDOS_SEQ")
    @SequenceGenerator(sequenceName = " PEDIDOS_SEQ", name = " PEDIDOS_SEQ", allocationSize = 1)
    @Column(name = "PEDIDO_ID")
    private Long id_Pedidos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private EntitesClientes cliente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTO_ID", nullable = false)
    private EntitesProductos producto;

    @Column(name = "CANTIDAD")
    private int cantidad;

    @Column(name = "FECHA_PEDIDO")
    private LocalDate fechaPedidos;

    @Column(name = "ESTADO")
    private String Estado;

    @Column(name = "TOTAL")
    private double Total;
}
