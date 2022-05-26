package com.rajagupta.todoListApp.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rajagupta.todoListApp.model.Todo;
import com.rajagupta.todoListApp.service.TodoService;


@Controller
@SessionAttributes("username")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String showTodosList(ModelMap map) {
		String username = getLoggedInUserName(map);
		map.put("todos", todoService.retrieveTodos(username));
		return "list-todos";
	}

	private String getLoggedInUserName(ModelMap map) {
		return (String) map.get("username");
	}

	@RequestMapping(value="/add-todo", method=RequestMethod.GET)
	public String showAddTodo(ModelMap map) {	
		map.addAttribute("todo", new Todo(0,getLoggedInUserName(map), "", new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method=RequestMethod.POST)
	public String addTodoList(ModelMap map, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo(getLoggedInUserName(map), todo.getDesc(), new Date(), false);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.retrieveTodo(id);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}
		
		todo.setUsername(getLoggedInUserName(model));
		todo.setTargetDate(new Date());
		todoService.updateTodo(todo);

		return "redirect:/list-todos";
	}

}
