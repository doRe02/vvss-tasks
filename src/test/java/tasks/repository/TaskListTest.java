package tasks.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tasks.model.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TaskListTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

    @Test
    @DisplayName("Test 1")
    void test1() throws ParseException {
        TaskList taskList = new ArrayTaskList();
        Task task1 = new Task("task1", formatter.parse("2023-04-09"));
        Task task2 = new Task("task2", formatter.parse("2023-08-09"));
        taskList.add(task1);
        taskList.add(task2);

        TaskList result = taskList.incoming(formatter.parse("2023-04-09"), formatter.parse("2021-04-09"));
        assert (result instanceof ArrayTaskList);
        assert (result.size() == 0);
    }

    @Test
    @DisplayName("Test 2")
    void test2() throws ParseException {
        TaskList taskList = new LinkedTaskList();
        Task task1 = new Task("task1", formatter.parse("2023-04-09"));
        Task task2 = new Task("task2", formatter.parse("2023-08-09"));
        taskList.add(task1);
        taskList.add(task2);

        TaskList result = taskList.incoming(formatter.parse("2023-04-09"), formatter.parse("2021-04-09"));
        assert (result instanceof LinkedTaskList);
        assert (result.size() == 0);
    }

    @Test
    @DisplayName("Test 3")
    void test3() throws ParseException {
        TaskList taskList = new ArrayTaskList();
        Task task1 = new Task("task1", formatter.parse("2023-04-09"));
        Task task2 = new Task("task2", formatter.parse("2023-08-09"));
        taskList.add(task1);
        taskList.add(task2);

        TaskList result = taskList.incoming(formatter.parse("2023-04-09"), formatter.parse("2023-04-10"));
        assert (result instanceof ArrayTaskList);
        assert (result.size() > 0);
    }

    @Test
    @DisplayName("Test 4")
    void test4() throws ParseException {
        TaskList taskList = new LinkedTaskList();
        Task task1 = new Task("task1", formatter.parse("2023-04-09"));
        Task task2 = new Task("task2", formatter.parse("2023-08-09"));
        taskList.add(task1);
        taskList.add(task2);

        TaskList result = taskList.incoming(formatter.parse("2023-04-09"), formatter.parse("2023-04-10"));
        assert (result instanceof LinkedTaskList);
        assert (result.size() > 0);
    }

    @Test
    @DisplayName("Test 5")
    void test5() throws ParseException {
        TaskList taskList = new ArrayTaskList();
        Task task1 = new Task("task1", formatter.parse("2023-04-09"));
        Task task2 = new Task("task2", formatter.parse("2023-08-09"));
        taskList.add(task1);
        taskList.add(task2);

        TaskList result = taskList.incoming(formatter.parse("2024-04-09"), formatter.parse("2024-04-10"));
        assert (result instanceof ArrayTaskList);
        assert (result.size() == 0);
    }

    @Test
    @DisplayName("Test 6")
    void test6() throws ParseException {
        TaskList taskList = new LinkedTaskList();
        Task task1 = new Task("task1", formatter.parse("2023-04-09"));
        Task task2 = new Task("task2", formatter.parse("2023-08-09"));
        taskList.add(task1);
        taskList.add(task2);

        TaskList result = taskList.incoming(formatter.parse("2024-04-09"), formatter.parse("2024-04-10"));
        assert (result instanceof LinkedTaskList);
        assert (result.size() == 0);
    }

    @Test
    @DisplayName("Test 7")
    void test7() throws ParseException {
        TaskList taskList = new ArrayTaskList();

        TaskList result = taskList.incoming(formatter.parse("2023-04-09"), formatter.parse("2024-04-10"));
        assert (result instanceof ArrayTaskList);
        assert (result.size() == 0);
    }

    @Test
    @DisplayName("Test 8")
    void test8() throws ParseException {
        TaskList taskList = new LinkedTaskList();

        TaskList result = taskList.incoming(formatter.parse("2023-04-09"), formatter.parse("2024-04-10"));
        assert (result instanceof LinkedTaskList);
        assert (result.size() == 0);
    }
}
