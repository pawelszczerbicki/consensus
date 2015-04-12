package com.szczerbicki;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pawel on 12.04.15.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String welcome(){
        return "Hello consensus";
    }
}
