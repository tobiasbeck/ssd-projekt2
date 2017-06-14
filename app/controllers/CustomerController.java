package controllers;

import models.Customer;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by User on 13.06.2017.
 */
public class CustomerController extends Controller {

    @Inject
    private FormFactory formFactory;

    public Result list(){

        List<Customer> customerList = Customer.find.all();
        return ok(views.html.customerList.render(customerList));

    }

    public Result create(){
        Form<Customer> customerForm = formFactory.form(Customer.class);
        Customer customer = customerForm.bindFromRequest().get();
        customer.save();
        return redirect(routes.CustomerController.list());

    }

    public Result delete(Long id){
        Customer customer = Customer.find.byId(id);
        customer.delete();
        return redirect(routes.CustomerController.list());


    }

    public Result update(Long id){
        Form<Customer> form = formFactory.form(Customer.class);
        Customer customer = form.bindFromRequest().get();
        Customer oldCustomer = Customer.find.byId(id);
        if(customer!=null) {
            oldCustomer.setEmail(customer.getEmail());
            oldCustomer.setFirstname(customer.getFirstname());
            oldCustomer.setLastname(customer.getLastname());
            oldCustomer.setCompany(customer.getCompany());
            oldCustomer.setAddress(customer.getAddress());
            oldCustomer.setPhone(customer.getPhone());
        }
        oldCustomer.update();
        return redirect(routes.CustomerController.list());
    }


    }

