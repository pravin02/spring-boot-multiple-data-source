package org.pk.multidatasource.todos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Objects;

@Table(name = "todo")
@Entity
public class Todo {

    @Id
    private Long todoId;

    @Column(nullable = false, unique = true)
    private String todo;

    private boolean isActive;

    @CreationTimestamp(source = SourceType.DB)
    private Instant createdOn;

    @UpdateTimestamp(source = SourceType.DB)
    private Instant updatedOn;


    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo todo1)) return false;
        return isActive == todo1.isActive && Objects.equals(todoId, todo1.todoId) && Objects.equals(todo, todo1.todo) && Objects.equals(createdOn, todo1.createdOn) && Objects.equals(updatedOn, todo1.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoId, todo, isActive, createdOn, updatedOn);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", todo='" + todo + '\'' +
                ", isActive=" + isActive +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
