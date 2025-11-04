package DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Service;

import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Entities.EntitesClientes;
import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Entities.EntitesPedidos;
import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Entities.EntitesProductos;
import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Exceptions.ExceptionEmpleadoNoRegistado;
import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Exceptions.ExceptionsNotFound;
import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Models.DTO.DTOPedidos;
import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Repository.RepositoryClientes;
import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Repository.RepositoryPedidos;
import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Repository.RepositoryProducto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@CrossOrigin
public class ServicePedidos {

    @Autowired
    private RepositoryPedidos repo;

    @Autowired
    private RepositoryClientes repoCliente;

    @Autowired
    private RepositoryProducto repoProducto;

    public List<DTOPedidos> getAllPedidos(){
        List<EntitesPedidos> usuarios = repo.findAll();
        return usuarios.stream()
                .map(this::ConvertirADTOPedidos)
                .collect(Collectors.toList());
    }

    public DTOPedidos InsertarPedidos(@Valid DTOPedidos insertdto) {
        if (insertdto == null){
            throw new IllegalArgumentException("Por favor verifique los Datos");
        }
        try{
            EntitesPedidos objdata = ConvertirAEntityPedidos(insertdto);
            EntitesPedidos Insert = repo.save(objdata);
            return ConvertirADTOPedidos(Insert);
        }catch(Exception e){
            log.error("Error a la Hora de la Insercion de Datos" + e.getMessage());
            throw new ExceptionEmpleadoNoRegistado("No se pudo Insertar");
        }
    }

    public DTOPedidos UpdatePedidos(Long id, @Valid DTOPedidos json){
        EntitesPedidos existe = repo.findById(id).orElseThrow(() -> new ExceptionsNotFound("No encontrado"));
        existe.setId_Pedidos(json.getId_Pedidos());

        if(json.getId_Cliente() != null){
            EntitesClientes cliente = repoCliente.findById(json.getId_Cliente()).orElseThrow(() ->  new IllegalArgumentException("ID no encontrado en Clientes"));
            existe.setCliente(cliente);
        }
        if(json.getId_Producto() != null){
            EntitesProductos Productos = repoProducto.findById(json.getId_Producto()).orElseThrow(() ->  new IllegalArgumentException("ID no encontrado en Productos"));
            existe.setProducto(Productos);
        }
        existe.setCantidad(json.getCantidad());
        existe.setFechaPedidos(json.getFechaPedidos());
        existe.setEstado(json.getEstado());
        existe.setTotal(json.getTotal());


        EntitesPedidos UpdateEntity = repo.save(existe);

        return ConvertirADTOPedidos(UpdateEntity);
    }

    public boolean DeletePedidos(Long id){
        EntitesPedidos existencia = repo.findById(id).orElseThrow(null);
        if(existencia != null){
            repo.deleteById(id);
            return true;
        }
        return false;
    }



    private EntitesPedidos ConvertirAEntityPedidos(@Valid DTOPedidos insertdto){
        EntitesPedidos entity = new EntitesPedidos();
        entity.setId_Pedidos(insertdto.getId_Pedidos());

        if(insertdto.getId_Cliente() != null){
            EntitesClientes cliente = repoCliente.findById(insertdto.getId_Cliente()).orElseThrow(() ->  new IllegalArgumentException("ID no encontrado en Clientes"));
            entity.setCliente(cliente);
        }

        if(insertdto.getId_Producto() != null){
            EntitesProductos Productos = repoProducto.findById(insertdto.getId_Producto()).orElseThrow(() ->  new IllegalArgumentException("ID no encontrado en Productos"));
            entity.setProducto(Productos);
        }
        entity.setCantidad(insertdto.getCantidad());
        entity.setFechaPedidos(insertdto.getFechaPedidos());
        entity.setEstado(insertdto.getEstado());
        entity.setTotal(insertdto.getTotal());
        return entity;
    }

    private DTOPedidos ConvertirADTOPedidos(EntitesPedidos entity){
        DTOPedidos json = new DTOPedidos();
        json.setId_Pedidos(entity.getId_Pedidos());
        json.setId_Cliente(entity.getCliente().getId_Clientes());
        json.setId_Producto(entity.getProducto().getId_Productos());
        json.setCantidad(entity.getCantidad());
        json.setFechaPedidos(entity.getFechaPedidos());
        json.setEstado(entity.getEstado());
        json.setTotal(entity.getTotal());

        return json;
    }

}
