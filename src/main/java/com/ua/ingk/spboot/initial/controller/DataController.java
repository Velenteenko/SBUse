package com.ua.ingk.spboot.initial.controller;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ua.ingk.spboot.initial.controller.exept.ExceptionHandlerController;
import com.ua.ingk.spboot.initial.exception.RestException;
import com.ua.ingk.spboot.initial.service.DataService;
import com.ua.ingk.spboot.initial.utils.Ajax2Client;

@Controller
public class DataController extends ExceptionHandlerController {

	public static final Logger logger = Logger.getLogger(DataController.class);

	@Autowired
	@Qualifier("dataService")
	private DataService dataService;

	@RequestMapping(value = "/persist", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> persist(@RequestParam("data") String data) throws RestException {

		try {

			if (data == null || data.equals("")) {
				return Ajax2Client.emptyResponse();
			}

			dataService.persist(data);
			return Ajax2Client.emptyResponse();

		} catch (Exception e) {
			throw new RestException(e);
		}
	}

	@RequestMapping(value = "/getRandomData", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getRandomData() throws RestException {

		try {

			Set<String> result = dataService.getRandomData();
			return Ajax2Client.successResponse(result);

		} catch (Exception e) {
			throw new RestException(e);
		}
	}
}
