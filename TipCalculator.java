import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TipCalculator extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("Tip Calculator");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        TextField billField = new TextField();
        billField.setPromptText("Bill Amount");
        TextField tipField = new TextField();
        tipField.setPromptText("Tip Percentage");
        Label resultLabel = new Label();
        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");
        Button calcButton = new Button("Calculate Tip");
        Button resetButton = new Button("Reset");
        calcButton.setOnAction(e -> {
            try {
                errorLabel.setText("");
                double bill = Double.parseDouble(billField.getText());
                double tipPercent = Double.parseDouble(tipField.getText());
                if (bill < 0 || tipPercent < 0) {
                    errorLabel.setText("Error: Values must be positive");
                    return;
                }
                double tipAmount = bill * tipPercent / 100;
                resultLabel.setText(String.format("Tip Amount: $%.2f", tipAmount));
            } catch (NumberFormatException ex) {
                errorLabel.setText("Error: Please enter valid numbers");
                resultLabel.setText("");
            }
        });
        resetButton.setOnAction(e -> {
            billField.clear();
            tipField.clear();
            resultLabel.setText("");
            errorLabel.setText("");
        });
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titleLabel, billField, tipField, calcButton, resetButton, resultLabel, errorLabel);
        Scene scene = new Scene(root, 400, 350);
        primaryStage.setTitle("Tip Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
