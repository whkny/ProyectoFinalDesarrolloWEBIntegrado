/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.SpringFinal.servicio;

import com.utp.SpringFinal.modelo.Empresa;
import com.utp.SpringFinal.repositorio.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa guardarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa obtenerEmpresaPorId(String id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public void eliminarEmpresa(String id) {
        empresaRepository.deleteById(id);
    }
}