package com.sistema.biometrico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.biometrico.entidad.RegistroAsistencia;

@Repository
public interface IRegistroAsistenciaRepositorio extends JpaRepository<RegistroAsistencia, Integer>{

}
