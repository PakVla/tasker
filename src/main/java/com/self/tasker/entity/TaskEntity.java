package com.self.tasker.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
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

    private String idUsersExecutors;
    private String idSubTasks;
    @NotNull
    private String text;
    @NotNull
    private String dateTimeCreate;
    private String dateTimeEnd;
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

    public String getIdUsersExecutors() {
        return idUsersExecutors;
    }

    public void setIdUsersExecutors(String idUsersExecutors) {
        this.idUsersExecutors = idUsersExecutors;
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

    public String getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(String dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public String getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(String dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
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
