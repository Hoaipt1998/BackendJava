package com.cdsg.device.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name = "device")
public class Device {
	@Id
	private String serialNo;
	@Column(length = 200 , nullable = false)
	private String name;
	@Temporal(TemporalType.DATE)
	private Date importDate;
	@Column(length = 200 , nullable = false)
	private String manufacturer;
	
	private DeviceStatus status;
	
	@ManyToOne
	@JoinColumn(name = "device_type_id")
	private DeviceType deviceType;
	
	@OneToMany(mappedBy = "device")
	
	private List<RepairLog> repairLogs;
	@Column(length = 200)
	
	private String photo;
	
	
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType device) {
		this.deviceType = device;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	

	public DeviceStatus getStatus() {
		return status;
	}

	public void setStatus(DeviceStatus status) {
		this.status = status;
	}

	public List<RepairLog> getRepairLogs() {
		return repairLogs;
	}

	public void setRepairLogs(List<RepairLog> repairLogs) {
		this.repairLogs = repairLogs;
	}

	public Device(String serialNo, String name, Date importDate, String manufacturer, DeviceStatus status,
			DeviceType device, List<RepairLog> repairLogs) {
		super();
		this.serialNo = serialNo;
		this.name = name;
		this.importDate = importDate;
		this.manufacturer = manufacturer;
		this.status = status;
		this.deviceType = device;
		this.repairLogs = repairLogs;
	}

	public Device() {
		super();
	}

	public Device(String serialNo, String name, Date importDate, String manufacturer, DeviceType deviceType) {
		super();
		this.serialNo = serialNo;
		this.name = name;
		this.importDate = importDate;
		this.manufacturer = manufacturer;
		this.deviceType = deviceType;
	}

	public RepairLog findRepairing() {
		for(RepairLog r:this.repairLogs) {
			if(r.getOutDate() == null) {
				return r;
			}
		}
		return null;
	}

	public Device(String serialNo, String name, Date importDate, String manufacturer, DeviceStatus status,
			DeviceType deviceType, List<RepairLog> repairLogs, String photo) {
		super();
		this.serialNo = serialNo;
		this.name = name;
		this.importDate = importDate;
		this.manufacturer = manufacturer;
		this.status = status;
		this.deviceType = deviceType;
		this.repairLogs = repairLogs;
		this.photo = photo;
	}

	public Device(String name, Date importDate, String manufacturer, DeviceStatus status, DeviceType deviceType,
			List<RepairLog> repairLogs, String photo) {
		super();
		this.name = name;
		this.importDate = importDate;
		this.manufacturer = manufacturer;
		this.status = status;
		this.deviceType = deviceType;
		this.repairLogs = repairLogs;
		this.photo = photo;
	}
	
	
}
