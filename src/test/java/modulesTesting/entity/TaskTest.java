package modulesTesting.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tasks.model.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);


    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Test Task Getters and Setters test")
    void taskAttributesTest() throws ParseException {
        Task taskOne = new Task("test 1",formatter.parse("2023-04-09"),formatter.parse("2023-05-09"),2);
        assert (taskOne.getTitle().compareTo("test 1") == 0);
        assert (taskOne.getStartTime().getTime() == formatter.parse("2023-04-09").getTime());
        assert (taskOne.getEndTime().getTime() == formatter.parse("2023-05-09").getTime());
        assert (taskOne.getRepeatInterval() == 2);
        assert (!taskOne.isActive());
        assert (taskOne.isRepeated());

        taskOne.setActive(true);
        taskOne.setTitle("new test title");
        taskOne.setTime(formatter.parse("2023-08-09"),formatter.parse("2023-09-09"),12);

        assert (taskOne.isActive());
        assert (taskOne.getTitle().compareTo("new test title") == 0);
        assert (taskOne.getStartTime().getTime() == formatter.parse("2023-08-09").getTime());
        assert (taskOne.getEndTime().getTime() == formatter.parse("2023-09-09").getTime());
        assert (taskOne.getRepeatInterval() == 12);


    }

    @Test
    @DisplayName("Test Task for equals method")
    void testEquals() throws ParseException {
        Task taskOne = new Task("test 1",formatter.parse("2023-04-09"),formatter.parse("2023-05-09"),2);
        Task taskTwo = new Task("test 1",formatter.parse("2023-04-09"),formatter.parse("2023-05-09"),2);
        assert( taskOne.equals(taskTwo));
    }


}