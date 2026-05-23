package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.Users;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;




@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "redirect:/home";
    }   

    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home page handler");

        // Sending Data to view
        model.addAttribute("name","Substring Technologies");
        model.addAttribute("fullstackDeveloper", "Java");
        model.addAttribute("githubRepo", "https://github.com/SakibAS22/Java-Programs");

        return "home";
    }

    //! About route

    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin", false);
        System.out.println("This is about page");
        return "about";
    }
    

    //! Services route

      @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("services page loading...");
        return "services";
    }

    //! contact page

    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }

    //! This is login page

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    //! regestration page
    @GetMapping("/register")
    public String register(Model model) {
        // default data bhi dal sakte hai
        UserForm userForm= new UserForm();
        // userForm.setName("Sakib");
        // userForm.setAbout("This is about ! set something about");

        model.addAttribute("userForm",userForm);
        return "register";
    }
    // !  Processing register
    @RequestMapping(value="do-register", method= RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult bindingResult, HttpSession session) {
        System.out.println("Hell");

        // Fetch the form data
        // userform
        System.out.println(userForm);

        // Validate form data
        if(bindingResult.hasErrors()){
            return "register";
        }

        // TODO :: Validate userForm

        // save to database

        
        // userservice

        // UserForm -se banaya-> User 
        // Users user= Users.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://www.computerworld.com/wp-content/uploads/2024/03/android-contacts-100934390-orig.jpg?resize=1024%2C683&quality=50&strip=all")
        // .build();

        Users user= new Users();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic("https://www.computerworld.com/wp-content/uploads/2024/03/android-contacts-100934390-orig.jpg?resize=1024%2C683&quality=50&strip=all");
        Users savedUser= userService.saveUser(user);

        System.out.println("user Saved: ");

        // message = "Registration successful"
        
        // add the message:
        Message message= Message.builder().content("Registration Successfull").type(MessageType.blue).build();

        session.setAttribute("message", message);

        // redirect to login page

        return "redirect:/register";
    }
    
 
    
    // // Contact route

    //   @RequestMapping("/contact")
    // public String contactPage(){
    //     System.out.println("contact page loading...");
    //     return "contact";
    // }

    // // Login route

    //   @RequestMapping("/login")
    // public String loginPage(){
    //     System.out.println("login page loading...");
    //     return "login";
    // }

    // // Signup route

    //   @RequestMapping("/signup")
    // public String signupPage(){
    //     System.out.println("signup page loading...");
    //     return "services";
    // }

}
