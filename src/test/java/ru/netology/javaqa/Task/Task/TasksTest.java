package ru.netology.javaqa.Task.Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TasksTest {

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");

        assertTrue(task.matches("Позвонить родителям"));
        assertFalse(task.matches("Не звонить "));
    }

    @Test
    public void testEpicMatches() {
        Epic epic = new Epic(55, new String[]{"Молоко"});

        assertTrue(epic.matches("Молоко"));
        assertFalse(epic.matches("Каша"));
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");


        assertTrue(meeting.matches("Выкатка 3й версии приложения"));
        assertTrue(meeting.matches("Приложение НетоБанка"));
        assertFalse(meeting.matches("Отдых"));
    }

    @Test
    //Проверяем, что метод getTitle возвращает правильное значение
    public void testGetSimpleTask() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertEquals("Позвонить родителям", task.getTitle());
    }

    @Test
    //Проверяем, что метод getSubtasks возвращает правильное значение
    public void testGetEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Assertions.assertArrayEquals(subtasks, epic.getSubtasks());

    }

    @Test
    //Проверяем, что метод getTopic,getProject,getStart возвращают правильное значение
    public void getMeeting() {
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Assertions.assertEquals("Выкатка 3й версии приложения", meeting.getTopic());
        Assertions.assertEquals("Приложение НетоБанка", meeting.getProject());
        Assertions.assertEquals("Во вторник после обеда", meeting.getStart());

    }

    @Test
    // Проверяем, что метод getId возвращает правильное значение
    public void getTaskId() {
        Task task1 = new Task(5);
        Task task2 = new Task(55);
        Task task3 = new Task(555);

        Assertions.assertEquals(5, task1.getId());
        Assertions.assertEquals(55, task2.getId());
        Assertions.assertEquals(555, task3.getId());
    }

    @Test
    // Проверяем, что метод matches возвращает false для несовпадающего запроса
    public void testMatches() {
        Task task = new Task(1);
        assertFalse(task.matches("query"));


    }

    @Test
    public void testEquals() {
        // Создаем два одинаковых объекта Task
        Task task1 = new Task(5);
        Task task2 = new Task(5);
        // Создаем объект Task с другим id
        Task task3 = new Task(555);
        // метод equals возвращает true для одинаковых объектов
        assertEquals(task1, task2);
        //  метод equals возвращает false для разных объектов
        assertNotEquals(task1, task3);
        // метод equals возвращает false для null
        assertNotEquals(null, task1);
        // метод equals возвращает false для объекта другого класса
        assertNotEquals("Во вторник после обеда", task1);
    }

    @Test
    public void testHashCodeConsistency() {
        // Создаем объект Task
        Task task = new Task(5);
        // Проверяем, что метод hashCode возвращает одинаковое значение при многократных вызовах
        int hashCode1 = task.hashCode();
        int hashCode2 = task.hashCode();
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    public void testHashCodeEquality() {
        // Создаем два одинаковых объекта Task
        Task task1 = new Task(5);
        Task task2 = new Task(5);
        // Проверяем, что метод hashCode возвращает одинаковое значение для одинаковых объектов
        assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    public void testHashCodeInequality() {
        // Создаем два разных объекта Task
        Task task1 = new Task(5);
        Task task2 = new Task(55);

        // Проверяем, что метод hashCode возвращает разные значения для разных объектов
        assertNotEquals(task1.hashCode(), task2.hashCode());
    }
}






