package com.abdrabo.controller;

import com.abdrabo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    /** Add an @InitBinder ... to trim input strings
     *  remove leading and trailing whitespaces
    */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        // true means trim empty string to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    // Show the customer registration form
    @GetMapping("/showCustomerForm")
    public String showCustomer(Model model){

        // Add the customer object to the model
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    // Show the confirmation of the customer info
    @PostMapping("/processCustomerForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult){

        // Debug to get the code error and assign it a message on message.properties
        // System.out.println(bindingResult.toString());

        if (bindingResult.hasErrors()){
            return "customer-form";
        }

        return "customer-confirmation";
    }
}
