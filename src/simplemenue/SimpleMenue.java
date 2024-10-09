package simplemenue;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimpleMenue extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text mac = new Text("McDonald's");
        mac.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        mac.setFill(javafx.scene.paint.Color.ORANGE);
        // Load the image
        Image logo = new Image("file:/Users/rayanbawazeer/Library/Mobile Documents/com~apple~CloudDocs/AlYamamah/4.SWE312/Lab/Lab3/hamburger.jpg");  
        ImageView imageView = new ImageView(logo);
        imageView.setFitWidth(100);  // Set width of the image
        imageView.setPreserveRatio(true);  // Preserve aspect ratio
        HBox h = new HBox();
        h.getChildren().addAll(mac,imageView);
        Text title = new Text("Please fill the form below to place your order: ");

        Text name = new Text("NAME:");
        name.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        TextField fname = new TextField();
        TextField lname = new TextField();
        HBox h1 = new HBox();
        h1.getChildren().addAll(name, fname, lname);
        h1.setSpacing(10);

        Text cm = new Text("Chicken Mac");
        TextField tcm = new TextField();
        Text pcm = new Text("$5");
        HBox h2 = new HBox();
        h2.getChildren().addAll(cm, tcm, pcm);

        Text bm = new Text("Big Mac");
        TextField tbm = new TextField();
        Text pbm = new Text("$7");
        HBox h3 = new HBox();
        h3.getChildren().addAll(bm, tbm, pbm);

        Text cb = new Text("Cheese Burger");
        TextField tcb = new TextField();
        Text pcb = new Text("$4");
        HBox h4 = new HBox();
        h4.getChildren().addAll(cb, tcb, pcb);

        Text spe = new Text("Special requests:");
        spe.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        TextArea note = new TextArea();
        note.setPrefSize(300, 250);
        VBox.setVgrow(note, Priority.NEVER);
        Text bill = new Text();

        Button order = new Button("ORDER");
        order.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        HBox h5 = new HBox();
        h5.getChildren().add(order);
        h5.setAlignment(Pos.CENTER);
        
        order.setOnAction(event -> {
            double total = 0; // Initialize total here

            // Calculate totals based on input
            if (!tcm.getText().isEmpty()) {
                double totalcm = Double.parseDouble(tcm.getText()) * 5;
                total += totalcm;
            }
            if (!tbm.getText().isEmpty()) {
                double totalbm = Double.parseDouble(tbm.getText()) * 7;
                total += totalbm;
            }
            if (!tcb.getText().isEmpty()) {
                double totalcb = Double.parseDouble(tcb.getText()) * 4;
                total += totalcb;
            }

            // Set the bill text
            bill.setText("Thank you " + fname.getText() + " " + lname.getText() + 
                          " for shopping with us.\nSpecial requests: " + note.getText() + 
                          "\nSubtotal: $" + String.format("%.2f", total)); // Format to 2 decimal places
            bill.setFill(javafx.scene.paint.Color.RED);

        });
        
        VBox v1 = new VBox();
        v1.getChildren().addAll(h, title, h1, h2, h3, h4, spe, note, bill, h5);
        v1.setPadding(new Insets(10, 10, 10, 10));
        v1.setSpacing(10);

        Scene scene = new Scene(v1, 600, 550);

        primaryStage.setTitle("Lab3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
