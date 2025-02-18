package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.ui.model.Recipe;

// 設問３
// DataHandler`インターフェースを実装した`JSONDataHandler.java`クラスを作成
public class JSONDataHandler implements DataHandler {
    // 各メソッドの定義
    @Override
    public String getMode() {
        return "JSON";
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException {
        return null;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {

    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}
