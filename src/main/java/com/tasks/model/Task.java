package com.tasks.model;

import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.*;


@Entity
@Table(name = "tasks")
public class Task implements Comparable<Task> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private PriorityLevel priority;

    private boolean completed;
    
    private LocalDateTime createdDate;
    
    private LocalDateTime lastUpdateDate;

    public enum PriorityLevel {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    // Default no-argument constructor required by JPA
    public Task() {
    }

    // Constructor without id; id will be auto-generated
    public Task(String description, LocalDateTime dueDate, PriorityLevel priority) {
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    // JPA lifecycle callback to set createdDate and lastUpdateDate on persist
    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
    }

    // JPA lifecycle callback to update lastUpdateDate on update
    @PreUpdate
    protected void onUpdate() {
        this.lastUpdateDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    public void setPriority(PriorityLevel priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    // Compare tasks first by priority (higher priority first), then by due date
    @Override
    public int compareTo(Task other) {
        int priorityComparison = other.priority.compareTo(this.priority);
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        return this.dueDate.compareTo(other.dueDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format(
            "Task[id=%d, description=%s, dueDate=%s, priority=%s, completed=%s, createdDate=%s, lastUpdateDate=%s]",
            id, description, dueDate, priority, completed, createdDate, lastUpdateDate
        );
    }
}
