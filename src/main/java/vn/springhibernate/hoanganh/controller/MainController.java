package vn.springhibernate.hoanganh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.springhibernate.hoanganh.model.LearningEnglish;
import vn.springhibernate.hoanganh.service.LearningEnglishService;

@Controller
public class MainController {

	@Autowired
	private LearningEnglishService eService;
	
	@RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
	public String index(Model model) {
		List<LearningEnglish> leason = eService.finByChaId("0");
		model.addAttribute("chapter",leason); 
		return "index";
	}
	
	@RequestMapping(value = {"/unit/{id}"}, method = RequestMethod.GET)
	public String unit(Model model, @PathVariable String id) {
		List<LearningEnglish> leason = eService.finByChaId(id);
		model.addAttribute("unit",leason); 
		return "index";
	}

	@RequestMapping(value = {"/leason/{id}"}, method = RequestMethod.GET)
	public String leason(Model model, @PathVariable String id) {
		List<LearningEnglish> leason = eService.finByChaId(id);
		model.addAttribute("state",leason.get(0).getChaid());
		model.addAttribute("leason",leason); 
		return "index";
	}
	
	@RequestMapping(value = "/leason/handleClick")
	public void handleClick(Model model,
				@RequestParam("id") String id, HttpServletResponse response) throws IOException{
		LearningEnglish leason = eService.findById(id);
		try {
			eService.updateLearningEnglish(leason);
		}catch(Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	@RequestMapping(value = {"/leason/{id}/{state}"}, method = RequestMethod.GET)
	public String findByChaIdAndState(Model model, @PathVariable String id, @PathVariable String state) {
		List<LearningEnglish> leason = eService.findByChaIdAndState(id, state);
		if(leason.size() != 0) {
			model.addAttribute("state",leason.get(0).getChaid());
		}else {
			model.addAttribute("state",id);
		}
		model.addAttribute("leason",leason); 
		return "index";
	}	
}
