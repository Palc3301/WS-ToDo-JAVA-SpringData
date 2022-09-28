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
	public ToDo getToDo(@PathVariable int id) {
		ToDo toDo = service.findById(id);
		return toDo;
	}

	@PostMapping
	public ResponseEntity insertToDo(@RequestBody ToDo newToDo) {

		try {
			service.insertToDo(newToDo);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping
	public ResponseEntity<ToDo> updateToDo(@PathVariable ToDo id) {
		ToDo newToDo = service.updateToDo(id);
		return new ResponseEntity<ToDo>(newToDo, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ToDo> deleteToDoById(@RequestBody int id) {
		service.deleteToDoById(id);
		return new ResponseEntity<ToDo>(HttpStatus.NO_CONTENT);
	}
}
