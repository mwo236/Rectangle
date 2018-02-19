import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rectangle extends Application {
	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Rectangle");

		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 400, 400);

		Label instruction = new Label("To find the perimeter\nof a rectangle, enter its\nlength and width");

		Label lwidth = new Label("Width");
		TextField fwidth = new TextField();

		Label lheight = new Label("Height");
		TextField fheight = new TextField();

		Label lper = new Label("Perimeter");
		TextField fper = new TextField();
		fper.setEditable(false);

		Button btn = new Button("Calculate!");

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				fper.setText("");
				try {
					int w = Integer.parseInt(fwidth.getText());
					int h = Integer.parseInt(fheight.getText());
					int per = (2*h) + (2*w);
					fper.setText("" + per);
				} catch(Exception e) //Error occurred
				{ System.out.println("An error occurred."); return; }
			}
		});

		//Layout everything onto the grid.
		
		grid.add(instruction, 1, 0);
		grid.add(lwidth, 0, 1);
		grid.add(fwidth, 1, 1);
		grid.add(lheight, 0, 2);
		grid.add(fheight, 1, 2);
		grid.add(lper, 0, 6);
		grid.add(fper, 1, 6);
		grid.add(btn, 0, 4);

		stage.setScene(scene);
		stage.show();

	}
}
