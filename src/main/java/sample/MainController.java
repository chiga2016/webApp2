package sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MainController {
    @RequestMapping("/test")
    public String test() {
        return "redirect:http://ya.ru";
    }


    @Autowired
    MessageService svc;

    @Autowired
    CurrentUserBean ub;

    @ModelAttribute(name="user") // без name не заработает, выберет имя сам
    public String getUser() {
        return ub.getUsername();
    }



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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start() {
        return "index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }



    @RequestMapping(value="/add.do")
    public String newMessage(Model m) {
        m.addAttribute("messages", svc.getAllMessages());
        return  "newMessage";
    }


    @RequestMapping(value="/addMessage.do", method= RequestMethod.POST)
    //public String addNewMessage(Model m) {
    //public String addNewMessage(Model m,@RequestParam Map<String, String> requestParams) {
    public String addNewMessage(Model m,@RequestParam(value="user") String user1, @RequestParam(value="user2") String user2, @RequestParam(value="msg") String text) {
      //  Message message = new Message(user1,user2,text);
//String user1 = requestParams.get("user");
//String user2 = requestParams.get("user2");
//String text = requestParams.get("msg");
        //req.setCharacterEncoding("utf-8");
        if (user1!=""&&text!=""&&user1!=null&&text!=null){
            if(user2!=""){
                svc.addMessage(user1,user2,text);
            }
            else{
                svc.addMessage(user1,text);
            }
        }
        m.addAttribute("messages", svc.getAllMessages());
        //return "/add.do";
        return  "redirect:allmsg";
        //m.addAttribute("messages", svc.getAllMessages());
        //return  "redirect:http://ya.ru";
    }



}
