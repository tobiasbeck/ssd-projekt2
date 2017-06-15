package controllers;

import models.Customer;
import models.Project;
import models.Task;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tobibeck on 14.06.17.
 */
public class ProjectController extends Controller {

    @Inject
    public FormFactory formFactory;

    public Result list(){
        List<Project> list = Project.find.all();

        return ok(views.html.listProjects.render(list));
    }


    public Result create(){
        Form<Project> form = formFactory.form(Project.class);
        Project p = form.bindFromRequest().get();
        p.setBuyer(Customer.find.byId(Long.parseLong(p.getBuyertmp())));
        p.setProjectLeader(User.find.byId(Long.parseLong(p.getProjectLeadertmp())));
        p.save();
        return redirect(routes.ProjectController.list());
    }

    public Result delete(Long id){
        Project p = Project.find.byId(id);
        if(p!= null){
            p.delete();
        }

        return redirect(routes.ProjectController.list());

    }

    public Result update(Long id){
        Form<Project> form = formFactory.form(Project.class);
        Project newP = form.bindFromRequest().get();
        Project p = Project.find.byId(id);

        p.setName(newP.getName());
        p.setDescription(newP.getDescription());
        p.setBuyer(Customer.find.byId(Long.parseLong(newP.getBuyertmp())));
        p.setProjectLeader(User.find.byId(Long.parseLong(newP.getProjectLeadertmp())));

        p.update();
        System.out.println("UPDATE");
        return redirect(routes.ProjectController.list());

    }

    public Result detail(Long id){
        Project p = Project.find.byId(id);
        List<Task> t = Task.find.where().eq("project_project_id",p.getId()).findList();

        return ok(views.html.projectDashboard.render(p,t));
    }
}
