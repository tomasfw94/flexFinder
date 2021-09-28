package com.lol.flexFinder.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public enum SearchRole {

	TOP(1L, "Top"),
	MID(2L, "Mid"),
	ADC(3L, "ADC"),
	SUPP(4L, "Support"),
	JUNGLE(5L, "Jungla");

	@Id
	@Column(name = "role_id")
	private long roleID;
	
	private String labelUI;
	
	SearchRole(long id, String labelUI) {
		this.roleID = id;
		this.labelUI = labelUI;
	}
	
	
	public static List<String> getValuesForUI(){
		return Stream.of(SearchRole.values())
				.map(SearchRole::getLabelUI)
				.collect(Collectors.toList());
	}


	public long getRoleID() {
		return roleID;
	}


	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}


	public String getLabelUI() {
		return labelUI;
	}


	public void setLabelUI(String labelUI) {
		this.labelUI = labelUI;
	}
	
	
	
	
}
