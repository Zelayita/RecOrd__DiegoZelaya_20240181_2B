package DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Table(name = "CLIENTES")
public class EntitesClientes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTES_SEQ")
    @SequenceGenerator(sequenceName = "CLIENTES_SEQ", name = "CLIENTES_SEQ", allocationSize = 1)
    @Column(name = "CLIENTE_ID")
    private Long id_Clientes;

    @Column(name = "NOMBRE")
    private String nombreC;

    @Column(name = "EMAIL")
    private String correo;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "FECHA_REGISTRO")
    private LocalDate fecha_Registro;

    @Column(name = "ACTIVO")
    private String activo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EntitesPedidos> pedidos = new ArrayList<>();
}
