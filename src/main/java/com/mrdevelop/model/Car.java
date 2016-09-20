package com.mrdevelop.model;

import io.searchbox.annotations.JestId;

public class Car {
	
	@JestId
	private String id;
	
	private String name;
	private String version;
	private String ceroToSixty;
	
	@Override
	public String toString(){
		return "id: " + id +", name: " + name + ", version: " + version ;  
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCeroToSixty() {
		return ceroToSixty;
	}
	public void setCeroToSixty(String ceroToSixty) {
		this.ceroToSixty = ceroToSixty;
	}
	
	

}
