package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.Chat.Connection;
import sample.Chat.ConnectionListener;
import sample.Chat.Server;

import static sample.HelpMethods.*;
import static sample.Sound.getClip;

public class Controller implements ConnectionListener {
    static int volSound = 50;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView buttonIconScorp;

    @FXML
    private ImageView buttonIconFury;

    @FXML
    private TextField messageField;

    @FXML
    private ImageView buttonIconKing;

    @FXML
    private Button volUpButton;

    @FXML
    private ImageView buttonIconGreen;

    @FXML
    private ImageView buttonIconJoke;

    @FXML
    private Button startServerButton;

    @FXML
    private TextField ipField;

    @FXML
    private Pane contentPane;

    @FXML
    private Button connectButton;

    @FXML
    private ImageView buttonIconJin;

    @FXML
    private MenuBar menuBar;

    @FXML
    private ImageView buttonIconHow;

    @FXML
    private Button volDownButton;

    @FXML
    private Button sendMessageButton;

    @FXML
    TextField volViewField;

    @FXML
    private TextField nicknameField;

    @FXML
    private ImageView buttonIconHei;

    @FXML
    private Pane tekPane;

    @FXML
    private ListView<String> listViewJL;

    @FXML
    private ListView<String> listViewTek;

    @FXML
    private ImageView buttonIconBar;

    @FXML
    private ImageView buttonIconBat;

    @FXML
    private Menu fileMenu;

    @FXML
    private ImageView buttonIconShin;

    @FXML
    private MenuItem closeFile;

    @FXML
    private ImageView buttonIconShao;

    @FXML
    private TextArea chatField;

    @FXML
    private Menu helpMenu;

    @FXML
    private ImageView buttonIconSubzero;

    @FXML
    private ImageView buttonIconSuper;

    @FXML
    private Button playButton;

    @FXML
    private ImageView nextPaneButton;

    @FXML
    private Pane mkPane;

    @FXML
    private Pane jlPane;

    @FXML
    private MenuItem aboutFile;

    @FXML
    private Button stopButton;

    @FXML
    private ImageView buttonIconFlash;

    @FXML
    private ListView<String> listViewMK;

    private Connection connection;
    Thread serverThread;

