package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class DemoController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoadingCatchRepository loadingCatchRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addPeople(@RequestBody People people) {
        System.out.println(people.getName());
        System.out.println(people.getSex());
        userRepository.save(people);
        return "Ok.";
    }
    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome() {
        return "welcome.";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody LoginMsg loginMsg) {
        System.out.println(loginMsg);
        return "233333";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signup(@RequestBody LoginMsg loginMsg) {
        System.out.println("signup : " + loginMsg);
        LoadingCatch loadingCatch = new LoadingCatch();
        loadingCatch.setPhone(loginMsg.name);
        loadingCatch.setLoadingCode(loginMsg.passwd);
        String token = "23333";
        loadingCatch.setToken(token);
        loadingCatchRepository.save(loadingCatch);
        return token;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public LoginMsg login_() {
        //System.out.println(loginMsg);
        LoginMsg loginMsg = new LoginMsg();
        loginMsg.name = "Are you OK?";
        loginMsg.passwd = "I'm OK.";
        return loginMsg;
    }
}
