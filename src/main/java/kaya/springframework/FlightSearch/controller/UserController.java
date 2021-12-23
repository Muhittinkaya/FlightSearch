package kaya.springframework.FlightSearch.controller;

import kaya.springframework.FlightSearch.entity.User;
import kaya.springframework.FlightSearch.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/showRegistered")
    public String showRegistrationPage(){
        return "login/registerUser";
    }

    @RequestMapping(value = "/registerUser")
    public String register(@ModelAttribute("user") User user){
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping("/showLogin")
    public String showLoginPager(){
        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap){
        User user = userRepository.findByEmail(email);
        System.out.println("DEBUG DB " + user.getPassword());
        System.out.println("DEBUG Param "+ password);
        if (user.getPassword().equals(password)){
            return "/findFlights";
        }else{
            modelMap.addAttribute("msg", "Invalid username or password");
        }

        return "login/login";
    }
}
