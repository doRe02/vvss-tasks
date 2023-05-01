package tasks.repository;

import tasks.model.Task;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Clasa abstracta ce stabileste operatiile pentru repoository al task-urilor
 */

public abstract class TaskList implements Iterable<Task>, Serializable {
    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index);

    public abstract List<Task> getAll();

    public abstract Iterator<Task> iterator();

    public TaskList incoming(Date from, Date to) {
        TaskList incomingTasks;
        if (this instanceof ArrayTaskList) {
            incomingTasks = new ArrayTaskList();
        } else {
            incomingTasks = new LinkedTaskList();
        }

        for (int i = 0; i < this.size(); i++)
            if (getTask(i).getStartTime().after(from) && getTask(i).getEndTime().before(to))
                incomingTasks.add(getTask(i));
        return incomingTasks;
    }
}