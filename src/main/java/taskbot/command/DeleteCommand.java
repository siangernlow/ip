package taskbot.command;

import taskbot.exceptions.TaskbotException;
import taskbot.task.TaskList;

/**
 * Encapsulates a command to delete a task.
 */
public class DeleteCommand extends Command {
    // The index at which to delete the task.
    private int taskIndex;

    /**
     * Creates a DeleteCommand.
     *
     * @param taskIndex The index where the task is at.
     */
    public DeleteCommand(int taskIndex) {
        super(false);
        this.taskIndex = taskIndex;
    }

    /**
     * Gives instructions on how to use the delete command.
     *
     * @return A string of instructions to use the command.
     */
    public static String getInstruction() {
        return "Deletes the task at the given index.\n"
                + "Format: delete [index]\n"
                + "index: the index in which the task appears on the list.";
    }

    /**
     * Gets the task index.
     *
     * @return The index of the list where the task is.
     */
    public int getTaskIndex() {
        return taskIndex;
    }

    @Override
    public String execute(TaskList taskList) throws TaskbotException {
        return taskList.deleteTask(taskIndex);
    }

    @Override
    public boolean equals(Object obj) {
        // Check if obj is compared with itself
        if (obj == this) {
            return true;
        }

        // Check if obj is an instance of this class
        if (!(obj instanceof DeleteCommand)) {
            return false;
        }

        // Compare taskIndex and return accordingly
        return taskIndex == ((DeleteCommand) obj).getTaskIndex();
    }
}
