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

import com.springboot.quitotapp.models.entity.Chofer;
import com.springboot.quitotapp.models.service.IChoferService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/choferes")
public class ChoferController {

	@Autowired
	private IChoferService choferService;
	
	
	@GetMapping("/")
	public String listarChoferes(Model model) {
		List<Chofer> listadoChoferes= choferService.listarTodos();
		
		model.addAttribute("titulo", "Lista de Choferes");
		model.addAttribute("choferes", listadoChoferes);
		
		return "/views/choferes/listar";
		
	}
	
	
	
	@GetMapping("/create")
	public String crear(Model model) {
		
		Chofer chofer = new Chofer();
		model.addAttribute("titulo", "Formulario: Nuevo Chofer");
		model.addAttribute("chofer", chofer);
		return "/views/choferes/frmCrear";
		
	}
	
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute 
			              Chofer chofer, 
			              BindingResult result, 
			              Model model,
			              RedirectAttributes attribute) {
		
		//Validación
		if (result.hasErrors()) {
			
			
			model.addAttribute("titulo", "Formulario: Nuevo Chofer");
			model.addAttribute("chofer", chofer);
			
			System.out.println("Existierón errores en el formulario");
			
			return "/views/choferes/frmCrear";
			
			
		}
		
		choferService.guardar(chofer);
		System.out.println("Chofer guardado con éxito!");
		attribute.addFlashAttribute("success", "Chofer guardado con éxito!");
		return "redirect:/views/choferes/";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id")
	                     Integer idChofer, 
	                      Model model,
	                      RedirectAttributes attribute) 
	{
		
		//Mensajes
		
		Chofer chofer = null;
		
		if (idChofer > 0) {
		 chofer = choferService.buscarPorId(idChofer);
		 
		 if (chofer == null) {
			 System.out.println("Error: El ID del chofer no existe!");
			 attribute.addFlashAttribute("error", "ATENCIÓN: El ID del chofer no existe!");
			 return "redirect:/views/choferes/";
		   }
		}else {
			
			System.out.println("Error: Error con el ID del Chofer");
			attribute.addFlashAttribute("error", "ATENCIÓN: Error con el ID del chofer");
			 return "redirect:/views/choferes/";
			
		}
		
		//Chofer chofer = choferService.buscarPorId(idChofer);
		
		model.addAttribute("titulo", "Formulario: Editar Chofer");
		model.addAttribute("chofer", chofer);
		
		System.out.println("Chofer actualizado con éxito!");
		attribute.addFlashAttribute("error", "ATENCIÓN: Error con el ID del chofer");
		return "/views/choferes/frmCrear";
		
	}
	
	
	
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id")
	                     Integer idChofer,
	                     RedirectAttributes attribute) 
			             
	                     
	{
		
	//Mensajes
		
		Chofer chofer = null;
		
		if (idChofer > 0) {
		 chofer = choferService.buscarPorId(idChofer);
		 
		 if (chofer == null) {
			 System.out.println("Error: El ID del chofer no existe!");
			 attribute.addFlashAttribute("error", "ATENCIÓN: El ID del chofer no existe!");
			 
			 return "redirect:/views/choferes/";
		   }
		}else {
			
			System.out.println("Error: Error con el ID del Chofer");
			 
			 return "redirect:/views/choferes/";
			
		}
		
		
		choferService.borrar(idChofer);
		
		
		
		System.out.println("Registro eliminado con éxito!");
		attribute.addFlashAttribute("warning", "Registro eliminado con éxito!");
		return "redirect:/views/choferes/";
		
	}
	
}
























