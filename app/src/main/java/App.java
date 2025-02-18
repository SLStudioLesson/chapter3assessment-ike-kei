import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            
            // 設問４
            // データハンドラーの選択
            switch (choice) {
                //「1」を選択した場合、`CSVDataHandler`インスタンスを生成する
                case "1":
                    DataHandler csvDataHandler = new CSVDataHandler();
                    RecipeUI recipeUI1 = new RecipeUI(csvDataHandler);
                    recipeUI1.displayMenu();
                    break;
                // 「2」を選択した場合、`JSONDataHandler`インスタンスを生成する
                case "2":
                    DataHandler jsonDataHandler = new JSONDataHandler();
                    RecipeUI recipeUI2 = new RecipeUI(jsonDataHandler);
                    recipeUI2.displayMenu();
                // 不正な入力（「1」「2」以外）が与えられた場合、`CSVDataHandler`インスタンスを生成する
                default:
                    DataHandler csvDataHandler2 = new CSVDataHandler();
                    RecipeUI recipeUI3 = new RecipeUI(csvDataHandler2);
                    recipeUI3.displayMenu();
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
    }
}