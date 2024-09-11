package com.halcyon.todo_app.controller;

import com.halcyon.todo_app.model.TodoItem;
import com.halcyon.todo_app.service.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoFormController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-item")
    public String showCreateForm() {
        return "new-item";
    }

    @PostMapping("/todo")
    public String createItem(@Valid TodoItem todoItem, BindingResult result, Model model) {

        TodoItem item = new TodoItem();
        item.setDescription(todoItem.getDescription());
        item.setComplete(todoItem.isComplete());

        todoItemService.save(todoItem);
        return "redirect:/";
    }
}
