package com.cdsg.device.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdsg.device.model.Device;
import com.cdsg.device.model.RepairLog;

public interface RepairLogRepository extends JpaRepository<RepairLog, Long>{
	 @Query("select repairLog.device from RepairLog repairLog where "+""
	 		+ "repairLog.device.serialNo =?1 and repairLog.outDate is null")
	  public Device findRepairingDevice(String serialNo);
}
