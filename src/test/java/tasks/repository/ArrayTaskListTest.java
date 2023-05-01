package tasks.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tasks.model.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTaskListTest {

    private TaskList tasksRepo = new ArrayTaskList();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm", Locale.ENGLISH);


    @DisplayName("Test for adding valid Task") // 1.adnotation
    @Test
    void addValidTask() {
        try {
            Task task = new Task("valid", formatter.parse("2023-03-21 12:34"), formatter.parse("2023-03-21 13:34"), 2);
            tasksRepo.add(task);

        } catch (ParseException e) {
            e.printStackTrace();
            assert (false);
        }
        assert (true);
    }

    @ParameterizedTest //3.adnotation
    @ValueSource(ints = {2, 3, 4}) //2.adnotation
    @DisplayName("Check For Task Add With Different Interval Values")
    void checkTaskAddWithDifferentValidIntervalValues(int interval) {
        try {
            Task task = new Task("valid", formatter.parse("2023-03-21 12:34"), formatter.parse("2023-03-21 13:34"), interval);
            tasksRepo.add(task);
        } catch (ParseException e) {
            e.printStackTrace();
            assert (false);
        }
        assert (true);
    }

    //TO DO: Add missing tests following BVA & ECP test cases and conditions
    //TO DO: Add 2 more adnotation that were not used before for testing

    @Test
    void checkTaskAddIncorrectEndTimeAndStartTime() {

        //TO DO
    }

    @Test
    void checkTaskAddIntervalValueLessThanOneShouldThrowError() {
        //TO DO
    }

}