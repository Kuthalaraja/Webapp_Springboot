package com.eweb.MyWebApp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eweb.MyWebApp.dao.AlienRepo;

//@Controller  //mvc
@RestController        //rest
public class HomeController {
	
	@Autowired
	AlienRepo repo;
//                                      MVC
	@RequestMapping("/")
	public String home() {
		
		return "form";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien a) {
		repo.save(a);
		return "form";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int a) {
		ModelAndView mv = new ModelAndView("display");
		Alien a1 = repo.findById(a).orElse(new Alien());
		mv.addObject("alien",a1);
		return mv;
	}
    
	@RequestMapping(value = "/updateAlien")
	public ModelAndView updateAlien(@RequestParam int id, @RequestParam String name) {
	    ModelAndView mv = new ModelAndView("display");

	    Alien alien = repo.findById(id).orElse(new Alien());

	    alien.setAname(name);

	    repo.save(alien);

	    mv.addObject("alien", alien);
	    return mv;
	}
	
	@RequestMapping(value = "/deleteAlien")
	public ModelAndView deleteAlien(@RequestParam int a) {
	    ModelAndView mv = new ModelAndView("display");

	    repo.deleteById(a);

	    mv.addObject("alien", "Alien with ID " + a + " has been deleted.");
	    return mv;
	}
//                                      REST
	@GetMapping("/aliens")
	//@RequestMapping(path="/aliens", produces={"application/json"})
	//@ResponseBody
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@RequestMapping("/alien/{id}")
//	@ResponseBody
	public Optional<Alien> getAli(@PathVariable("id") int id) {
		return repo.findById(id);
	}
	
	@PostMapping("/alienadd")
	public Alien addAli(@RequestBody Alien a) {
		repo.save(a);
		return a;
	}
	
	@PutMapping("/updatealien")
	public Alien putAli(@RequestBody Alien a) {
		repo.save(a);
		return a;
	}
	
	@DeleteMapping("/deleteali/{id}")
	public String deleteAli(@PathVariable("id") int id) {
		Alien a = repo.getOne(id);
		repo.delete(a);
		return "deleted";
	}
}
