package taskbot.task;

public class TaskStub extends Task {
    public TaskStub(String task) {
        super(task);
    }

    @Override
    public String toString() {
        return getTask();
    }
}