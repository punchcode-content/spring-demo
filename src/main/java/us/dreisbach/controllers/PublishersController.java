package us.dreisbach.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/{id}/")
	public String showPublisher(@PathVariable Integer id, Model model) {
		model.addAttribute("publisher", publisherService.getById(id));
		return "publishers/show";
	}
}
