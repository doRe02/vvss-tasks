package modulesTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tasks.model.Task;
import tasks.repository.ArrayTaskList;
import tasks.services.TasksService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Step3TestSRE {
    ArrayTaskList repo = new ArrayTaskList();
    TasksService service = new TasksService(repo);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

    @Test
    @DisplayName("SR+E: Test add in repository")
    void repoAddTest() throws ParseException {
        Task taskOne = new Task("test 1", formatter.parse("2023-04-09"), formatter.parse("2023-05-09"), 2);
        Task taskTwo = new Task("test 2", formatter.parse("2023-04-09"), formatter.parse("2023-05-09"), 5);
        Task taskThree = new Task("test 3", formatter.parse("2023-04-09"), formatter.parse("2023-05-09"), 7);
        repo.add(taskOne);
        repo.add(taskTwo);
        repo.add(taskThree);
        assert (repo.getAll().size() == 3);
    }

    @Test
    @DisplayName("SR+E: Test remove from repository")
    void repoRemoveTest() throws ParseException {
        Task taskOne = new Task("test 1", formatter.parse("2023-04-09"), formatter.parse("2023-05-09"), 2);
        Task taskTwo = new Task("test 2", formatter.parse("2023-04-09"), formatter.parse("2023-05-09"), 5);
        Task taskThree = new Task("test 3", formatter.parse("2023-04-09"), formatter.parse("2023-05-09"), 7);
        repo.add(taskOne);
        repo.add(taskTwo);
        repo.add(taskThree);
        assert (repo.getAll().size() == 3);
        repo.remove(taskThree);
        repo.remove(taskOne);
        assert (repo.getAll().size() == 1);
    }

}