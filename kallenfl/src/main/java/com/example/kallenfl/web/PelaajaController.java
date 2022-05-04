package com.example.kallenfl.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.kallenfl.domain.CategoryRepository;
import com.example.kallenfl.domain.Pelaaja;
import com.example.kallenfl.domain.PelaajaRepository;
import com.example.kallenfl.domain.PelaajaRepositoryHeitetty;
import com.example.kallenfl.domain.PelaajaRepositoryJuostu;



@Controller
public class PelaajaController {
	@Autowired
	private PelaajaRepository repository; 
	@Autowired
	private PelaajaRepositoryHeitetty hrepository; 
	@Autowired
	private PelaajaRepositoryJuostu jrepository; 
	@Autowired
	private CategoryRepository crepository;

	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	
    @RequestMapping(value="/pelaajalista")
    public String pelaajaLista(Model model) {	
        model.addAttribute("pelaajat", repository.findAll());
        return "pelaajalista";
    }
    
    @RequestMapping(value="/vastaanotetut")
    public String vastaanOtetut(Model model) {	
        model.addAttribute("pelaajat", repository.findAll());
        return "vastaanotetut";
    }
    @RequestMapping(value="/juostu")
    public String juostut(Model model) {	
        model.addAttribute("pelaajat", repository.findAll());
        return "juostu";
    }
    @RequestMapping(value="/heitetty")
    public String heitetyt(Model model) {	
        model.addAttribute("pelaajat", repository.findAll());
        return "heitetty";
    }
    
    @RequestMapping(value="/pelaajat", method = RequestMethod.GET)
    public @ResponseBody List<Pelaaja> pelaajaListaRest() {	
        return (List<Pelaaja>) repository.findAll();
    }    
    

    @RequestMapping(value="/pelaaja/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Pelaaja> findPelaajaRest(@PathVariable("id") Long pelaajaId) {	
    	return repository.findById(pelaajaId);
    }       
    
    @RequestMapping(value = "/add")
    public String addPelaaja(Model model){
     model.addAttribute("pelaaja", new Pelaaja ());
     model.addAttribute("categories", crepository.findAll());
     return "addpelaaja";
    }
    @RequestMapping(value = "/addjuostu")
    public String addPelaajaJuostu(Model model){
     model.addAttribute("pelaaja", new Pelaaja ());
     model.addAttribute("categories", crepository.findAll());
     return "addpelaajajuostu";
    }
    @RequestMapping(value = "/addheitetty")
    public String addPelaajaHeitetty(Model model){
     model.addAttribute("pelaaja", new Pelaaja ());
     model.addAttribute("categories", crepository.findAll());
     return "addpelaajaheitetty";
    }
    
    
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Pelaaja pelaaja){
     repository.save(pelaaja);
     return "redirect:/vastaanotetut";
    }
    
    @RequestMapping(value = "/savejuostu", method = RequestMethod.POST)
    public String saveJuostu(Pelaaja pelaaja){
     jrepository.save(pelaaja);
     return "redirect:/juostu";
    }
    
    @RequestMapping(value = "/saveheitetty", method = RequestMethod.POST)
    public String saveHeitetty(Pelaaja pelaaja){
     hrepository.save(pelaaja);
     return "redirect:/heitetty";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePelaaja(@PathVariable("id") Long pelaajaId, Model model) {
     repository.deleteById(pelaajaId);
     return "redirect:/pelaajalista";
    }
    @RequestMapping("/edit/{id}")
    public String editPelaaja(@PathVariable("id") Long pelaajaId, Model model) {
        model.addAttribute("pelaaja", repository.findById(pelaajaId));
        model.addAttribute("categories", crepository.findAll());
        return "editpelaaja.html";
    }
    
    @RequestMapping("/editjuostu/{id}")
    public String editPelaajaJuostu(@PathVariable("id") Long pelaajaId, Model model) {
        model.addAttribute("pelaaja", repository.findById(pelaajaId));
        model.addAttribute("categories", crepository.findAll());
        return "editpelaajajuostu.html";
    }
    @RequestMapping("/editheitetty/{id}")
    public String editPelaajaHeitetty(@PathVariable("id") Long pelaajaId, Model model) {
        model.addAttribute("pelaaja", repository.findById(pelaajaId));
        model.addAttribute("categories", crepository.findAll());
        return "editpelaajaheitetty.html";
    }
    
    
    
}