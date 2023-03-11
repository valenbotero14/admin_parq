package com.adminparq.adminparq.controller;

import com.adminparq.adminparq.model.Employee;
import com.adminparq.adminparq.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController /*Recibe peticiones con un formato especifico*/
@RequestMapping("/api") /*asignar solicitudes web a clases de controlador especificas y/o metodos
de controlador*/

public class EmployeeController {

    @Autowired /*permite resolver la inyección de dependencias de los siguiente modos.
    En el constructor de la clase. En un atributo. En un método setter.*/
    private EmployeeRepository repository;

    @GetMapping("/employee") /*simplificar el manejo de los diferentes métodos de Spring MVC
    y los @RequestMappings */
    public List<Employee> allEmployee() {
        return repository.findAll();
    }

    @GetMapping("/employee/{name}")
    public List<Employee> findByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    @PostMapping("/employee/") /*crear*/
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @PutMapping("/employee/{id}") /*actualizar*/
    public Employee updateEmployeed(@PathVariable int id, @RequestBody Employee employee) {
        return repository.save(employee);
    }

    @DeleteMapping("/employee/{id}") /*eliminar*/
    public void deleteEmployee(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

}

