package com.hemanth.vaadintodoapp.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;

public class MainLayout extends AppLayout {

    public MainLayout() {

        HorizontalLayout toolbar = new HorizontalLayout();
        toolbar.setWidthFull();
        toolbar.setPadding(true);
        toolbar.setAlignItems(FlexComponent.Alignment.CENTER);

        toolbar.addClassName("toolbar");


        Image logo = new Image("images/logo.png", "My Application Logo");
        logo.setHeight("64px");
        H1 logoText = new H1("Welcome");
        HorizontalLayout logoLayout = new HorizontalLayout(logo, logoText);
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);


     /*   Anchor signUpLink = new Anchor("signup", "Sign Up");
        Button signUpButton = new Button(signUpLink);
        signUpButton.getElement().setAttribute("theme", "tertiary");*/

        // Add components to the toolbar
        toolbar.add(logoLayout);
     //   toolbar.add(signUpButton);
        toolbar.expand(logoLayout); // This will push the signUpButton to the right
        // Create a HorizontalLayout for the toolbar
       // HorizontalLayout toolbar = new HorizontalLayout();

        // Add a logo and title
     /*   Image logo = new Image("images/logo.png", "Logo");
        logo.setHeight("44px");
        H1 title = new H1("My Application");*/

        H1 title = new H1("My Application");

        // Add navigation buttons or links
        Anchor homeLink = new Anchor("/", "Home");
        Anchor loginLink = new Anchor("/signup", "Sign Up");

        // Add components to the toolbar
        toolbar.add(logo, homeLink, loginLink);

        // Add the toolbar to the main layout
        addToNavbar(toolbar);
    }
}
