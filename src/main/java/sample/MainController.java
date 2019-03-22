package sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;
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

    @RequestMapping(value = "errorLogin", method = RequestMethod.GET)
    public String error() {
        return "errorLogin";
    }

    @RequestMapping(value="/add.do")
    public String newMessage(Model m) throws Login1Exception {
        if (getUser()==null){
            throw new Login1Exception("Can not login");
        }
        m.addAttribute("messages", svc.getAllMessages());
        return  "newMessage";
    }

    @RequestMapping(value="/view.do")
    public String getGlobalMessage(Model m) {
        m.addAttribute("messages", svc.getGlobalMessages());
        return  "messages";
    }

    @RequestMapping(value="/viewPrivate.do")
    public String getPrivateMessages(Model m) {
        m.addAttribute("messages", svc.getMessagesTo(ub.getUsername()));
        return  "messages";
    }

    @RequestMapping("/answer/{u}")
    ModelAndView answer (@PathVariable("u") String targetUser) {  //(@PathVariable("u") targetUser) {

        ModelAndView mv=new ModelAndView("answerMessage");
        mv.addObject("messages", svc.getAllMessages());
        mv.addObject("author", targetUser);
        return mv;

        // показываем addMessage.jsp или её специализированный аналог с заполненными полями "от кого" и "кому"
    }



    @RequestMapping(value="/addMessage.do", method= RequestMethod.POST)
    //public String addNewMessage(Model m) {
    //public String addNewMessage(Model m,@RequestParam Map<String, String> requestParams) {
    public String addNewMessage(Model m,@RequestParam(value="user") String user1, @RequestParam(value="user2") String user2, @RequestParam(value="msg") String text) {
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
        return  "redirect:add.do";
    }

    @ExceptionHandler(Login1Exception.class)
    public ModelAndView exceptionHandler(Login1Exception ex)
    {
        ModelAndView mv=new ModelAndView("error");
        mv.addObject("msg", ex.getMessage());
        return mv;
    }




}
