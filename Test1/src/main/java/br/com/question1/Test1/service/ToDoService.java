package br.com.question1.Test1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.question1.Test1.entity.ToDo;
import br.com.question1.Test1.repository.ToDoRepository;
import lombok.Getter;
import lombok.Setter;

@Service
@Validated
@Getter
@Setter
public class ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;

	public List<ToDo> listAllToDo() {
		return (List<ToDo>) toDoRepository.findAll();
	}

	public ToDo findToDoById(int id) {
		ToDo toDo = toDoRepository.findById(id);
		if (toDoRepository.findById(id) != null) {
		}
		return toDo;

	}

	public ToDo insertToDo(ToDo toDo) {
		return toDoRepository.save(toDo);

	}

	public ToDo updateToDo(int id, ToDo newToDo) {
		ToDo toDo = this.toDoRepository.findById(id);
		toDo.setName(newToDo.getName());
		toDo.setIsComplete(newToDo.getIsComplete());
		return toDoRepository.save(toDo);
	}

	public void deleteToDoById(int id) {
		toDoRepository.deleteById(id);
	}

}
