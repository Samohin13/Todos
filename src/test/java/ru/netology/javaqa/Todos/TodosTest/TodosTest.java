package ru.netology.javaqa.Todos.TodosTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Task.Task.*;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void testAdd() {
        Todos todos = new Todos();
        SimpleTask simple = new SimpleTask(5, "Позвонить родителям");
        Epic epic = new Epic(55, new String[]{"Молоко", "Яйца", "Хлеб"});
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simple, epic, meeting};
        assertArrayEquals(expected, todos.findAll());
    }

    @Test
    //поиск Todos найти три задачи
    public void searchForTodosFindThreeTasks(){
        SimpleTask simple = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();
        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("");
        Task[] expected = {simple,epic,meeting};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //поиск Todos найти одну задачу
    public void searchForTodosFindOneTask(){
        SimpleTask simple = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");


        Todos todos = new Todos();
        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Приложение НетоБанка");
        Task[] expected = {meeting};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //поиск Todos найти ноль задач
    public void searchForTodosFindNoneTask() {
        SimpleTask simple= new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");


        Todos todos = new Todos();
        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Zero");
        Task[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

}























