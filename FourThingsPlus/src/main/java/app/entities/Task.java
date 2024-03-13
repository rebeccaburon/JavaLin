package app.entities;

public class Task {

    private int taksId;
    private String name;
    private boolean done;
    private int userId;

    public Task(int taksId, String name, boolean done, int userId) {
        this.taksId = taksId;
        this.name = name;
        this.done = done;
        this.userId = userId;
    }

    public Task(String name, boolean done, int userId) {
        this.name = name;
        this.done = done;
        this.userId = userId;
    }

    public int getTaksId() {
        return taksId;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }

    public int getUserId() {
        return userId;
    }

    public void setTaksId(int taksId) {
        this.taksId = taksId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taksId=" + taksId +
                ", name='" + name + '\'' +
                ", done=" + done +
                ", userId=" + userId +
                '}';
    }
}
