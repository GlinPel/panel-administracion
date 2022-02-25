package com.gleenpeltroche.iniciosesionregistro.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gleenpeltroche.iniciosesionregistro.models.User;
import com.gleenpeltroche.iniciosesionregistro.services.RoleService;
import com.gleenpeltroche.iniciosesionregistro.services.UserService;

@Controller
public class HomeController {
	
	private UserService userService;
    private RoleService roleService;
    
    public HomeController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        User currentUsert = userService.findByUsername(username);
        model.addAttribute("currentUser", currentUsert);
        if(currentUsert.getRoles().get(0).getName().equals("ROLE_ADMIN")){
        	return "admin.jsp";
        }else {
        	return "home.jsp";
        }
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register.jsp";
        }
        if(roleService.findRoleAdmin().get(0).getUsers().size()>0) {
        	userService.saveWithUserRole(user);
        }else {
        	userService.saveUserWithAdminRole(user);
        }
        return "redirect:/login";
    }
     
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        List<User> usersList = userService.finAllUsers();
        System.out.println(usersList.size());
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("usersList", usersList);
        return "admin.jsp";
    }
    
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "login.jsp";
    }
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "register.jsp";
    }
    
    
 
 /*@GetMapping("/home")
 public String home(Model model, HttpSession session) {
	 User userSession = (User) session.getAttribute("user");
	 if(userSession == null){
		 return "redirect:/";
	 }
	 model.addAttribute("user", userSession);
     return "home.jsp";
 }*/
 
 /*@PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {
     
     if(result.hasErrors()) {
    	 model.addAttribute("newLogin", new LoginUser());
         return "index.jsp";
     }
     
     if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	 result.rejectValue("confirm", "Matches", "La contraseña de confirmación debe coincidir");
    	 model.addAttribute("newLogin", new LoginUser());
    	 return "index.jsp";
     }
     
     User user = userServ.register(newUser, result);
     if(user == null) {
    	 result.rejectValue("email", "Matches", "El email ya se encuentra registrado.");
    	 model.addAttribute("newLogin", new LoginUser());
    	 return "index.jsp";
     }
     session.setAttribute("user", user);
     return "redirect:/";
 }
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {

     if(result.hasErrors()) {
    	 model.addAttribute("newUser", new User());
         return "index.jsp";
     }
	 
     User user = userServ.login(newLogin, result);
     if(user == null) {
    	 result.rejectValue("email", "Matches", "El nombre usuario es incorrecto.");
    	 model.addAttribute("newUser", new User());
    	 return "index.jsp";
     }
     
     if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	 result.rejectValue("password", "Matches", "El password es incorrecto.");
    	 model.addAttribute("newUser", new User());
    	 return "index.jsp";
     }
     session.setAttribute("user", user);
     return "redirect:/";
 }
 
 @GetMapping("/logout")
 public String logout(HttpSession session) {
	 session.removeAttribute("user");
	 return "redirect:/";
 }*/
}