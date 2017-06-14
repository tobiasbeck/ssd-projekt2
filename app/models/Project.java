package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by tobibeck on 14.06.17.
 */

@Entity
public class Project extends Model {
    @Id
    @Column(name="project_id")
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    private Customer buyer;

    @Transient
    private String buyertmp;

    @ManyToOne
    private User projectLeader;

    @Transient
    private String projectLeadertmp;

    public static Finder<Long,Project> find = new Finder<Long,Project>(Project.class);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    public String getBuyertmp() {
        return buyertmp;
    }

    public void setBuyertmp(String buyertmp) {
        this.buyertmp = buyertmp;
    }

    public User getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(User projectLeader) {
        this.projectLeader = projectLeader;
    }

    public String getProjectLeadertmp() {
        return projectLeadertmp;
    }

    public void setProjectLeadertmp(String projectLeadertmp) {
        this.projectLeadertmp = projectLeadertmp;
    }
}
