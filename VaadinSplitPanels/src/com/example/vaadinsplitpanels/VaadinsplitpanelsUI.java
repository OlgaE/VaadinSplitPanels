package com.example.vaadinsplitpanels;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.server.FileResource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

@SuppressWarnings("serial")
@Theme("vaadinsplitpanels")
public class VaadinsplitpanelsUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = VaadinsplitpanelsUI.class)
	public static class Servlet extends VaadinServlet {
	}

	File file = new File("\\Olga\\tmp");
	FilesystemContainer docs = new FilesystemContainer(file);
	ComboBox boxContent = new ComboBox("Documents", docs);
	Label docView = new Label("File content:",ContentMode.TEXT);
	
	Label label1 = new Label("A horizontal split panel contains only two components and lays them horizontally.");
	Label label2 = new Label("***");
	Label label3 = new Label("Each component can be a layout, which has many components inside itself..");
	Label imageLabel = new Label("And here is an image:");
	
	@Override
	protected void init(VaadinRequest request) {
		 
		// Have a horizontal split panel as its content
		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		hsplit.setSplitPosition(75, Sizeable.UNITS_PERCENTAGE);
		setContent(hsplit);
		 
		// Put a layout component in the left panel
		VerticalLayout layout = new VerticalLayout();
		hsplit.addComponent(layout);
		
		layout.addComponent(label1);
		layout.addComponent(label2);
		layout.addComponent(label3);
		layout.addComponent(boxContent);
		
		// Image:
		// Find the application directory
		String basepath = VaadinService.getCurrent()
		                  .getBaseDirectory().getAbsolutePath();

		// Image as a file resource
		FileResource resource = new FileResource(new File(basepath +
		                        "/WEB-INF/images/img26.jpg"));

		// Show the image in the application
		Image image = new Image("Image from \\WEB-INF\\images folder:", resource);
		imageLabel.setStyleName("textstyle");
		layout.addComponent(imageLabel);
		layout.addComponent(image);
		 
		// Put a vertical split panel in the right panel
		VerticalSplitPanel vsplit = new VerticalSplitPanel();
		hsplit.setSecondComponent(vsplit);
		 
		// Put other components in the right panel
		vsplit.addComponent(new Label("Here's the upper panel"));
		vsplit.addComponent(new Label("Here's the lower panel"));
	}
}