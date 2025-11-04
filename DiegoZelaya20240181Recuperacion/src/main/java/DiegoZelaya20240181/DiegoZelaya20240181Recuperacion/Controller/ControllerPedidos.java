package DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Controller;

import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Exceptions.ExceptionColumnDuplicate;
import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Models.DTO.DTOPedidos;
import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Service.ServicePedidos;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/Pedidos")
public class ControllerPedidos {

    @Autowired
    private ServicePedidos service;

    @GetMapping("/GetPedidos")
    public List<DTOPedidos> ObtenerEmpleados(){return service.getAllPedidos();}


    @PostMapping("/ingresarPedido")
    private ResponseEntity<Map<String,Object>> InsertarPedidos(
            @Valid @RequestBody DTOPedidos Insertdto, HttpServletRequest httpServletRequest
    ){
        try{
            DTOPedidos response = service.InsertarPedidos(Insertdto);
            if(response == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "Error", "Error en la Insercion",
                        "status", "La Insercion no se pudo hacer correctamente",
                        "descripcion", "Verifique los Valores"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "Status", "Completado",
                    "data", response
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "Status", "Error",
                    "message", "Error al Ingresar Datos",
                    "detail", e.getMessage()
            ));
        }
    }

    @PutMapping("/actualizarPedidos/{id}")
    public ResponseEntity<?> UpdatePedidos(
            @PathVariable Long id,
            @Valid @RequestBody DTOPedidos Pedido,
            BindingResult bindingResult)
    {if (bindingResult.hasErrors()){
        Map<String,String>errores = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errores);
    }
        try{
            DTOPedidos user = service.UpdatePedidos(id, Pedido);
            return ResponseEntity.ok(user);
        }catch (ExceptionColumnDuplicate e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                    "Error", "Datos Incorrectos",
                    "Campo", e.getColumnDuplicate()));
        }
    }

    @DeleteMapping("/eliminarPedidos/{id}")
    public ResponseEntity<Map<String, String>> EliminarPedidos(@PathVariable Long id){
        try{
            if(!service.DeletePedidos(id)){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .header("x-Mensaje.Error", "Pedidos no encontrado")
                        .body(Map.of(
                                "Error", "Not Found",
                                "Mensaje", "No se encontro",
                                "TimeStamp", Instant.now().toString()));
            }
            return ResponseEntity.ok().body(Map.of(
                    "Status", "Proceso Completado",
                    "Message", "Pedido eliminado"
            ));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of(
                    "Status", "Error",
                    "Message", "Error al Eliminar",
                    "detail", e.getMessage()));
        }
    }
}