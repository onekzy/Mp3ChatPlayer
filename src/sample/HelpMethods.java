package sample;

import javafx.scene.layout.Pane;

import javax.swing.text.html.ListView;
import java.util.List;

public class HelpMethods {
    public static void switchPane(Pane pane1, Pane pane2, Pane pane3 ) {
        if (pane1.isVisible() == true) {
            pane1.setVisible(false);
            pane2.setVisible(false);
            pane3.setVisible(true);

        } else if(pane3.isVisible()== true) {
            pane3.setVisible(false);
            pane1.setVisible(false);
            pane2.setVisible(true);

        } else if(pane2.isVisible()== true) {
            pane2.setVisible(false);
            pane3.setVisible(false);
            pane1.setVisible(true);
        }
    }



}

