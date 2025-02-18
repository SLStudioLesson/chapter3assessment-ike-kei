package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.ui.model.Ingredient;
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
        ArrayList<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] pairs = line.split(",",2);
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                for (String pair : pairs) {
                }
                Ingredient ingredient = new Ingredient(pairs[1]);
                ingredients.add(ingredient);
                Recipe recipe = new Recipe(pairs[0], ingredients);
                recipes.add(recipe);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: 例外のメッセージ");
        }
        return recipes;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {

    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}
