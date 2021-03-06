package taskbot.ui;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * An example of a custom control using FXML.
 * This control represents a dialog box consisting of an ImageView to represent the speaker's face and a label
 * containing text from the speaker.
 */
public class DialogBox extends HBox {
    @FXML
    private Text dialog;
    @FXML
    private Circle displayPicture;

    private DialogBox(String text, Image image, Color color, Color dropShadow) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(DialogBox.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        dialog.setText(text);

        displayPicture.setStroke(color);
        displayPicture.setFill(new ImagePattern(image));
        displayPicture.setEffect(new DropShadow(+25d, 0d, +2d, dropShadow));
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    /**
     * Creates a DialogBox representing the user.
     * @param text The text the user has input.
     * @param image The image representing the user.
     * @return a DialogBox with the given text and image.
     */
    public static DialogBox getUserDialog(String text, Image image) {
        return new DialogBox(text, image, Color.SEAGREEN, Color.DARKSEAGREEN);
    }

    /**
     * Creates a DialogBox representing TaskBot's response.
     * @param text The response given by TaskBot.
     * @param image The image representing TaskBot.
     * @return a DialogBox to be displayed as TaskBot's answer to the user.
     */
    public static DialogBox getTaskbotDialog(String text, Image image) {
        DialogBox dialogBox = new DialogBox(text, image, Color.BLUE, Color.DARKBLUE);
        dialogBox.flip();
        return dialogBox;
    }
}
