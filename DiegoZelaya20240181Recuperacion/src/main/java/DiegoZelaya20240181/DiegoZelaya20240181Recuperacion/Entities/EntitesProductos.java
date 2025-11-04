package DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Table(name = "PRODUCTOS")
public class EntitesProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " PRODUCTOS_SEQ")
    @SequenceGenerator(sequenceName = " PRODUCTOS_SEQ", name = " PRODUCTOS_SEQ", allocationSize = 1)
    @Column(name = "PRODUCTO_ID")
    private Long id_Productos;

    @Column(name = "NOMBRE")
    private String nombreP;

    @Column(name = "DESCRIPCION")
    private String Descripcion;

    @Column(name = "PRECIO")
    private double precio;

    @Column(name = "STOCK")
    private int Stock;

    @Column(name = "CATEGORIA")
    private String Categoria;

    @Column(name = "FECHA_CREACION")
    private LocalDate fecha_creacion;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EntitesPedidos> pedidos = new ArrayList<>();

}
