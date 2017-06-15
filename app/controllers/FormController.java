package controllers;

import models.*;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

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
        return ok();
    }

    public Result addCustomer(){
        Form<Customer> customerForm = formFactory.form(Customer.class);
        return ok(views.html.addCustomer.render(customerForm));
    }


    public Result addProject(){
        Form<Project> form = formFactory.form(Project.class);
        List<Customer> customers = Customer.find.all();
        List<User> users = User.find.all();

        return ok(views.html.addProject.render(form,customers,users));
    }

    public Result editProject(Long id){
        Project project = Project.find.byId(id);
        Form<Project> projectForm = formFactory.form(Project.class);

        project.setProjectLeadertmp(""+project.getProjectLeader().getId());
        project.setBuyertmp(""+project.getBuyer().getId());

        projectForm = projectForm.fill(project);



        List<Customer> customers = Customer.find.all();
        List<User> users = User.find.all();
        //System.out.println(userForm.get());
        return ok(views.html.editProject.render(projectForm,project,customers,users));
    }

    public Result addTask(Long id){
        Form<Task> form = formFactory.form(Task.class);
        List<User> user = User.find.all();
        Project project = Project.find.byId(id);

        List<String> options = new ArrayList<String>();
        options.add("to do");
        options.add("in bearbeitung");
        options.add("testing");
        options.add("fertig");

        return ok(views.html.addTask.render(form,project,user,options));
    }

    public Result editTask(Long id){
        Task t = Task.find.byId(id);
        t.setAssignedTotmp(""+t.getAssignedTo().getId());

        Form<Task> form = formFactory.form(Task.class);
        form = form.fill(t);

        List<User> user = User.find.all();
        List<String> options = new ArrayList<String>();
        options.add("to do");
        options.add("in bearbeitung");
        options.add("testing");
        options.add("fertig");

        return ok(views.html.editTask.render(form,t,user,options));
    }
}
