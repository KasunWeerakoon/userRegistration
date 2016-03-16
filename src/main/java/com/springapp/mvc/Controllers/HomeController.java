package com.springapp.mvc.Controllers;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springapp.mvc.Services.*;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        ResourceBundle interlizeMsg;
        Cookie cookie;
        InterlizationService interlizationService = new InterlizationService();
//		String langCode = request.getParameter("langCode");
//		String countryCode = request.getParameter("countryCode");
        String language = request.getParameter("language");
        System.out.println("language" + language);
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            cookie = new Cookie("UserCookie", "" + new java.util.Date().getTime());
        } else {

            cookie = cookies[0];
        }
        //	cookie.setValue("en");

//		for(Cookie c:cookies){
//			System.out.println("Cookie Iteration"+c.getValue()+ "index");
//		}

        if (language == null && !cookie.getValue().equals("en") && !cookie.getValue().equals("fr")) {
            cookie.setValue("en");
            interlizeMsg = interlizationService.interlize("en", "US");
        } else if (language == null && cookie.getValue().equals("en")) {

            interlizeMsg = interlizationService.interlize("en", "US");
        } else if (language == null && cookie.getValue().equals("fr")) {
            interlizeMsg = interlizationService.interlize("fr", "FR");
        } else if (language != null&&language.equals("en")) {
            cookie.setValue("en");
            interlizeMsg = interlizationService.interlize("en", "US");
        } else {
            cookie.setValue("fr");
            interlizeMsg = interlizationService.interlize("fr", "FR");

        }
        System.out.println("name" + cookie.getName());
        System.out.println("value " + cookie.getValue());

//        if (cookie.getValue() == null)
//            cookie.setValue("en");

        String cookieValue = cookie.getValue();
        if (cookieValue.equals("fr")) {
            cookieValue = "en";
        } else {
            cookieValue = "fr";
        }
        response.addCookie(cookie);
        model.addAttribute("cookieValue", cookieValue);
        model.addAttribute("line1", interlizeMsg.getString("line1"));
        model.addAttribute("line2", interlizeMsg.getString("line2"));

        System.out.println("From home " + interlizeMsg.getString("line1"));
        return "Home";
    }
}

@Controller
@RequestMapping("/user")
class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String User(ModelMap model, HttpServletRequest request) {
        InterlizationService interlizationService = new InterlizationService();
        ResourceBundle interlizeMsg;
        Cookie[] cookies = request.getCookies();

        if (cookies[0].getValue().equals("fr")) {
            interlizeMsg = interlizationService.interlize("fr", "FR");
        } else {
            interlizeMsg = interlizationService.interlize("en", "US");
        }

        for (Cookie c : cookies) {
            System.out.println("Cookie Iteration" + c.getValue() + "index");
        }
//		System.out.println("Cookie0", cookies[0].getValue());

        model.addAttribute("name", interlizeMsg.getString("name"));
        model.addAttribute("age", interlizeMsg.getString("age"));
        model.addAttribute("addr", interlizeMsg.getString("addr"));
        model.addAttribute("email", interlizeMsg.getString("email"));
        model.addAttribute("tpNo", interlizeMsg.getString("tpNo"));
        model.addAttribute("NIC", interlizeMsg.getString("NIC"));

        return "index";
    }

}

@Controller
@RequestMapping("/saveUser")
class SaveController {
    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(@RequestParam("name") String name,
                           @RequestParam("age") String age,
                           @RequestParam("addr") String addr,
                           @RequestParam("email") String email,
                           @RequestParam("tpNo") String tpNO,
                           @RequestParam("NIC") String NIC,
                           HttpServletRequest request,
                           ModelMap model) throws IOException {
        System.out.println("From controller" + name + age + addr + email + tpNO + NIC);
        ArrayList list = new ArrayList();
        list.add(name);
        list.add(age);
        list.add(addr);
        list.add(email);
        list.add(tpNO);
        list.add(NIC);
        System.out.println("From request param " + request.getParameter("NIC"));
        SaveUserService.getInstance().saveUser(list);
        model.addAttribute("name", name);
        return "HelloUser";
    }

}

@Controller
@RequestMapping("/userList")
class ListController {
    @RequestMapping(method = RequestMethod.GET)
    public String userList(ModelMap model, HttpServletRequest request) throws IOException {
        Map map = UserListService.getList();
        model.addAttribute("nameList", map.get("nameList"));
        model.addAttribute("dataList", map.get("dataList"));
        return "UserList";
    }
}

@Controller
@RequestMapping("/userDetails")
class DetailsController {
    @RequestMapping(method = RequestMethod.GET)
    public String userDetails(@RequestParam("hdnbt") List dataList, ModelMap model, HttpServletRequest request) {
        JSONObject jsonObj = UserDetailsService.getJSONObj(dataList);
        InterlizationService interlizationService = new InterlizationService();
        ResourceBundle interlizeMsg;
        Cookie[] cookies = request.getCookies();
        if (cookies[0].getValue().equals("fr")) {
            interlizeMsg = interlizationService.interlize("fr", "FR");
        } else {
            interlizeMsg = interlizationService.interlize("en", "UN");
        }
        for (Cookie c : cookies) {
            System.out.println("Cookie Iteration in details view " + c.getValue() + "index");
        }
        model.addAttribute("name", interlizeMsg.getString("name"));
        model.addAttribute("age", interlizeMsg.getString("age"));
        model.addAttribute("addr", interlizeMsg.getString("addr"));
        model.addAttribute("email", interlizeMsg.getString("email"));
        model.addAttribute("tpNo", interlizeMsg.getString("tpNo"));
        model.addAttribute("NIC", interlizeMsg.getString("NIC"));
        model.addAttribute("JSONObj", jsonObj);
        //model.addAttribute("InterlizeMsg",interlizeMsg);
        return "UserDetails";
    }
}
