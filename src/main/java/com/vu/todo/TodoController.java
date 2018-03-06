package com.vu.todo;

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

import com.vu.model.Todo;
import com.vu.todo.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	// Request scope
	/*
	 * public String showLoginPage(@RequestParam String name, ModelMap model) {
	 * model.addAttribute("name",name);
	 */
	// session scope
	public String listTodos(ModelMap model) {
		String user = (String) model.get("name");
		model.addAttribute("todos", todoService.retrieveTodos(user));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	/*public String showTodoPage() {
		return "todo";
	}*/
	
	//Binding with commandName
	public String showTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0,"Harshini","",new Date(),false));
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	// Regular binding with form data
	/*
	 * public String addTodo(@RequestParam String desc, ModelMap model) {
	 * todoService.addTodo("in28Minutes", desc, new Date(), false); model.clear();
	 * return "redirect:list-todos"; }
	 */
	
	//Binding with commandName
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo("Harshini",todo.getDesc(), new Date(), false);
		model.clear();
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		todoService.deleteTodo(id);
		model.clear();
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodo(ModelMap model, @RequestParam int id) {
		Todo todo = todoService.retreiveTodo(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser((String)model.get("name"));
		todoService.updateTodo(todo);
		model.clear();
		return "redirect:list-todos";
	}

}
