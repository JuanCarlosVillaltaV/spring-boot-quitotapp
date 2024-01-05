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

import com.springboot.quitotapp.models.entity.Parada;
import com.springboot.quitotapp.models.service.IParadaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/paradas")

public class ParadaController {

	@Autowired
	private IParadaService paradaService;
	
	@GetMapping("/")
	public String listarParadas(Model model) {
		
		 List<Parada> listadoParadas = paradaService.listarTodas();
		 
		model.addAttribute("titulo", "listado de Paradas");
		model.addAttribute("paradas", listadoParadas);
		
		
		return "/views/paradas/listar";
		
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		
		Parada parada = new Parada();
		
		model.addAttribute("titulo", "Formulario: Nueva Parada");
		model.addAttribute("parada", parada);
		
		return "/views/paradas/frmCrear";
		
	}
	
	@PostMapping("/save")
	public String guardar(@Valid
			              @ModelAttribute 
			               Parada parada,
			               BindingResult result,
			               Model model,
			               RedirectAttributes attribute) 
	{
		//Validación
      if (result.hasErrors()) {
    	  
    	model.addAttribute("titulo", "Formulario: Nueva Parada");
  		model.addAttribute("parada", parada);
  		
  		System.out.println("Existieron errores en el formulario");
  		return "/views/paradas/frmCrear";
	}		
		
		
		
		
		paradaService.guardar(parada);
		System.out.println("Parada guardada con éxito");
		attribute.addFlashAttribute("success", "Parada guardada con éxito");
		return "redirect:/views/paradas/";
		
	}
	
	
	
	
	
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id")
	                     Integer idParada,
			              Model model,
			              RedirectAttributes attribute)
			             {
		
		Parada parada= null;
		//Validación
		if (idParada>0) {
			
			 parada = paradaService.buscarPorId(idParada);
			 if (parada==null) {
				 System.out.println("Eroor:El ID de la Parada no existe!");
				 attribute.addFlashAttribute("error", "ATENCION:El ID de la Parada no existe!");
				 return "redirect:/views/paradas/";}
			
		}else {
			 System.out.println("Eroor:con el ID de la parada");
			 attribute.addFlashAttribute("error", "ATENCION:Error con el ID de la Parada ");
			 return "redirect:/views/paradas/";
		
		}
	
		
		model.addAttribute("titulo", "Formulario: Actualizar Parada");
		model.addAttribute("parada", parada);
		
		System.out.println("Parada actualizada con éxito");
		attribute.addFlashAttribute("error", "ATENCION::Error con el ID de la Parada!");
		return "/views/paradas/frmCrear";
		
	}
	
	@GetMapping("/delete/{id}")
	public String borrar(@PathVariable ("id")
	                     Integer idParada,
	                     RedirectAttributes attribute) 
	{
		Parada parada= null;
		//Validación
		if (idParada>0) {
			
			 parada = paradaService.buscarPorId(idParada);
			 if (parada==null) {
				 System.out.println("Eroor:El ID de la Parada no existe!");
				 attribute.addFlashAttribute("error", "ATENCION:El ID de la Parada no existe!");
				 return "redirect:/views/paradas/";}
			
		}else {
			 System.out.println("Eroor:con el ID de la parada");
			 attribute.addFlashAttribute("error", "ATENCION::Error con el ID de la Parada!");
			 return "redirect:/views/paradas/";
		
		}
	
		
		
	paradaService.borrar(idParada);
		
		
		
		System.out.println("Parada eliminada con éxito");
		 attribute.addFlashAttribute("warning", "Registro Eliminado con Éxito!");
		return "redirect:/views/paradas/";
		
	}
}


















