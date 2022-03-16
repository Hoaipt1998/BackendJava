package com.cdsg.device.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsg.device.dao.RepairLogRepository;
import com.cdsg.device.model.Device;
import com.cdsg.device.model.RepairLog;

@Service
@Transactional
public class RepairLogService {

    @Autowired
    private RepairLogRepository repo;
    
    
    public List<RepairLog> listAll() {
        return repo.findAll();
       
    }
     
    public void save(RepairLog repairLog) {
        repo.save(repairLog);
    }
     
    public RepairLog get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
        
    }
    
    public Device findRepairingDevice(String serialNo) {
    	return repo.findRepairingDevice(serialNo);
    }

}
