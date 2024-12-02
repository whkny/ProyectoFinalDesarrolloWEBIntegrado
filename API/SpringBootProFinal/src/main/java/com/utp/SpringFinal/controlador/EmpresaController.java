/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.SpringFinal.controlador;


import com.utp.SpringFinal.modelo.Empresa;
import com.utp.SpringFinal.servicio.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    // Listar todas las empresas
    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    // Obtener una empresa por ID
    @GetMapping("/{id}")
    public Empresa obtenerEmpresaPorId(@PathVariable String id) {
        return empresaService.obtenerEmpresaPorId(id);
    }

    // Guardar una nueva empresa
    @PostMapping
    public Empresa guardarEmpresa(@RequestBody Empresa empresa) {
        return empresaService.guardarEmpresa(empresa);
    }

    // Eliminar una empresa por ID
    @DeleteMapping("/{id}")
    public void eliminarEmpresa(@PathVariable String id) {
        empresaService.eliminarEmpresa(id);
    }
}