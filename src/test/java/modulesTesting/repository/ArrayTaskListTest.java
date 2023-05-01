package modulesTesting.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tasks.model.Task;
import tasks.repository.ArrayTaskList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArrayTaskListTest {

    @Mock
    ArrayTaskList tasksRepo;

    ArrayTaskList realRepo;

    @BeforeEach
    void setUp() {
        realRepo = new ArrayTaskList();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("test add & getAll ArrayList - Repo")
    void testAdd() throws ParseException {
        Task taskOne = mock(Task.class);
        Task taskTwo =  mock(Task.class);
        List<Task> allTasks = new ArrayList<>();

        allTasks.add(taskOne);
        allTasks.add(taskTwo);


        doNothing().when(tasksRepo).add(taskOne);
        doNothing().when(tasksRepo).add(taskTwo);
        tasksRepo.add(taskOne);
        tasksRepo.add(taskTwo);

        when(tasksRepo.getAll()).thenReturn(allTasks);
        assert (tasksRepo.getAll().size() == 2);
        verify(tasksRepo).getAll();

        realRepo.add(taskOne);
        realRepo.add(taskTwo);

        assert (realRepo.getAll().size() == 2);

    }

    @Test
    @DisplayName("test remove ArrayList - Repo")
    void testRemove() throws ParseException {
        Task taskOne =  mock(Task.class);
        Task taskTwo =  mock(Task.class);
        Task taskThree =  mock(Task.class);

        List<Task> justOneTask = new ArrayList<>();
        justOneTask.add(taskOne);

        when(tasksRepo.remove(taskTwo)).thenReturn(true);
        when(tasksRepo.getAll()).thenReturn(justOneTask);


        when(tasksRepo.remove(taskThree)).thenReturn(false);
        doNothing().when(tasksRepo).add(taskOne);
        doNothing().when(tasksRepo).add(taskTwo);

        //here
        tasksRepo.add(taskOne);
        tasksRepo.add(taskTwo);
        assert (tasksRepo.remove(taskTwo));
        assert (tasksRepo.getAll().size() == 1);
        assert (!tasksRepo.remove(taskThree));


    }


}