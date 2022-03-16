package com.cdsg.device.modeldto;

public class DeviceInfo {
	private String serialNo;
	private String name;
	private long numRepair;
	public DeviceInfo() {
		super();
	}
	public DeviceInfo(String serialNo, String name, long numRepair) {
		super();
		this.serialNo = serialNo;
		this.name = name;
		this.numRepair = numRepair;
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
	public long getNumRepair() {
		return numRepair;
	}
	public void setNumRepair(long numRepair) {
		this.numRepair = numRepair;
	}
	@Override
	public String toString() {
		return this.serialNo + " " + this.name + " " + this.numRepair;
	}
	
}
