package main;

import dao.CategoryDao;

public class Category {
    public static void main(String[] args) {
        CategoryDao cd = new CategoryDao();
        System.out.println(cd.getAll(6));
    }
}
