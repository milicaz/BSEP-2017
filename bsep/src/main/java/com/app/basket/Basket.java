package com.app.basket;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.user.User;

import lombok.Data;

@Data
@Entity
@Table(name = "basket_list")
public class Basket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BASKET_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "USER")
	private User user;
	
	@OneToMany
	private List<OrderedBed> beds;
	
	@OneToMany
	private List<OrderedChair> chairs;
	
	@OneToMany
	private List<OrderedShelf> shelfs;
}
