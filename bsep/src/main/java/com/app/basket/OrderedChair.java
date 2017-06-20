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
import com.app.chair.Chair;

import lombok.Data;

@Data
@Entity
@Table(name = "ordered_chair")
public class OrderedChair {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDERED_CHAIR_ID")
	private Long id;
	
	@NotNull
	private Integer quantity;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "CHAIR")
	private Chair chair;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="CHAIR_STATUS")
	private FurnitureStatus chairStatus;

}
