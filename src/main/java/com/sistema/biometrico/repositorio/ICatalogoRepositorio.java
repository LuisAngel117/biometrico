package com.sistema.biometrico.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sistema.biometrico.entidad.Catalo;

public interface ICatalogoRepositorio extends JpaRepository<Catalo, Integer> {
    
    @Query("SELECT p FROM Catalo p WHERE p.estado = true")
    List<Catalo> listarCatalogosActivos();
}
