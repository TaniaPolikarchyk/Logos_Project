package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.lviv.lgs.service.StudentsService;

@Controller
public class StudentsController {
	@Autowired
	@Qualifier("studentsService")
	private StudentsService service;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String listAuthors(Model model) {
		model.addAttribute("students",
				service.viewAllStudents());
		return "students";
	}
}
