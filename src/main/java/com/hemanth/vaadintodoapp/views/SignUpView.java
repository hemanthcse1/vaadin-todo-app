package com.hemanth.vaadintodoapp.views;

import com.hemanth.vaadintodoapp.main.MainLayout;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.textfield.TextField;


@Route(value = "signup", layout = MainLayout.class)
@PageTitle("Sign Up | My Application")
public class SignUpView extends VerticalLayout {

    public SignUpView() {
        // Container layout for centering the form
        VerticalLayout containerLayout = new VerticalLayout();
        containerLayout.setSizeFull();
        containerLayout.setAlignItems(Alignment.CENTER);
        containerLayout.setJustifyContentMode(JustifyContentMode.CENTER);

        // Form layout for the input fields
        FormLayout formLayout = new FormLayout();
        formLayout.setWidth("auto");

        // Create form fields
        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last Name");
        EmailField email = new EmailField("Email");
        TextField phoneNumber = new TextField("Phone Number");
        TextField designation = new TextField("Designation");
        PasswordField password = new PasswordField("Password");

        // ComboBox for gender selection
        ComboBox<String> gender = new ComboBox<>("Gender");
        gender.setItems("Male", "Female", "Other");

        // Sign Up button
        Button signUpButton = new Button("Sign Up");

        // Add fields and button to the form layout
        formLayout.add(firstName, lastName, email, phoneNumber, designation, password, gender);

        // Add formLayout and signUpButton to the container layout
        containerLayout.add(formLayout, signUpButton);

        // Add the container layout to the main view
        add(containerLayout);

        // Center the form and button in the container layout
        formLayout.getStyle().set("margin", "0 auto");
        signUpButton.getStyle().set("margin", "0 auto");
    }
}
