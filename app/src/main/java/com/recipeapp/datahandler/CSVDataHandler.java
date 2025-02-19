package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    // 設問５
    // `recipes.csv`ファイルからレシピデータを読み込み、コンソールに一覧表示する機能をステップに従い作成してください。
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        ArrayList<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] pairs = line.split(",", 2);
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                String[] ingredientList = pairs[1].split(",");
                for (String ingredientName : ingredientList) {
                    Ingredient ingredient = new Ingredient(ingredientName);
                    ingredients.add(ingredient);
                }
                Recipe recipe = new Recipe(pairs[0], ingredients);
                recipes.add(recipe);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: 例外のメッセージ");
        }
        return recipes;
    }

    // 設問６
    @Override
    public void writeData(Recipe recipe) throws IOException {
        String writeRecipe = "";
        String writeIngredients = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.newLine();
            writeRecipe = recipe.getName();
            writer.write(writeRecipe);
            for (Ingredient ingredient : recipe.getIngredients()) {
                writer.write(",");
                writeIngredients = ingredient.getName();
                writer.write(writeIngredients);
            }
            
        } catch (IOException e) {
            System.out.println("Failed to add new recipe: 例外のメッセージ");
        }
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}
