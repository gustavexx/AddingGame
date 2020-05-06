package AdditionGame;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Implementation of the view for an arithmetic adding quiz simulation, where the user will try to guess the result
 * of the operation before the time is up
 * @author Gustavo Marcano, gustavexx@gmail.com
 */
public class ArithmeticView extends Application {

    /**
     * Constant representing the size of the panel
     * **/
    static final int WIDTH = 580;
    static final int HEIGHT = 220;

    /**
     * seconds object Integer, will represent the time allotted to answer as many addition as possible
     * **/
    private Integer seconds = 59;

    /**
     * app, object of type Arithmetic, will represent the model of the app, tha will process the results and operartions
     * **/
    private Arithmetic app;

    /**
     * textfield, GUI component that will represent the field text where the user will input the result
     * **/
    private TextField textField;

    /**
     * lblOperation, GUI component that will represent the label describing the operation to perform i.e. "1 + 2 = "
     * **/
    Label lblOperation;

    /**
     * time and frame, GUI components that will represent the timer countdown
     * **/
    Timeline time;
    KeyFrame frame;


    /**
     * txtRight, GUI component that will display the number of correct answers
     * **/
    TextField txtRight;

    /**
     * txtWrong, GUI component that will display the number of wrong answers
     * **/
    TextField txtWrong;

    /**
     * btnOk, GUI component that will display the ok button to subbmit the answers
     * **/
    Button btnOk;

    /**
     * lbltimer, GUI component that will display the label "Clock" button to subbmit the answers
     * **/
    Label lbltimer;


    /**
     * okButtonHandle, GUI component that will handle petitions (activate) to the button pressing event and submit result
     * **/
    public void okButtonHandler(ActionEvent e) {
        textField.requestFocus();
        Integer inputValue = Integer.parseInt(textField.getText());
        app.setTxtField(inputValue);
        update();
    }

    /**
     * resetButtonHandler, GUI component that will handle petitions (activate) to the button pressing event and reset all
     * **/
    public void resetButtonHandler(ActionEvent e) {
        textField.requestFocus();
        seconds = 60;
        time.setCycleCount(Timeline.INDEFINITE);
        if(time != null) {
            time.stop();
        }
        time.playFromStart();
        app.generateRandNumbers();
        lblOperation.setText(app.getRandDigit1() +
                " + " + app.getRandDigit2() + " = ");
        textField.setText("");
        app.reset();
        txtRight.setText("0");
        txtWrong.setText("0");
        btnOk.setDisable(false);
        textField.setDisable(false);



    }

    /**
     * update, GUI component that will update the data after a button has been pressed
     * **/
    public void update()  {


        if(app.checkResult()) {

            app.increaseRight();
            txtRight.setText(app.getRight() + "");

        }
        else {
            app.increaseWrong();
            System.out.println(app.getWrong());
            txtWrong.setText(app.getWrong() + "");


        }

        app.generateRandNumbers();
        lblOperation.setText(app.getRandDigit1() +
                " + " + app.getRandDigit2() + " = ");
        textField.setText("");

    }

    @Override
    public void start(Stage stage) throws Exception {

        app = new Arithmetic();

        Pane root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Arithmetic");
        stage.setScene(scene);
        stage.setResizable(false);

        Rectangle controlSection = new Rectangle(400,0,250,HEIGHT);
        controlSection.setFill(Color.rgb(202,212,211,1));



        app = new Arithmetic();
        app.generateRandNumbers();

        Label lblTitle = new Label("Arithmetic");
        lblTitle.relocate(30 , 10);
        lblTitle.setFont(new Font("Arial",18));

        lblOperation = new Label(app.getRandDigit1() +
                " + " + app.getRandDigit2() + " = ");
        lblOperation.relocate(30 , 125);
        lblOperation.setFont(new Font("Arial",18));

        Label lRight = new Label("Right");
        lRight.relocate(430, 5);

        Label lWrong = new Label("Wrong");
        lWrong.relocate(430, 35);

        textField = new TextField();
        textField.setPrefWidth(65);
        textField.relocate(115, 122);


        btnOk = new Button("OK");
        btnOk.setPrefWidth(35);
        btnOk.setFont(new Font("Arial",10));
        btnOk.relocate(205, 125);

        txtRight = new TextField(app.getRight() + "");
        txtRight.setPrefWidth(40);
        txtRight.relocate(470,0);
        txtRight.setDisable(true);


        txtWrong = new TextField(app.getWrong() + "");
        txtWrong.setPrefWidth(40);
        txtWrong.relocate(470,30);
        txtWrong.setDisable(true);

        Button btnReset = new Button("Reset");
        btnReset.setPrefWidth(135);
        btnReset.relocate(425, 135);

        lbltimer = new Label("Clock");
        lbltimer.relocate(430 , 75);

        time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        if(time != null) {
            time.stop();
        }
        frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                seconds--;
                lbltimer.setText("Clock \t" + seconds.toString());
                if( seconds < 1 ){
                    time.stop();
                }

                if( seconds == 0) {

                    textField.setDisable(true);
                    btnOk.setDisable(true);
                    System.out.println("Stopped!!");
                }


            }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();




        root.getChildren().addAll(lblTitle, lblOperation, textField, btnOk, controlSection,
                lRight, lWrong, txtRight, txtWrong, lbltimer, btnReset);



        btnOk.setOnAction(this::okButtonHandler);
        btnReset.setOnAction(this::resetButtonHandler);
        stage.show();

    }

    public static void main(String[] args) throws InterruptedException {
        launch(args);
    }

}
