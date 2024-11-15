package com.sistema.biometrico.servicio;
import java.util.List;
import com.sistema.biometrico.entidad.Catalo;


public interface ICatalogoServicio {
    Catalo crear(Catalo catalogo);
    Catalo actualizar(Integer id, Catalo catalogo);
    boolean eliminar(Integer id);
    Catalo obtenerPorId(Integer id);
    List<Catalo> listarCatalogosActivos();
}
