package com.jpa.relationships.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jpa.relationships.Repository.PatientRepository;
import com.jpa.relationships.models.Patient;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PatientController {
	
	private PatientRepository patientRepository;
	
	@GetMapping(path="/index")
	public String patients(Model model ,
			@RequestParam(name="page",defaultValue = "0") int page ,
			@RequestParam(name="size",defaultValue = "5")  int size,
			@RequestParam(name="keyword",defaultValue = "")  String keyword){
		Page<Patient> pagePatients=patientRepository.findByNomContains(keyword,PageRequest.of(page, size));
		model.addAttribute("listPcontroller",pagePatients);
		model.addAttribute("page",new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", keyword);
		return "patients";
	}
	
	@GetMapping(path="/index2")
	public String patientsV1(Model model ,
			@RequestParam(name="page",defaultValue = "0") int page ,
			@RequestParam(name="size",defaultValue = "5")  int size) {
		Page<Patient> pagePatients=patientRepository.findAll(PageRequest.of(page, size));
		model.addAttribute("listPcontroller",pagePatients);
		model.addAttribute("page",new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage", page);
		return "patients";
	}
	
	@GetMapping(path="/")
	public String defaut() {
		return "redirect:/index";
	}
	
	@GetMapping(path="/delete")
	public String delete(Long id , String keyword , int page) {
		patientRepository.deleteById(id);
		return "redirect:/index?page="+page+"&keyword="+keyword;
	}
	
	@GetMapping(path="/patients")
	@ResponseBody
	public List<Patient> findAll(){
		return patientRepository.findAll();
	}
	
	@GetMapping("/formAdd")
	public String formAdd(Model model){
		model.addAttribute("patient",new Patient());
		return "formAdd";
	}
	
	@PostMapping(path="/save")
	public String save(Model model, @Valid Patient patient , BindingResult bindingResult , 
			@RequestParam(name="page",defaultValue = "0") int page ,
			@RequestParam(name="keyword",defaultValue = "")  String keyword ,
			RedirectAttributes redirAttrs){
		if(bindingResult.hasErrors()) {
			return "formAdd";
		}
		/*
		  if (!everythingOkay()) {
        		redirAttrs.addFlashAttribute("error", "The error XYZ occurred.");
        	return "redirect:/settings/";
    		}
		 */
		patientRepository.save(patient);
	    redirAttrs.addFlashAttribute("success", "Ajouté avec succès");
		return "redirect:/index?page="+page+"&keyword="+keyword;
	}
	
	@GetMapping("/formEdit")
	public String formEdit(Model model,Long id , String keyword , int page){

		Patient patient=patientRepository.findById(id).orElse(null);
		if(patient==null) {
			throw new RuntimeException("Patient introvable");
		}
		model.addAttribute("patient",patient);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		
		return "formEdit";
	}
	

}
