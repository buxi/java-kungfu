package de.buxi.cantstop.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import de.buxi.cantstop.model.GameTransferObject;
import de.buxi.cantstop.service.GameException;
import de.buxi.cantstop.service.GameService;

@Controller
public class PollingController {
	private Log log = LogFactory.getLog(PollingController.class);
	private GameService gameService;

	@Autowired
	public PollingController(GameService gameService) {
		this.gameService = gameService;
	}
	
	// response is returned as JSON, because jackson jars are on classpath
	@RequestMapping(value= "polling", method = RequestMethod.POST)
	public @ResponseBody GameTransferObject poll(Model model) throws GameException {
		//log.debug("polling called");
		GameTransferObject gameInfo = gameService.getAllGameInformation();
		//gameInfo.errorMessage = "aaaaaaaaaaaaaaa";
		
		model.addAttribute("gameInfo", gameInfo);
		return gameInfo;
	}
	
	
	@RequestMapping(value= "polling", method = RequestMethod.GET)
	public String welcome(Model model) throws GameException {
		model.addAttribute("gameInfo", gameService.getAllGameInformation());
		return "polling";
	}
	
}