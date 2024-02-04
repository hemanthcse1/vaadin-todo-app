package com.hemanth.vaadintodoapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "task")
    private String task;

    @Column(name = "isdone")
    private boolean isDone;

    public Todo(String task, boolean isDone) {
        this.task = task;
        this.isDone = isDone;
    }
}
