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

import com.sistema.biometrico.entidad.Permiso;
import com.sistema.biometrico.servicio.IPermisoServicio;
import com.sistema.biometrico.servicio.IEmpleadoServicio;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/home/permiso")
public class PermisoControlador {

    @Autowired
    private IPermisoServicio permisoServicio;
    
    @Autowired
    private IEmpleadoServicio empleadoServicio;

    @GetMapping("/listar_permiso")
    public String listarPermiso(Model model) {
        List<Permiso> permisos = permisoServicio.listarPermisosActivos();
        model.addAttribute("listarPermiso", permisos);
        return "permiso/permiso_listar";
    }

    @GetMapping({"/registro_permiso", "/editar/{id}"})
    public String mostrarFormulario(@PathVariable(required = false) Integer id, Model model) {
        Permiso permiso;
        if (id == null) {
            permiso = new Permiso();
        } else {
            permiso = permisoServicio.obtenerPorId(id);
            if (permiso == null) {
                return "redirect:/admin/home/permiso/listar_permiso";
            }
        }
        model.addAttribute("permiso", permiso);
        model.addAttribute("empleados", empleadoServicio.listarEmpleadosActivos());
        return "permiso/permiso_registro";
    }

    @PostMapping({"/guardar", "/editar/{id}"})
    public String guardarOActualizarPermiso(@PathVariable(required = false) Integer id, @Valid @ModelAttribute Permiso permiso, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("empleados", empleadoServicio.listarEmpleadosActivos());
            return "permiso/permiso_registro";
        }
        if (id == null) {
            permisoServicio.crear(permiso);
        } else {
            permisoServicio.actualizar(id, permiso);
        }
        return "redirect:/admin/home/permiso/listar_permiso";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPermiso(@PathVariable Integer id) {
        permisoServicio.eliminar(id);
        return "redirect:/admin/home/permiso/listar_permiso";
    }
}
