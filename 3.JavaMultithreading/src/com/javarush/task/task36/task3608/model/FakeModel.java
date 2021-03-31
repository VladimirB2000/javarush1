package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.Arrays;

public class FakeModel implements Model{
    private ModelData modelData = new ModelData();


    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(Arrays.asList(new User("А", 1,1), new User("Б", 2, 1)));
    }
}
