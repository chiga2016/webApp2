package sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/test")
    public String test() {
        return "redirect:http://ya.ru";
    }


    @Autowired
    MessageService svc;

//    @RequestMapping("/")
//    @ResponseBody


    @RequestMapping("/all")
    @ResponseBody
    public String allMessagesText() {
        return svc.getAllMessages().toString();
    }


    @RequestMapping("/allmsg")
    public String allMessages(Model m) {
        m.addAttribute("messages", svc.getAllMessages());
        return  "messages";
    }

}
