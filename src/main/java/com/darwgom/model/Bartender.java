package com.darwgom.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bartender implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String pilaVasos;
	private static final long serialVersionUID = 1L;
}
