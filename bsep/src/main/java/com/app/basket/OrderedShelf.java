package com.app.basket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.app.FurnitureStatus;
import com.app.shelf.Shelf;

import lombok.Data;

@Data
@Entity
@Table(name = "ordered_shelf")
public class OrderedShelf {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDERED_SHELF_ID")
	private Long id;
	
	@NotNull
	private Integer quantity;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "SHELF")
	private Shelf shelf;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="SHELF_STATUS")
	private FurnitureStatus shelfStatus;
}
