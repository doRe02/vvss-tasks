package modulesTesting.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tasks.model.Task;
import tasks.repository.ArrayTaskList;
import tasks.services.TasksService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TasksServiceTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);



    @Mock
    TasksService service;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("testgetIntervalInHours - Service")
    void testgetIntervalInHours() throws ParseException {
        Task taskOne = new Task("test 1",formatter.parse("2023-04-09"),formatter.parse("2023-04-12"),140);
        when(service.getIntervalInHours(taskOne)).thenReturn("00:02");
        assert (service.getIntervalInHours(taskOne).compareTo("00:02") == 0);
    }

    @Test
    @DisplayName("parseFromStringToSeconds - Service")
    void testParseFromStringToSeconds() throws ParseException {
        Task taskOne = new Task("test 1",formatter.parse("2023-04-09"),formatter.parse("2023-04-12"),140);
        int stringToSec = 50400;
        when(service.parseFromStringToSeconds("14:00")).thenReturn(stringToSec);
        assert service.parseFromStringToSeconds("14:00") == stringToSec;


    }
}