package com.cdsg.device.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cdsg.device.modeldto.*;

import com.cdsg.device.model.Device;

public interface DeviceRepository extends JpaRepository<Device, String>{
	@Query("SELECT new com.cdsg.device.modeldto.DeviceInfo(r.device.serialNo, "+""
			+ "r.device.name, count(r.device)) "+
			"FROM RepairLog r group by r.device ")
	public List<DeviceInfo> getDeviceInfo();
	
	@Query("select d.serialNo, d.name from Device d")
	public List<Object[]> getShortDevice();
	
	@Query(value = "select name, status from device where serial_no = ?1", nativeQuery = true)
    public List<Object[]> findDeviceSerial(String serialNo);
}
