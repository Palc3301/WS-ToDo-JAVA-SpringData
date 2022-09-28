package br.com.question1.Test1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.question1.Test1.entity.ToDo;
import br.com.question1.Test1.exceptions.ToDoAlreadyExistsException;
import br.com.question1.Test1.repository.ToDoRepository;
import lombok.Getter;
import lombok.Setter;

@Service
@Validated
@Getter
@Setter
public class ToDoService {

	@Autowired
	private ToDoRepository repository;

	public List<ToDo> listAllToDo() {
		return (List<ToDo>) repository.findAll();
	}

	public ToDo findById(int id) {
		return repository.findById(id);

	}

	public ToDo insertToDo(ToDo toDo) throws ToDoAlreadyExistsException {

		if (toDo.equals(null)) {
			return repository.save(toDo);
		}

		throw new ToDoAlreadyExistsException();
	}

	public ToDo updateToDo(ToDo newToDo) {

		ToDo toDo = repository.findById(newToDo.getId());
		toDo.setName(newToDo.getName());
		toDo.setIsComplete(newToDo.getIsComplete());
		return repository.save(toDo);
	}

	public void deleteToDoById(int id) {
		repository.deleteById(id);
	}

}
