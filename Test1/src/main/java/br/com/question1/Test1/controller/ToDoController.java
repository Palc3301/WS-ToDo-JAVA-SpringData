package br.com.question1.Test1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.question1.Test1.entity.ToDo;
import br.com.question1.Test1.service.ToDoService;

@RestController
@RequestMapping("/toDo")
public class ToDoController {

	@Autowired
	private ToDoService service;

	@GetMapping
	public ResponseEntity<List<ToDo>> listAllToDo() {

		ResponseEntity<List<ToDo>> check;
		List<ToDo> allToDo = service.listAllToDo();

		if (allToDo != null && allToDo.isEmpty()) {
			check = new ResponseEntity<List<ToDo>>(HttpStatus.NO_CONTENT);
		} else {
			check = new ResponseEntity<List<ToDo>>(allToDo, HttpStatus.OK);
		}
		return check;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ToDo> getToDo(@PathVariable int id) {
		ToDo toDo = service.findToDoById(id);
		return new ResponseEntity<ToDo>(toDo,HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<ToDo> insertToDo(@RequestBody ToDo toDo) {
		service.insertToDo(toDo);

		return new ResponseEntity<ToDo>(toDo, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ToDo> updateToDo(@PathVariable int id, @RequestBody ToDo toDoEntrada) {
		ToDo toDo = service.updateToDo(id, toDoEntrada);
		return new ResponseEntity<ToDo>(toDo, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ToDo> deleteToDoById(@PathVariable int id) {
		service.deleteToDoById(id);
		return new ResponseEntity<ToDo>(HttpStatus.NO_CONTENT);
	}
}









