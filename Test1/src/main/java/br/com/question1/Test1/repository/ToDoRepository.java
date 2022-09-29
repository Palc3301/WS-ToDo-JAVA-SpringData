package br.com.question1.Test1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.question1.Test1.entity.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

	 ToDo findById(int id);
}
