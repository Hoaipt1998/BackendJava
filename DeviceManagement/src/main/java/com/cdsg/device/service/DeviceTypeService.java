package com.cdsg.device.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsg.device.dao.DeviceTypeRepository;
import com.cdsg.device.model.DeviceType;



@Service
@Transactional
public class DeviceTypeService {

    @Autowired
    private DeviceTypeRepository repo;
     
    public List<DeviceType> listAll() {
        return repo.findAll();
    }
     
    public void save(DeviceType person) {
        repo.save(person);
    }
     
    public DeviceType get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
   
}
