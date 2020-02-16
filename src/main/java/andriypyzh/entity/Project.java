package andriypyzh.entity;

import java.sql.Date;
import java.util.Objects;

public class Project {
    private int id;
    private String name;
    private String Creator;
    private Date creationDate;
    private Date expirationDate;
    private String description;
    private String status;
    private String type;

    public Project() {
    }

    public Project(String name, String creatorId, Date creationDate, Date expirationDate,
                   String description, String status, String type) {
        this.name = name;
        this.Creator = creatorId;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.description = description;
        this.status = status;
        this.type = type;
    }

    public Project(int id, String name, String creatorId, Date creationDate, Date expirationDate,
                   String description, String status, String type) {
        this.id = id;
        this.name = name;
        this.Creator = creatorId;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.description = description;
        this.status = status;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", CreatorId=" + Creator +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return getId() == project.getId() &&
                getCreator().equals(project.getCreator()) &&
                Objects.equals(getName(), project.getName()) &&
                Objects.equals(getCreationDate(), project.getCreationDate()) &&
                Objects.equals(getExpirationDate(), project.getExpirationDate()) &&
                Objects.equals(getDescription(), project.getDescription()) &&
                Objects.equals(getStatus(), project.getStatus()) &&
                Objects.equals(getType(), project.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCreator(), getCreationDate(),
                getExpirationDate(), getDescription(), getStatus(), getType());
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

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creatorId) {
        Creator = creatorId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
