package sg.edu.nus.iss.vttp_day11.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @ResponseBody
    @RequestMapping(path="/log", method=RequestMethod.GET)
    public String standard() {

        logger.info("This is an INFO message");
        logger.warn("This is a WARN message");
        logger.error("This is an ERROR message");
        logger.debug("This is a DEBUG message");
        logger.trace("This is a TRACE message");
        
        return "";
    }

    @RequestMapping(path="/home", method=RequestMethod.GET)
    public String home() {
        return "home";
    }
}
