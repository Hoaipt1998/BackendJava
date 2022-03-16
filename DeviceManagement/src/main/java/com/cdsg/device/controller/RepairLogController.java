package com.cdsg.device.controller;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdsg.device.model.RepairLog;
import com.cdsg.device.service.DeviceService;
import com.cdsg.device.service.RepairLogService;

@Controller
public class RepairLogController {
	//Logger logger =  LoggerFactory.getLogger(RepairLogController.class);
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private RepairLogService repairLogService;

	@RequestMapping(value = "addRepairLog")
	public String addRepairLog(@RequestParam String id, Model model) {
		RepairLog repairLog = new RepairLog();
		repairLog.setDevice(deviceService.get(id));
		model.addAttribute("repairLog", repairLog);
		return "addRepairLog";
	}

	// add repair log save
	@RequestMapping(value = "saveRepairLog", method = RequestMethod.POST)
	public ModelAndView save(RepairLog repairLog) {
		repairLogService.save(repairLog);
		return new ModelAndView("redirect:deviceList");
	}

	// result repair log save
	@RequestMapping(value = "resultRepairLog", method = RequestMethod.GET)
	public String resultRepairLog(@RequestParam Long id, Model model) {
		RepairLog r = repairLogService.get(id);
		model.addAttribute("repairLog", r);
		return "resultRepairLog";

	}

	// save result repair log save
	@RequestMapping(value = "saveResultRepairLog", method = RequestMethod.POST)
	public ModelAndView saveResultRepairLog(RepairLog repairLog) {
		repairLog.getDevice().setStatus(repairLog.getStatusOut());
		repairLogService.save(repairLog);
		return new ModelAndView("redirect:deviceList");
	}
	//List of repair log of a device
	@RequestMapping(value = "listRepairLog")
	public String listRepairLog(@RequestParam String serialNo, Model model) {
		model.addAttribute("device", deviceService.get(serialNo));
		return "repairLogList";
	}
}
