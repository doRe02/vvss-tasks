package modulesTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tasks.model.Task;
import tasks.repository.ArrayTaskList;
import tasks.services.TasksService;

import static org.mockito.Mockito.mock;

class Step2TestRS {
    ArrayTaskList repo = new ArrayTaskList();
    TasksService service = new TasksService(repo);

    @Test
    @DisplayName("SR E mock: Test add in repository")
    void repoAddTest() {
        Task taskOne = mock(Task.class);
        Task taskTwo = mock(Task.class);
        repo.add(taskOne);
        repo.add(taskTwo);
        assert (repo.getAll().size() == 2);
    }

    @Test
    @DisplayName("SR E mock: Test parseFromStringToSeconds - Service")
    void testParseFromStringToSeconds() {
        int stringToSec = 50400;
        assert service.parseFromStringToSeconds("14:00") == stringToSec;
    }

}