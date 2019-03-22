package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    CurrentUserBean ub;

    @ModelAttribute(name="user") // без name не заработает, выберет имя сам
    public String getUser() {
        return ub.getUsername();
    }

    @RequestMapping(value="login")
        public String login() {
            return "login";
        }

    @RequestMapping(value="login.do",method=RequestMethod.POST)
    //public String login( @RequestParam(required=true) String u, @RequestParam(required=true) String p  ) {
    public String login(@RequestParam(value="login") String u,@RequestParam(value="pass") String p){
        String result;
        if(ub.login(u,p)){
            result=  "redirect:add.do";
        }
        else{
            result=  "redirect:errorLogin";
        }
        return  result;
    }

    @RequestMapping(value="logout.do")
    public String logout(Model m) {
        ub.setUsername(null);
        return  "redirect:index";
    }

}
