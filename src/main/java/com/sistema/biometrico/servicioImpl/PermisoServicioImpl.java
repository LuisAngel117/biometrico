package com.sistema.biometrico.servicioImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.biometrico.entidad.Permiso;
import com.sistema.biometrico.repositorio.IPermisoRepositorio;
import com.sistema.biometrico.servicio.IPermisoServicio;

@Service
public class PermisoServicioImpl implements IPermisoServicio {

    @Autowired
    private IPermisoRepositorio repositorio;

    @Override
    public Permiso crear(Permiso permiso) {
        return repositorio.save(permiso);
    }

    @Override
    public Permiso actualizar(Integer id, Permiso permiso) {
        if (repositorio.existsById(id)) {
            permiso.setId(id);
            return repositorio.save(permiso);
        }
        return null;
    }

    @Override
    public boolean eliminar(Integer id) {
        Permiso permiso = repositorio.findById(id).orElse(null);
        if (permiso != null) {
            repositorio.delete(permiso);
            return true;
        }
        return false;
    }

    @Override
    public Permiso obtenerPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public List<Permiso> listarPermisosActivos() {
        return repositorio.listarPermisosActivos();
    }
}

