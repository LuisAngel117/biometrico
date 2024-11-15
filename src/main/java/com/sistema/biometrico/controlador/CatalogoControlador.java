package com.sistema.biometrico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.biometrico.entidad.Catalo;

import com.sistema.biometrico.servicio.ICatalogoServicio;


import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/home/catalogo")
public class CatalogoControlador {

    @Autowired
    private ICatalogoServicio catalogoServicio;

    @GetMapping("/listar_catalogo")
    public String listarPermiso(Model model) {
        List<Catalo> catalogos = catalogoServicio.listarCatalogosActivos();
        model.addAttribute("listarCatalogo", catalogos);
        return "catalogo/catalogo_listar";
    }

    @GetMapping({"/registro_catalogo", "/editar/{id}"})
    public String mostrarFormulario(@PathVariable(required = false) Integer id, Model model) {
        Catalo catalogo;
        if (id == null) {
            catalogo = new Catalo();
        } else {
            catalogo = catalogoServicio.obtenerPorId(id);
            if (catalogo == null) {
                return "redirect:/admin/home/catalogo/listar_catalogo";
            }
        }
        model.addAttribute("catalogo", catalogo);
        return "catalogo/catalogo_registro";
    }

    @PostMapping({"/guardar", "/editar/{id}"})
    public String guardarOActualizarCatalogo(@PathVariable(required = false) Integer id, @Valid @ModelAttribute Catalo catalogo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "catalogo/catalogo_registro";
        }
        if (id == null) {
            catalogoServicio.crear(catalogo);
        } else {
            catalogoServicio.actualizar(id, catalogo);
        }
        return "redirect:/admin/home/catalogo/listar_catalogo";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCatalogo(@PathVariable Integer id) {
        catalogoServicio.eliminar(id);
        return "redirect:/admin/home/catalogo/listar_catalogo";
    }
}
