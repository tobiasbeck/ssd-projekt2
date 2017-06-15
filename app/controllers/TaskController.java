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

    public Result create(Long id){
        Form<Task> form = formFactory.form(Task.class);
        Task t = form.bindFromRequest().get();
        t.setAssignedTo(User.find.byId(Long.parseLong(t.getAssignedTotmp())));
        t.setProject(Project.find.byId(id));
        t.save();
        return redirect(routes.ProjectController.detail(id));
    }

    public Result delete(Long id){
        Project p = Project.find.byId(id);
        Task t = Task.find.byId(id);
        Long projectID = t.getProject().getId();
        if(t!= null){

            t.delete();
        }

        return redirect(routes.ProjectController.detail(projectID));
    }

   public Result update(Long id){
       Form<Task> form = formFactory.form(Task.class);
       Task t = form.bindFromRequest().get();
       Task o = Task.find.byId(id);
       o.setTitle(t.getTitle());
       o.setDescription(t.getDescription());
       o.setAssignedTo(User.find.byId(Long.parseLong(t.getAssignedTotmp())));
       o.setTime(t.getTime());
       o.setStatus(t.getStatus());
       o.update();

       return redirect(routes.ProjectController.detail(o.getProject().getId()));
   }


}
