package us.dreisbach.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import us.dreisbach.entities.Publisher;
import us.dreisbach.services.PublisherService;

@RequestMapping("/publishers")
@Controller
public class PublishersController {
	private PublisherService publisherService;

	@Autowired
	public void setPublisherService(PublisherService service) {
		this.publisherService = service;
	}

	@RequestMapping("/")
	public String listPublishers(Model model) {
		model.addAttribute("publishers", publisherService.listAll());
		return "publishers/list";
	}

	@RequestMapping("/test/")
	@ResponseBody
	public String test() {

		return "This is a test";
	}

	@RequestMapping("/new/")
	public String newPublisher(Model model) {
		model.addAttribute("publisher", new Publisher());
		return "publishers/form";
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public String savePublisher(Publisher publisher, Model model) {
		publisherService.saveOrUpdate(publisher);
		return "redirect:/publishers/";
	}

	@RequestMapping("/{id}/")
	@ResponseBody
	public Publisher showPublisher(@PathVariable Integer id, Model model) {
		// model.addAttribute("publisher", publisherService.getById(id));
		return publisherService.getById(id);
		// return "publishers/form";
	}

	@RequestMapping("/{id}/delete")
	public String deletePublisher(@PathVariable Integer id) {
		publisherService.delete(id);
		return "redirect:/publishers/";
	}
}
