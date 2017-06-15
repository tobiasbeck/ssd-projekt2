package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by tobibeck on 14.06.17.
 */
@Entity
public class Task extends Model {

    @Id
    @Column(name="task_id")
    private Long id;

    private String title;
    private String description;

    private int time;

    @ManyToOne
    private User assignedTo;
    @Transient
    private String assignedTotmp;

    @ManyToOne
    private Project project;
    @Transient
    private String projecttmp;

    private String status;

    public static Finder<Long,Task> find = new Finder<Long,Task>(Task.class);


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getAssignedTotmp() {
        return assignedTotmp;
    }

    public void setAssignedTotmp(String assignedTotmp) {
        this.assignedTotmp = assignedTotmp;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getProjecttmp() {
        return projecttmp;
    }

    public void setProjecttmp(String projecttmp) {
        this.projecttmp = projecttmp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
