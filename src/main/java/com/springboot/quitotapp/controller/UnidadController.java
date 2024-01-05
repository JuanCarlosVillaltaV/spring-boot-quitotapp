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

import com.springboot.quitotapp.models.entity.Unidad;
import com.springboot.quitotapp.models.service.IUnidadService;
import com.springboot.quitotapp.models.service.UnidadService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/unidades")
public class UnidadController {

	@Autowired
	private IUnidadService unidadService;
	@GetMapping("/")
	public String listarUnidades(Model model) {
		
		List<Unidad> listadoUnidades = unidadService.listarTodas();
		
		model.addAttribute("titulo", "Lista de Unidades");
		model.addAttribute("unidades", listadoUnidades);
		
		return "/views/unidades/listar";
		
	}
	
	
	
	
	@GetMapping("/create")
	public String crear(Model model) {
		
		Unidad unidad = new Unidad();
		model.addAttribute("titulo", "Formulario:Nueva Unidad");
		model.addAttribute("unidad", unidad);
		
		return "/views/unidades/frmCrear";
		
	}
	
	
	@PostMapping("/save")
	public String guardar (@Valid
			               @ModelAttribute 
			                Unidad unidad,
			                BindingResult result,
			                Model model,
			                RedirectAttributes attribute) 
	{
		//Validación
		if (result.hasErrors()) {
			
			
			model.addAttribute("titulo", "Formulario:Nueva Unidad");
			model.addAttribute("unidad", unidad);
			
			System.out.println("Existieron errores en el formulario");
			
			return "/views/unidades/frmCrear";
			
		}
		unidadService.guardar(unidad);
		System.out.println("Unidad guardada con éxito");
		attribute.addFlashAttribute("success", "Unidad guardada con éxito");
		return "redirect:/views/unidades/";
		
	} 
	
	
	
	
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") 
	                        Integer idUnidad,
			                      Model model,
			                      RedirectAttributes attribute) {
		
		Unidad unidad=null;
		//Validación
		if (idUnidad >0) {
			 unidad = unidadService.buscarPorId(idUnidad);
			 
			 if (unidad == null) {
				 System.out.println("Error:El ID de la Unidad no existe!");
				 attribute.addFlashAttribute("error", "ATENCION:El ID de la Unidad no existe!");
				 return "redirect:/views/unidades/";
			}
		}else {
			 System.out.println("Error:Error con el ID de la Unidad ");
			 attribute.addFlashAttribute("error", "ATENCION:Error con el ID de la Unidad ");
			 return "redirect:/views/unidades/";
			
		}
		
		
		//Unidad unidad = unidadService.buscarPorId(idUnidad);
		model.addAttribute("titulo", "Formulario:Editar Unidad");
		model.addAttribute("unidad", unidad);
		
		System.out.println("Unidad actualizada con éxito");
		return "/views/unidades/frmCrear";
		
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") 
	                        Integer idUnidad,
	                        RedirectAttributes attribute) {
		
		Unidad unidad=null;
		//Validación
		if (idUnidad >0) {
			 unidad = unidadService.buscarPorId(idUnidad);
			 
			 if (unidad == null) {
				 System.out.println("Error:El ID de la Unidad no existe!");
				 attribute.addFlashAttribute("error", "ATENCION:El ID de la Unidad no existe!");
				 return "redirect:/views/unidades/";
			}
		}else {
			 System.out.println("Error:Error con el ID de la Unidad ");
			 attribute.addFlashAttribute("error", "ATENCION::Error con el ID de la Unidad!");
			 return "redirect:/views/unidades/";
			
		}
		
		
	unidadService.borrar(idUnidad);
		
	System.out.println("Unidad borrada con éxito");
	 attribute.addFlashAttribute("warning", "Registro Eliminado con Éxito!");
		return "redirect:/views/unidades/";
		
	}
			                     

}





























