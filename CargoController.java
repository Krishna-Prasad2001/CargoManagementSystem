package com.amdocs.CargoManagementSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.CargoManagementSystem.entity.Cargo;
import com.amdocs.CargoManagementSystem.serviceimpl.CargoServiceImpl;

@Controller
public class CargoController {

	@Autowired
	private CargoServiceImpl CargoService;
	
	@RequestMapping("/")
	public String loadForm(Model model)
	{
		Cargo cargo=new Cargo();
		model.addAttribute("cargo", cargo);
		
		return "cargo";
	}
	
	@RequestMapping("/insert")
	public String handleCargoForm(@ModelAttribute("cargo")Cargo cargo,Model model)
	{
		
		//interact to service layer
		boolean saveCargoId = CargoService.saveCargoId(cargo);
		
		String msg="";
		
		if(saveCargoId)
			msg="Data Inserted SuccessFully";
		else
			msg="Data Not Inserted SuccessFully";
		
		model.addAttribute("msg", msg);
		return "cargo";
	}
	
	
	@RequestMapping("/viewAll")
	public String viewAllCargo(Model model)
	{
		//fetch the data from the database ,can interact service layer
		List<Cargo> allCargo = CargoService.viewAllCargo();
		model.addAttribute("cargo", allCargo);
		return "view";
	}
	
	@RequestMapping("/deleteCargo")
	public String deleteCargoId(@RequestParam("id") int id)
	{
		boolean flag = CargoService.deleteCargoId(id);
		
		if(flag)
		return "redirect:/viewAll";
		else
		return "redirect:/viewAll";
	}
	
	@RequestMapping("/editCargo")
	public String editCargo(@RequestParam("id")   int id,Model model)
	{
		Cargo cargo = CargoService.getCargoId(id);
		
		model.addAttribute("cargo", cargo);
		return "editCargo";
	}
	
	@RequestMapping("/update")
	public String updateCargo(Cargo cargo)
	{
		boolean updateCargo = CargoService.updateCargo(cargo);
		
		return "redirect:/viewAll";

	}
	
}