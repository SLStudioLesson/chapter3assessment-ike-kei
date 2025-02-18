package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.ui.model.Recipe;

// 設問３
// DataHandler`インターフェースを実装した`CSVDataHandler.java`クラスを作成
public class CSVDataHandler implements DataHandler {
    private String filePath;


    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    // 各メソッドの定義
    @Override
    public String getMode() {
        return "CSV";
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
