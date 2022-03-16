package com.cdsg.device.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "devicetype")
public class DeviceType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50 , nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "deviceType")
	private List<Device> devices;
	
	public DeviceType() {
		super();
	}
	public DeviceType(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public DeviceType(String name) {
		super();
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	public DeviceType(Long id, String name, List<Device> devices) {
		super();
		this.id = id;
		this.name = name;
		this.devices = devices;
	}
	public DeviceType(String name, List<Device> devices) {
		super();
		this.name = name;
		this.devices = devices;
	}
	
	
	
}
