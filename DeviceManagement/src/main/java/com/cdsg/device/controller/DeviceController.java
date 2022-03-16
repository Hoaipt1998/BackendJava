package com.cdsg.device.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cdsg.device.model.Device;
import com.cdsg.device.model.DeviceType;
import com.cdsg.device.service.DeviceService;
import com.cdsg.device.service.DeviceTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DeviceController {
    private static final Logger logger = 
    		LoggerFactory.getLogger(DeviceController.class);

	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DeviceTypeService deviceTypeService;
	@Value( "${file.upload-dir}" )
	private String UPLOADED_FOLDER;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        String message = "Device Management System";
        
        model.addAttribute("message", message);
        return "index";
    }
	//List of devices
	@RequestMapping(value = "deviceList")  
    public String listDevices(Model model) {  
      model.addAttribute("devices", deviceService.listAll());
      logger.info("get the list of divices");
      return "deviceList";  
    }  
	//delete device
   @RequestMapping("deleteDevice")
    public ModelAndView deleteDevice(@RequestParam String id) {
        deviceService.delete(id);
        logger.info("Delete device ID: " + id);
        return new ModelAndView("redirect:deviceList");
    }
    //edit device
    @RequestMapping("editDevice")
    public String editDevice(@RequestParam String id, Model model) {
        Device device = deviceService.get(id);
        List<DeviceType> deviceTypes = deviceTypeService.listAll();
        model.addAttribute("device", device);
        model.addAttribute("deviceTypes", deviceTypes);
        return "editDeviceForm";
    }
    //Edit device save
    @RequestMapping("editDeviceSave")
    public ModelAndView saveDevice(@ModelAttribute Device device) {
    	deviceService.save(device);
        return new ModelAndView("redirect:deviceList");
    }
	    
	@RequestMapping(value = "addDevice")  
    public String addDevice(Model model) {  
      model.addAttribute("device", new Device());
      model.addAttribute("deviceTypes", deviceTypeService.listAll());
      return "addDevice";  
    }  
    //add device save
    @RequestMapping(value = "saveDevice", method = RequestMethod.POST)  
    public ModelAndView save(@RequestParam("photoUpload") MultipartFile photo, Device device, Model model) {  
      //upload device photo
    	if (photo.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload");
		//return "uploadStatus";
		}

		try {
			// Get the file and save it somewhere
			byte[] bytes = photo.getBytes();
			device = deviceService.save(device);
			Path path = Paths.get(UPLOADED_FOLDER + device.getSerialNo() + "_"+ photo.getOriginalFilename());
			Files.write(path, bytes);
			
			device.setPhoto(device.getSerialNo() + "_" + photo.getOriginalFilename());
			
			model.addAttribute("message", "You successfully uploaded '" + photo.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
			
		}
     
      deviceService.save(device);
      logger.info("Add new device Serial Number: " + device.getSerialNo());
      System.out.println("Device Type ID: " + device.getDeviceType().getId());
      return new ModelAndView("redirect:deviceList");
    }  
    
    
}
