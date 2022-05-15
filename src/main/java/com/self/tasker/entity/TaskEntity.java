package com.self.tasker.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userCreator;
    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<CommentEntity> comments;

    private Long idUserExecutor;
    private String idSubTasks;
    @NotNull
    private String text;
    @NotNull
    private Date dateCreate;
    private Date dateEnd;
    private Boolean completed;

    public TaskEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserCreator() {
        return userCreator;
    }

    public void setUserCreator(UserEntity userCreator) {
        this.userCreator = userCreator;
    }

    public Long getIdUserExecutor() {
        return idUserExecutor;
    }

    public void setIdUserExecutor(Long idUserExecutor) {
        this.idUserExecutor = idUserExecutor;
    }

    public String getIdSubTasks() {
        return idSubTasks;
    }

    public void setIdSubTasks(String idSubTasks) {
        this.idSubTasks = idSubTasks;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
}
