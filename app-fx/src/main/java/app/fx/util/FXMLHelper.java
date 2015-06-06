package app.fx.util;

import app.fx.api.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

final public class FXMLHelper {

    private FXMLHelper() {
        super();
    }

    public static Scene createScene(Stage stage, String viewTitle, String view, String... styles) throws Exception {
        URL v = getResource(view);
        URL[] s = getResources(styles);

        return createScene(stage, viewTitle, v, s);
    }

    public static Scene createScene(Stage stage, String viewTitle, URL view, URL... styles) throws Exception {
        Parent root = createView(stage, viewTitle, view, styles);

        return new Scene(root);
    }

    public static <V extends Parent> V createView(Stage stage, String viewTitle, String view, String... styles) throws Exception {
        URL v = getResource(view);
        URL[] s = getResources(styles);

        return createView(stage, viewTitle, v, s);
    }

    public static <V extends Parent> V createView(Stage stage, String viewTitle, URL view, URL... styles) throws Exception {
        FXMLLoader fxml;
        Controller controller;
        V root;

        fxml = new FXMLLoader(view);
        root = fxml.load();
        controller = fxml.getController();

        for (URL style : styles) {
            if (style != null)
                root.getStylesheets().add(style.toExternalForm());
        }

        stage.setTitle(viewTitle);

        controller.setStage(stage);

        return root;
    }

    private static URL getResource(String r) {
        return FXMLHelper.class.getResource(r);
    }

    private static URL[] getResources(String... r) {
        URL[] rs = new URL[r.length];

        for (int i = 0; i < r.length; i++) {
            rs[i] = FXMLHelper.class.getResource(r[i]);
        }

        return rs;
    }
}
