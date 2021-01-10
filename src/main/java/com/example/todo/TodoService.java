package com.example.todo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo saveTodo(TodoPayload todoPayload) {
        Todo newTodo = new Todo(
                todoPayload.getText(),
                System.currentTimeMillis() / 1000
        );
        return todoRepository.save(newTodo);
    }

    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
