package com.examples.spring.rest

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

Controller
RequestMapping(array("/message"))
public class MessageController() {

    RequestMapping(value=array("/{message}"), method = array(RequestMethod.GET))
    public fun getMessage(PathVariable message: String, model: ModelMap): String {
        model.addAttribute("message", message)
        return "message"
    }
}

Controller
RequestMapping(array("/user"))
public class UserController() {

    RequestMapping(value=array("/{firstName}/{lastName}"), method = array(RequestMethod.GET))
    public fun getUser(PathVariable firstName: String, PathVariable lastName: String, model: ModelMap): String {
        model.addAttribute("firstname", firstName)
        model.addAttribute("lastname", lastName)
        return "user"
    }
}
