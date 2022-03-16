package com.cdsg.device.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsg.device.dao.DeviceRepository;
import com.cdsg.device.model.Device;
import com.cdsg.device.modeldto.DeviceInfo;
@Service
@Transactional
public class DeviceService {
	   @Autowired
	    private DeviceRepository repo;
	     
	    public List<Device> listAll() {
	        return repo.findAll();
	    }
	     
	    public Device save(Device device) {
	        return repo.save(device);
	    }
	     
	    public Device get(String id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(String id) {
	        repo.deleteById(id);
	    }
	    @Query("SELECT new com.cdsg.device.modeldto.DeviceInfo(r.device.serialNo, r.device.name, count(r.device)) "+
				"FROM RepairLog r group by r.device ")
		public List<DeviceInfo> getDeviceInfo(){
	    	return repo.getDeviceInfo();
	    }
	    @Query("select d.serialNo, d.name from Device d")
		public List<Object[]> getShortDevice(){
	    	return repo.getShortDevice();
	    }
		
		@Query(value = "select name, status from device where serial_no = ?1", nativeQuery = true)
	    public List<Object[]> findDeviceSerial(String serialNo){
	    	return repo.findDeviceSerial(serialNo);
	    }
}
