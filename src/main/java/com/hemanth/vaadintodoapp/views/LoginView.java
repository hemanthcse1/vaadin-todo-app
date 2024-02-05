package com.hemanth.vaadintodoapp.views;

import com.hemanth.vaadintodoapp.main.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "login", layout = MainLayout.class)
@PageTitle("Login | My Application")
@CssImport("./styles/styles.css")
public class LoginView extends VerticalLayout {

    public LoginView() {
        setSizeFull();



        // Create a LoginForm component
        LoginForm loginForm = new LoginForm();
        loginForm.setAction("login"); // Set the login URL

        // Login event listener
        loginForm.addLoginListener(e -> {
            boolean isAuthenticated = authenticate(e.getUsername(), e.getPassword());
            if (isAuthenticated) {
                // Navigate to the main view
                loginForm.getUI().ifPresent(ui -> ui.navigate("main"));
            } else {
                loginForm.setError(true); // Show an error message
            }
        });

        // Assemble the view
        VerticalLayout formLayout = new VerticalLayout(new H1("Welcome Back"), loginForm);
        formLayout.setSizeFull();
        formLayout.setAlignItems(Alignment.CENTER);
        formLayout.setJustifyContentMode(JustifyContentMode.CENTER);

        // Add toolbar and form layout to the main layout
        add(formLayout);
        setAlignItems(Alignment.STRETCH);
    }

    private boolean authenticate(String username, String password) {
        // Implement your authentication logic here
        // For demonstration purposes, the credentials are hardcoded
        return "user".equals(username) && "password123".equals(password);
    }
}
