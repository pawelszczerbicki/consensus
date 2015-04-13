package com.szczerbicki;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pawel on 12.04.15.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome(){
        return "index";
    }
}
