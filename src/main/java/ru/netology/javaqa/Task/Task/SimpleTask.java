package ru.netology.javaqa.Task.Task;

public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id); // вызов родительского конструктора
        this.title = title; // заполнение своих полей
    }

    public String getTitle() {
        return title;
    }

    //Переопределите метод matches для  SimpleTask
    @Override
    public boolean matches(String query) {
        return title.contains(query);
    }
}






