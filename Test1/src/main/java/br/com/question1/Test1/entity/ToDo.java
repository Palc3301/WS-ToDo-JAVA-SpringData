package br.com.question1.Test1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter @Setter @NoArgsConstructor
public class ToDo {
	
	@Id @GeneratedValue
	private int id;
	
	@Column (length = 50)
	private String name;
	
	@Column (length = 50)
	private Boolean isComplete;
}
