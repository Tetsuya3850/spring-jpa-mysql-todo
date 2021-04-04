package com.example.todo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("")
    Todo saveTodo(
            @Valid @RequestBody TodoPayload todoPayload
    ) {
        return todoService.saveTodo(todoPayload);
    }

    @GetMapping("")
    List<Todo> findAllTodos() {
        return todoService.findAllTodos();
    }

    @DeleteMapping("/{todoId}")
    void deleteTodoById(
            @PathVariable Long todoId
    ) {
        todoService.deleteTodoById(todoId);
    }

}
