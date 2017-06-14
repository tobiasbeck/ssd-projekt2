package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Result;

import javax.inject.Inject;

import java.util.List;

import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;

/**
 * Created by tobibeck on 13.06.17.
 */
public class UserController {

    @Inject
    public FormFactory formFactory;

    public Result create(){
        Form<User> userForm = formFactory.form(User.class);
        User user = userForm.bindFromRequest().get();



        user.save();
        return  redirect(routes.UserController.list());
    }


    public Result list(){
        List<User> userList = User.find.all();
        return ok(views.html.listUser.render(userList));
    }

    public Result delete(Long id){
        User.find.byId(id).delete();
        return redirect(routes.UserController.list());
    }

    public Result update(Long id){
        Form<User> form = formFactory.form(User.class);
        User user = form.bindFromRequest().get();
        User oldUser = User.find.byId(id);
        if(user!=null) {
            oldUser.setEmail(user.getEmail());
            oldUser.setName(user.getName());
            oldUser.setPosition(user.getPosition());
        }
        oldUser.update();
        return redirect(routes.UserController.list());
    }
}
