package com.todo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.app.entity.Todo;
import com.todo.app.mapper.TodoMapper;

@Controller
public class TodoController {
	
	//TodoMapperをインスタンス管理
	@Autowired
	TodoMapper todoMapper;
	
	@RequestMapping(value="/")
	public String index(Model model) {
		//List<Todo> list = todoMapper.selectAll();
		//todomapper.-メソッド呼び出し
		List<Todo> list = todoMapper.selectIncomplete();
		List<Todo> donelist = todoMapper.selectComplete();
		//リストに名前
		model.addAttribute("todos",list);
		model.addAttribute("donetodos",donelist);
		return"index";
	}
	
	
	@RequestMapping(value="/add")
	//Viewから渡される値をMapperのaddに追加
	public String add(Todo todo) {
		//todomapper.-メソッド呼び出し
		todoMapper.add(todo);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/update")
	//上記同様
	public String update(Todo todo) {
		todoMapper.update(todo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete")
	public String delete() {
		todoMapper.delete();
		return "redirect:/";
	}

}
