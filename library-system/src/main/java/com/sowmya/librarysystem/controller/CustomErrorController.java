package com.sowmya.librarysystem.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletResponse response)
    {
        Object status = response.getStatus();


            int statusCode = Integer.parseInt(status.toString());

            if(statusCode == HttpStatus.FORBIDDEN.value()) {
                return "error-403";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }

        return "error";
    }
}
