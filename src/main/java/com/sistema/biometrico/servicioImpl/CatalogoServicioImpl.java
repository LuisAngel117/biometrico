package com.sistema.biometrico.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.biometrico.entidad.Catalo;
import com.sistema.biometrico.entidad.Permiso;
import com.sistema.biometrico.repositorio.ICatalogoRepositorio;

import com.sistema.biometrico.servicio.ICatalogoServicio;


@Service
public class CatalogoServicioImpl implements ICatalogoServicio{
    @Autowired
    private ICatalogoRepositorio repositorio;

    @Override
    public Catalo crear(Catalo catalogo) {
        return repositorio.save(catalogo);
    }

    @Override
    public Catalo actualizar(Integer id, Catalo catalogo) {
        if (repositorio.existsById(id)) {
            catalogo.setId(id);
            return repositorio.save(catalogo);
        }
        return null;
    }

    @Override
    public boolean eliminar(Integer id) {
        Catalo catalogo = repositorio.findById(id).orElse(null);
        if (catalogo != null) {
            repositorio.delete(catalogo);
            return true;
        }
        return false;
    }

    @Override
    public Catalo obtenerPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public List<Catalo> listarCatalogosActivos() {
        return repositorio.listarCatalogosActivos();
    }

}
