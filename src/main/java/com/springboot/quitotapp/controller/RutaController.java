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

import com.springboot.quitotapp.models.entity.Ruta;
import com.springboot.quitotapp.models.service.IRutaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/rutas")
public class RutaController {
	
	
	@Autowired
	private IRutaService rutaService;
	@GetMapping("/")
	public String listarRutas(Model model) {
		
		List<Ruta> listadoRutas = rutaService.listarTodas();
		
		model.addAttribute("titulo", "Lista de Rutas");
		model.addAttribute("rutas", listadoRutas);
		
		return "/views/rutas/listar";
		
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		
		Ruta ruta = new Ruta();
		
		model.addAttribute("titulo", "Formulario:Nueva Ruta");
		model.addAttribute("ruta", ruta);
		
		return "/views/rutas/frmCrear";
		
	}
	
	
	@PostMapping("/save")
	public String  guardar(@Valid
			               @ModelAttribute 
			               Ruta ruta,
			               BindingResult result,
			               Model model,
			               RedirectAttributes attribute) {
		if (result.hasErrors()) {
			
			model.addAttribute("titulo", "Formulario:Nueva Ruta");
			model.addAttribute("ruta", ruta);
			
			System.out.println("Existieron errores en el formulario");
			
			return "/views/rutas/frmCrear";
		}
		
		rutaService.guardar(ruta);
		System.out.println("Ruta guardada con éxito");
		attribute.addFlashAttribute("success", "Unidad guardada con éxito");
		return "redirect:/views/rutas/";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id")
	                     Integer idRuta,
	                     Model model,
	                     RedirectAttributes attribute) {
	
		Ruta ruta=null;
		
		//Validación
		if (idRuta>0) {
			
			ruta = rutaService.buscarPorId(idRuta);
			
			if (ruta == null) {
				 System.out.println("Eroor:El ID de la Ruta no existe!");
				 attribute.addFlashAttribute("error", "ATENCION:El ID de la Ruta no existe!");
				 return "redirect:/views/rutas/"; }
				
		}else {
				System.out.println("Error:Error con el ID de la Ruta ");
				 attribute.addFlashAttribute("error", "ATENCION:El ID de la Ruta no existe!");
					return "redirect:/views/rutas/";
			}
		
		
		model.addAttribute("titulo", "Formulario:Editar Ruta");
		model.addAttribute("ruta", ruta);
		
		return "/views/rutas/frmCrear";
		
	}
	
		
		
		
		
	
	@GetMapping("/delete/{id}")
	public String eliminarr(@PathVariable("id")
	                     Integer idRuta,
	                     RedirectAttributes attribute) 
	{
		
Ruta ruta=null;
		
		//Validación
		if (idRuta>0) {
			
			ruta = rutaService.buscarPorId(idRuta);
			
			if (ruta == null) {
				 System.out.println("Eroor:El ID de la Ruta no existe!");
				 attribute.addFlashAttribute("error", "ATENCION:El ID de la Ruta no existe!");
				 return "redirect:/views/rutas/"; }
				
		}else {
				System.out.println("Error:Error con el ID de la Ruta ");
				attribute.addFlashAttribute("error", "ATENCION:Error con el ID de la Ruta!");
					return "redirect:/views/rutas/";
			}
		
		
		rutaService.borrar(idRuta);
		
		System.out.println("Ruta borrada con éxito");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Éxito!");
		return "redirect:/views/rutas/";
		
	}
	

}

















