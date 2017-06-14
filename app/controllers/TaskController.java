package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;

import models.*;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;
/**
 * Created by tobibeck on 14.06.17.
 */
public class TaskController extends Controller {

    @Inject
    public FormFactory formFactory;

    public Result create(){
        Form<Task> form = formFactory.form(Task.class);

        return ok();
    }

    public Result delete(Long id){
        Project p = Project.find.byId(id);
        Task t = Task.find.byId(id);
        if(t!= null){
            t.delete();
        }

        return redirect(routes.TaskController.list());
    }


    public Result list(){
        return ok();
    }
}