    @FXML
    void initialize() {

        startServerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            serverThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    new Server();
                }
            });
            serverThread.start();
        });

        sendMessageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String msg = messageField.getText();
            if(msg.equals("")) return;

            messageField.setText("");
            connection.sendString(nicknameField.getText()+ ": " + msg);
        });

            messageField.setOnAction(event -> {
            String msg = messageField.getText();
            if(msg.equals("")) return;
            messageField.setText("");
            connection.sendString(nicknameField.getText()+ ": " + msg);
        });

        connectButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                connection = new Connection(this, ipField.getText(), 8189);
            } catch (IOException e) {
                printMeg("Connection exception "+e);
            }
        });



        volViewField.setText(String.valueOf(volSound));


        buttonIconSubzero.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewMK.getItems().clear();
            listViewMK.getItems().addAll("Насилие порождает насилие",
                                                    "Тебе не победить",
                                                        "Тебе не сбежать");
        });

        buttonIconScorp.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewMK.getItems().clear();
            listViewMK.getItems().addAll("Мне это надоедает",
                                                    "Узри мою мощь",
                                                    "Возвращайся в ад");
        });

        buttonIconBar.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewMK.getItems().clear();
            listViewMK.getItems().addAll("Ограничение безгранично",
                                                    "Ты не сможешь победить",
                                                    "Ты останешься без сердца");
        });

        buttonIconShao.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewMK.getItems().clear();
            listViewMK.getItems().addAll("Выбери свою судьбу",
                                                    "Фаталити",
                                                    "Чистая победа");
        });

        buttonIconShin.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewMK.getItems().clear();
            listViewMK.getItems().addAll("Служи и живи",
                                                    "Смерть зовет",
                                                    "Страх в сердце");
        });

        buttonIconFury.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewTek.getItems().clear();
            listViewTek.getItems().addAll("Давай",
                                                    "Хахаха",
                                                    "Омае");
        });

        buttonIconHei.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewTek.getItems().clear();
            listViewTek.getItems().addAll("Чидорика",
                                                    "Киётока",
                                                    "Сарузи дана");
        });

        buttonIconHow.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewTek.getItems().clear();
            listViewTek.getItems().addAll("Везде",
                    "Никогда",
                    "Твой конец здесь");
        });

        buttonIconJin.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewTek.getItems().clear();
            listViewTek.getItems().addAll("Бери",
                    "У меня нет времени",
                    "Легенды нет");
        });

        buttonIconKing.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewTek.getItems().clear();
            listViewTek.getItems().addAll("Ааррррхх",
                    "РррАархх",
                    "Ррррр");
        });

        buttonIconBat.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewJL.getItems().clear();
            listViewJL.getItems().addAll("Решение",
                    "Если сделано",
                    "Что-то веселое");
        });

        buttonIconFlash.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewJL.getItems().clear();
            listViewJL.getItems().addAll("Поймай меня",
                    "Хей",
                    "Нужен перерыв");
        });

        buttonIconGreen.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewJL.getItems().clear();
            listViewJL.getItems().addAll("Днем ярко",
                    "Снова угадал",
                    "Нужен питстоп");
        });

        buttonIconJoke.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewJL.getItems().clear();
            listViewJL.getItems().addAll("Спускайся",
                    "Нет идей",
                    "Почему такой серьезный");
        });

        buttonIconSuper.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewJL.getItems().clear();
            listViewJL.getItems().addAll("Дубликат",
                    "Делай выбор",
                    "Двигай");
        });

        playButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            new Music();

        });

        stopButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            getClip().stop();

        });

        volUpButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (volSound>0)
            volViewField.setText(String.valueOf(--volSound));

        });

        volDownButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (volSound<100)
            volViewField.setText(String.valueOf(++volSound));

        });


        nextPaneButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            listViewMK.getItems().clear();
            listViewJL.getItems().clear();
            listViewTek.getItems().clear();
            switchPane(mkPane, tekPane, jlPane);
        });

    }

    @Override
    public void onConnectionReady(Connection connection) {
        printMeg("Connection ready...");
    }

    @Override
    public void onRecieveString(Connection connection, String value) {
        printMeg(value);
    }

    @Override
    public void onDisconnect(Connection connection) {
        printMeg("Connection close");
    }

    @Override
    public void onException(Connection connection, Exception e) {
        printMeg("Connection exception "+e);

    }

    private synchronized void printMeg(String msg) {
            chatField.appendText(msg + "\n");
                //log.append(msg + "\n");
                //log.setCaretPosition(log.getDocument().getLength());
            }


    class Music implements Runnable {
        Thread threadMus;

        Music() {
            threadMus = new Thread(this, "MusicThread");
            threadMus.start();

        }

        public Thread getThreadMus() {
            return threadMus;
        }
        @Override
        public void run() {
            if(mkPane.isVisible()) {
                switch ((listViewMK.getSelectionModel().getSelectedItem())) {
                    case ("Насилие порождает насилие"):
                        Sound.playSound("src/sample/sounds/mk/subzero/nasilie_porozhdaet_nasilie.wav").join();
                        break;
                    case ("Тебе не победить"):
                        Sound.playSound("src/sample/sounds/mk/subzero/tebe_ne_sbezhat.wav").join();
                        break;
                    case ("Тебе не сбежать"):
                        Sound.playSound("src/sample/sounds/mk/subzero/ti_ne_mozhesh_pobedit.wav").join();
                        break;
                    case ("Мне это надоедает"):
                        Sound.playSound("src/sample/sounds/mk/scorpion/mne_eto_nadoedaet.wav").join();
                        break;
                    case ("Узри мою мощь"):
                        Sound.playSound("src/sample/sounds/mk/scorpion/uzri_mou_moszh.wav").join();
                        break;
                    case ("Возвращайся в ад"):
                        Sound.playSound("src/sample/sounds/mk/scorpion/vozvraschaisya_v_ad.wav").join();
                        break;
                    case ("Выбери свою судьбу"):
                        Sound.playSound("src/sample/sounds/mk/shaokan/ChooseYourDestiny.wav").join();
                        break;
                    case ("Фаталити"):
                        Sound.playSound("src/sample/sounds/mk/shaokan/Fatality.wav").join();
                        break;
                    case ("Чистая победа"):
                        Sound.playSound("src/sample/sounds/mk/shaokan/FlawlessVictory.wav").join();
                        break;
                    case ("Ограничение безгранично"):
                        Sound.playSound("src/sample/sounds/mk/baraka/predel_predela.wav").join();
                        break;
                    case ("Ты не сможешь победить"):
                        Sound.playSound("src/sample/sounds/mk/baraka/tebe_ne_pobedit.wav").join();
                        break;
                    case ("Ты останешься без сердца"):
                        Sound.playSound("src/sample/sounds/mk/baraka/ti_ostaneshsya_bez_serdca.wav").join();
                        break;
                    case ("Служи и живи"):
                        Sound.playSound("src/sample/sounds/mk/shinok/sluzhi_i_zhivi.wav").join();
                        break;
                    case ("Смерть зовет"):
                        Sound.playSound("src/sample/sounds/mk/shinok/smert_zovet.wav").join();
                        break;
                    case ("Страх в сердце"):
                        Sound.playSound("src/sample/sounds/mk/shinok/strah_v_serdce.wav").join();
                        break;
                }
            } else if(jlPane.isVisible()) {
                switch ((listViewJL.getSelectionModel().getSelectedItem())) {
                    case ("Решение"):
                        Sound.playSound("src/sample/sounds/jl/bat/Decision.wav").join();
                        break;
                    case ("Если сделано"):
                        Sound.playSound("src/sample/sounds/jl/bat/If_done.wav").join();
                        break;
                    case ("Что-то веселое"):
                        Sound.playSound("src/sample/sounds/jl/bat/Something_funny.wav").join();
                        break;
                    case ("Поймай меня"):
                        Sound.playSound("src/sample/sounds/jl/flash/Catch_me.wav").join();
                        break;
                    case ("Хей"):
                        Sound.playSound("src/sample/sounds/jl/flash/Hey.wav").join();
                        break;
                    case ("Нужен перерыв"):
                        Sound.playSound("src/sample/sounds/jl/flash/Need_a_brake.wav").join();
                        break;
                    case ("Днем ярко"):
                        Sound.playSound("src/sample/sounds/jl/green/Bright_is_day.wav").join();
                        break;
                    case ("Снова угадал"):
                        Sound.playSound("src/sample/sounds/jl/green/Guess_again.wav").join();
                        break;
                    case ("Нужен питстоп"):
                        Sound.playSound("src/sample/sounds/jl/green/Need_a_pitstop.wav").join();
                        break;
                    case ("Спускайся"):
                        Sound.playSound("src/sample/sounds/jl/joke/Come_down.wav").join();
                        break;
                    case ("Нет идей"):
                        Sound.playSound("src/sample/sounds/jl/joke/Not_idea.wav").join();
                        break;
                    case ("Почему такой серьезный"):
                        Sound.playSound("src/sample/sounds/jl/joke/Why_so_serious.wav").join();
                        break;
                    case ("Дубликат"):
                        Sound.playSound("src/sample/sounds/jl/superman/Dublicate.wav").join();
                        break;
                    case ("Делай выбор"):
                        Sound.playSound("src/sample/sounds/jl/superman/Make_a_choice.wav").join();
                        break;
                    case ("Двигай"):
                        Sound.playSound("src/sample/sounds/jl/superman/To_moving.wav").join();
                        break;
                }
            } else if(tekPane.isVisible()) {
                switch ((listViewTek.getSelectionModel().getSelectedItem())) {
                    case ("Давай"):
                        Sound.playSound("src/sample/sounds/tek/fury/Come_on.wav").join();
                        break;
                    case ("Хахаха"):
                        Sound.playSound("src/sample/sounds/tek/fury/Hahaha.wav").join();
                        break;
                    case ("Омае"):
                        Sound.playSound("src/sample/sounds/tek/fury/Omae.wav").join();
                        break;
                    case ("Чидорика"):
                        Sound.playSound("src/sample/sounds/tek/hei/Chidoirka_a_a.wav").join();
                        break;
                    case ("Киётока"):
                        Sound.playSound("src/sample/sounds/tek/hei/Kyotoka.wav").join();
                        break;
                    case ("Сарузи дана"):
                        Sound.playSound("src/sample/sounds/tek/hei/Saruzi_dana.wav").join();
                        break;
                    case ("Везде"):
                        Sound.playSound("src/sample/sounds/tek/how/all_zone.wav").join();
                        break;
                    case ("Никогда"):
                        Sound.playSound("src/sample/sounds/tek/how/i_never.wav").join();
                        break;
                    case ("Твой конец здесь"):
                        Sound.playSound("src/sample/sounds/tek/how/ur_finally_here.wav").join();
                        break;
                    case ("Бери"):
                        Sound.playSound("src/sample/sounds/tek/jin/T6Jin_HandleThis.wav").join();
                        break;
                    case ("У меня нет времени"):
                        Sound.playSound("src/sample/sounds/tek/jin/T6Jin_IDontHaveTimeForThis.wav").join();
                        break;
                    case ("Легенды нет"):
                        Sound.playSound("src/sample/sounds/tek/jin/T6Jin_LegendWrong.wav").join();
                        break;
                    case ("Ааррррхх"):
                        Sound.playSound("src/sample/sounds/tek/king/Aarrrrhh!.wav").join();
                        break;
                    case ("РррАархх"):
                        Sound.playSound("src/sample/sounds/tek/king/RrrAArhh.wav").join();
                        break;
                    case ("Ррррр"):
                        Sound.playSound("src/sample/sounds/tek/king/Rrrrr.wav").join();
                        break;
                }
            }
        }


    }



}
