package com.cdsg.device.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "repairlog")
public class RepairLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "device_id")
	private Device device;
	@Temporal(TemporalType.DATE)
	private Date inDate;
	private DeviceStatus statusIn;
	@Temporal(TemporalType.DATE)
	private Date outDate;
	private DeviceStatus statusOut;
	private String note;
	public RepairLog() {
		super();
	}
	public RepairLog(Long id, Device device, Date inDate, DeviceStatus statusIn, Date outDate, DeviceStatus statusOut,
			String note) {
		super();
		this.id = id;
		this.device = device;
		this.inDate = inDate;
		this.statusIn = statusIn;
		this.outDate = outDate;
		this.statusOut = statusOut;
		this.note = note;
	}
	public RepairLog(Device device, Date inDate, DeviceStatus statusIn, Date outDate, DeviceStatus statusOut,
			String note) {
		super();
		this.device = device;
		this.inDate = inDate;
		this.statusIn = statusIn;
		this.outDate = outDate;
		this.statusOut = statusOut;
		this.note = note;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public DeviceStatus getStatusIn() {
		return statusIn;
	}
	public void setStatusIn(DeviceStatus statusIn) {
		this.statusIn = statusIn;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public DeviceStatus getStatusOut() {
		return statusOut;
	}
	public void setStatusOut(DeviceStatus statusOut) {
		this.statusOut = statusOut;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
