package us.dreisbach.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import us.dreisbach.entities.Widget;
import us.dreisbach.services.WidgetService;

@RequestMapping("/examples")
@Controller
public class ExampleController {
	private WidgetService widgetService;

	@RequestMapping("string")
	@ResponseBody
	public String stringExample() {
		return "This is a test";
	}

	@RequestMapping("widget")
	@ResponseBody
	public Widget widgetExample() {
		return widgetService.getWidget();
	}

	@Autowired
	public void setWidgetService(WidgetService widgetService) {
		this.widgetService = widgetService;
	}

}
