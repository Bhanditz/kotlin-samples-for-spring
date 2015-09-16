package com.examples.spring.rest

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/message")
public class MessageController() {

    @RequestMapping("/{message}", method = arrayOf(RequestMethod.GET))
    public fun getMessage(@PathVariable message: String, model: ModelMap): String {
        //TODO check that [] do the same as setAttribute
        model["message"] = message
        return "message"
    }
}

@Controller
@RequestMapping("/user")
public class UserController() {

    @RequestMapping(value = "/{firstName}/{lastName}", method = arrayOf(RequestMethod.GET))
    public fun getUser(@PathVariable firstName: String, @PathVariable lastName: String, model: ModelMap): String {
        model["firstname"] = firstName
        model["lastname"] = lastName
        return "user"
    }
}
