package com.rajagupta.todoListApp.service;

import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rajagupta.todoListApp.model.Todo;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "test", "Learn to use Adobe Photoshop", new Date(),
                false));
        todos.add(new Todo(2, "test", "Drop my laundry", new Date(), false));
        todos.add(new Todo(3, "test", "Call Tomas", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String username) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUsername().equals(username)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
    
    public Todo retrieveTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}

    public void addTodo(String username, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, username, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}