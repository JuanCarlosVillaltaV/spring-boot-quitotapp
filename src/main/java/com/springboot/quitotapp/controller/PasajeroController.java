package com.springboot.quitotapp.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.quitotapp.models.entity.Pasajero;
import com.springboot.quitotapp.models.service.IPasajeroService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/pasajeros")
public class PasajeroController {
	
	@Autowired
	private IPasajeroService pasajeroService;
	
	@GetMapping("/")
	public String listarPasajeros(Model model) {
		
		List<Pasajero> listadoPasajeros= pasajeroService.listarTodos();
		
		model.addAttribute("titulo", "Lista de Pasajeros");
		model.addAttribute("pasajeros", listadoPasajeros);
		
		return "/views/pasajeros/listar";
		
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		Pasajero pasajero = new Pasajero();
		
		model.addAttribute("titulo", "Formulario:Nuevo Pasajero");
		model.addAttribute("pasajero", pasajero);
		
		return "/views/pasajeros/frmCrear";
		
		
	}
	
	@PostMapping("/save")
	public String  guardar(@Valid 
			               @ModelAttribute 
			               Pasajero pasajero,
			               BindingResult result,
			               Model model,
			               RedirectAttributes attribute) 
	{
		if (result.hasErrors()) {
			
			model.addAttribute("titulo", "Formulario:Nuevo Pasajero");
			model.addAttribute("pasajero", pasajero);
			
			System.out.println("Existieron errores en el formulario");
			
			return "/views/pasajeros/frmCrear";
		}
		pasajeroService.guardar(pasajero);
		
		System.out.println("Pasajero guardado con éxito!");
		attribute.addFlashAttribute("success", "Pasajero guardado con éxito!");
		return "redirect:/views/pasajeros/";
		
	}
	
	
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") 
			             Integer idPasajero,
			             Model model,
			             RedirectAttributes attribute) 
	{
		Pasajero pasajero=null;
		//Validación
		if (idPasajero>0) {
			
			pasajero = pasajeroService.buscarPorId(idPasajero);
			
			if (pasajero == null) {
				 System.out.println("Error:El ID de pasajeros no existe!");
				 attribute.addFlashAttribute("error", "ATENCION:El ID de pasajeros no existe!");
				 return "redirect:/views/pasajeros/";
			}
		}else {
			System.out.println("Error:El ID de pasajeros !");
			 attribute.addFlashAttribute("error", "ATENCION:El ID de pasajeros !");
			 return "redirect:/views/pasajeros/";
		}
		
		
        model.addAttribute("titulo", "Formulario:Actualizar pasajero!");
		model.addAttribute("pasajero", pasajero);
		
		System.out.println("Pasajero actualizado con éxito!");
		return "/views/pasajeros/frmCrear";
		}
	
	
	
	
	
	@GetMapping("/delete/{id}")
	public String el(@PathVariable("id") 
			             Integer idPasajero,
			             RedirectAttributes attribute) 
	{
		
		Pasajero pasajero=null;
		//Validación
		if (idPasajero>0) {
			
			pasajero = pasajeroService.buscarPorId(idPasajero);
			
			if (pasajero == null) {
				 System.out.println("Error:El ID de pasajeros no existe!");
				 attribute.addFlashAttribute("error", "ATENCION:El ID de la pasajero no existe!");
				 return "redirect:/views/pasajeros/";
			}
		}else {
			System.out.println("Error:El ID de pasajeros !");
			 attribute.addFlashAttribute("error", "ATENCION::Error con el ID de la Pasajero!");
			 return "redirect:/views/pasajeros/";
		}
		
		pasajeroService.borrar(idPasajero);
		
	
		System.out.println("Pasajero eliminado con Éxito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Éxito!");
		return "redirect:/views/pasajeros/";
		}
	
	
}



























