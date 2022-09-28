package br.com.question1.Test1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.question1.Test1.entity.ToDo;

@RepositoryRestResource(collectionResourceRel = "toDo", path = "toDo")
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

	public ToDo findById(int id);
}
