package com.hemanth.vaadintodoapp.views;

import com.hemanth.vaadintodoapp.model.Todo;
import com.hemanth.vaadintodoapp.repository.TodoRepository;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class TodoView extends VerticalLayout {

    private final TodoRepository todoRepository;

    public TodoView(TodoRepository todoRepository){
        this.todoRepository = todoRepository;

        var task = new TextField();
        var button  = new Button("Add");
        var todos = new VerticalLayout();
        var deleteAll = new Button("Delete All");
        todos.setPadding(false);

        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        button.addClickListener(click ->{
            var todo = todoRepository.save(new Todo(task.getValue(),false));
            todos.add(createCheckBox(todo));
            task.clear();
        });

        deleteAll.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        deleteAll.addClickListener(click ->{
            todoRepository.deleteAll();
        });

        todoRepository.findAll().forEach(todo -> todos.add(createCheckBox(todo)));

        add(
                new H1("TODO"),
                new HorizontalLayout(task,button,deleteAll),
                todos
        );

    }

    private Component createCheckBox(Todo todo){
        return new Checkbox(todo.getTask(), todo.isDone(), e->{
            todo.setDone(e.getValue());
            todoRepository.save(todo);

        });
    }
}
