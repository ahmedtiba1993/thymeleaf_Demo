package com.jpa.relationships.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
