package controllers;

import models.*;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Result;

import javax.inject.Inject;

import static play.mvc.Results.*;

/**
 * Created by tobibeck on 13.06.17.
 */
public class FormController {

    @Inject
    public FormFactory formFactory;

    public Result addUser(){
        Form<User> userForm = formFactory.form(User.class);
        return ok(views.html.addUser.render(userForm));
    }

    public Result editUser(Long id){
        User user = User.find.byId(id);
        Form<User> userForm = formFactory.form(User.class);
        userForm = userForm.fill(user);
        //System.out.println(userForm.get());
        return ok(views.html.editUser.render(userForm,user));
    }

    public Result editCustomer(Long id) {
        Customer customer = Customer.find.byId(id);
        Form<Customer> customerForm = formFactory.form(Customer.class);
        customerForm = customerForm.fill(customer);


        return ok(views.html.editCustomer.render(customerForm,customer));
    }

    public Result addCustomer(){
        Form<Customer> customerForm = formFactory.form(Customer.class);
        return ok(views.html.addCustomer.render(customerForm));
    }
}
