package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;
/*
public class Category {
    private int idCategory;
    private String categoryName;
    private List<Event> events = new ArrayList<>();

    public Category() {
    }

    public Category(int idCategory, String categoryName, List<Event> events) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
        this.events = events;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
*/

public enum Category {

    IMPORTANT(1),
    DEADLINE(2),
    ROUTINE(3),
    WORK(4),
    FAMILY(5),
    HOLIDAY(6);

    private final int idCategory;

    Category(int idCategory){
        this.idCategory = idCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    @Override
    public String toString() {
        return Category.this.name();
    }
}