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

import com.springboot.quitotapp.models.entity.Empresa;
import com.springboot.quitotapp.models.service.IEmpresaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/empresas")
public class EmpresaController {

	@Autowired
	private IEmpresaService empresaService;

	@GetMapping("/")
	private String listarEmpresa(Model model) {
		List<Empresa> listadoEmpresa = empresaService.listarTodas();

		model.addAttribute("titulo", "Lista de Empresa");
		model.addAttribute("empresas", listadoEmpresa);
		return "/views/empresas/listar";
       }
	
	
    @GetMapping("/create")
	private String crear(Model model) {
		Empresa empresa = new Empresa();
		
		model.addAttribute("titulo", "Formulario: Nueva empresa");
		model.addAttribute("empresa",empresa);
		
		// TODO Auto-generated method stub
		return "/views/empresas/frmCrear";
       }
    
	
	@PostMapping("/save")
	public String guardar(@Valid  @ModelAttribute 
			            Empresa empresa,
			            BindingResult result,
			            Model model,
			            RedirectAttributes attribute) {
		
		//Validamos
		if (result.hasErrors()) {
			
			
			
			model.addAttribute("titulo", "Formulario: Nueva empresa");
			model.addAttribute("empresa",empresa);
			System.out.println("Existieron errores en el formulario!");
			return "/views/empresas/frmCrear";
		}
		

		
		model.addAttribute("titulo", "Formulario: Nueva empresa");
		model.addAttribute("empresa",empresa);
		
		empresaService.guardar(empresa);
		System.out.println("Empresa guardada con éxito!");
		attribute.addFlashAttribute("success", "Empresa guardada con éxito!");
		return "redirect:/views/empresas/";
	}
	
	//Método Editar
	@GetMapping("/edit/{id}")
	private String editar(@PathVariable ("id") 
	                      Integer idEmpresa,
			              Model model,
			              RedirectAttributes attribute) {
		
		Empresa empresa = null;
		//Validación del id
		if (idEmpresa >0) {
			
			empresa =  empresaService.buscarPorId(idEmpresa);
			//Preguntamos 
			if (empresa==null) {
			
				System.out.println("Error el ID de la empresa no existe!");
				attribute.addFlashAttribute("error","ERROR: El ID de la empresa no existe!");
				return "redirect:/views/empresas/";
				
			}
			
		}else {
			
			System.out.println("Error el con el ID de la empresa!");
			attribute.addFlashAttribute("error","Error el con el ID de la empresa!");
			return "redirect:/views/empresas/";
			
		}
		
		//Empresa empresa =  empresaService.buscarPorId(idEmpresa);
		
		model.addAttribute("titulo", "Formulario: Ediatr Empresa");
		model.addAttribute("empresa",empresa);
		
		// TODO Auto-generated method stub
		System.out.println("Empresa editada con éxito!");
		return "/views/empresas/frmCrear";
       }
	
	
	@GetMapping("/delet/{id}")
	private String eliminar(@PathVariable ("id") 
	                      Integer idEmpresa,
	                      RedirectAttributes attribute ) {
	                     
	
		
		Empresa empresa = null;
		//Validación del id
		if (idEmpresa >0) {
			
			empresa =  empresaService.buscarPorId(idEmpresa);
			//Preguntamos 
			if (empresa==null) {
			
				
				System.out.println("Error el ID de la empresa no existe!");
				 attribute.addFlashAttribute("error", "ATENCION:El ID de la Empresa no existe!");
				return "redirect:/views/empresas/";
				
			}
			
		}else {
			
			System.out.println("Error el con el ID de la empresa!");
			attribute.addFlashAttribute("error", "ATENCION::Error con el ID de la Empresa!");
			return "redirect:/views/empresas/";
			
		}
		
		
		
		
		empresaService.borrar(idEmpresa);
		
		System.out.println("Empresa eliminada con éxito!");
		
		attribute.addFlashAttribute("warning", "Registro Eliminado con Éxito!");
		// TODO Auto-generated method stub
		return "redirect:/views/empresas/";
       }
	
	
}	
	












