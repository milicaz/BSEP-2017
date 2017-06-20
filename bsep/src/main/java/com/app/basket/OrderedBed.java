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
import com.app.bed.Bed;

import lombok.Data;

@Data
@Entity
@Table(name = "ordered_bed")
public class OrderedBed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDERED_BED_ID")
	private Long id;
	
	@NotNull
	private Integer quantity;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "BED")
	private Bed bed;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="BED_STATUS")
	private FurnitureStatus bedStatus;

}
