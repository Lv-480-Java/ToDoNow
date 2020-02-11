package andriypyzh.entity;

import java.sql.Date;
import java.util.Objects;

public class Task {
    private int id;
    private String name;
    private String owner;
    private int projectId;
    private int priority;
    private Date creationDate;
    private Date expirationDate;
    private String description;
    private String status;


    public Task() {
    }

    public Task(String name, String owner, int projectId, int priority, Date creationDate, Date expirationDate, String description, String status) {
        this.name = name;
        this.owner = owner;
        this.projectId = projectId;
        this.priority = priority;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.description = description;
        this.status = status;
    }


    public Task(int id, String name, String owner, int projectId, int priority, Date creationDate, Date expirationDate, String description, String status) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.projectId = projectId;
        this.priority = priority;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.description = description;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return getId() == task.getId() &&
                getProjectId() == task.getProjectId() &&
                getPriority() == task.getPriority() &&
                Objects.equals(getName(), task.getName()) &&
                Objects.equals(getOwner(), task.getOwner()) &&
                Objects.equals(getCreationDate(), task.getCreationDate()) &&
                Objects.equals(getExpirationDate(), task.getExpirationDate()) &&
                Objects.equals(getDescription(), task.getDescription()) &&
                Objects.equals(getStatus(), task.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getOwner(), getProjectId(), getPriority(), getCreationDate(), getExpirationDate(), getDescription(), getStatus());
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId='" + owner + '\'' +
                ", projectId=" + projectId +
                ", priority=" + priority +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
