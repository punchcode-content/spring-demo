package us.dreisbach.services;

import org.springframework.stereotype.Service;

import us.dreisbach.entities.Widget;

@Service
public class WidgetService {
	public Widget getWidget() {
		Widget w = new Widget();
		w.setId(1);
		w.setName("Clinton");
		return w;
	}
}
