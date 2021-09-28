package com.lol.flexFinder.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "player_search")
public class PlayerSearch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_search_id")
	@JsonIgnore
	private long id;
	
	private String author;
	
//	@Column(name = "existing_roles")
//	@ElementCollection
//	public Set<SearchRole> existingRoles;
	
	@Enumerated(EnumType.ORDINAL)
	private SearchRole role;
	
	private String rankMin;
	
	private String rankMax;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM HH:mm")
	private Date createdDate;
	
	
}
