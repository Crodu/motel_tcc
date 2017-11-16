package javaFx.telas.loading;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Lurguers
 */
public class TelaLoadingController implements Initializable{
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private ProgressBar progress;
    
    @FXML
    private Label label;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new LoadScreen().start();
    }
    
    class LoadScreen extends Thread {
        
        @Override
        public void run(){

            try {
                    Thread.sleep(2000);
                    
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Parent parent = null;
                                try {
                                    parent = FXMLLoader.load(getClass().getClassLoader().getResource("javaFx/telas/login/TelaLoginFXML.fxml"));
                                } catch (IOException ex) {
                                    Logger.getLogger(TelaLoadingController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            Scene scene = new Scene(parent);
                            Stage stage = new Stage();

                            stage.initStyle(StageStyle.UNDECORATED);
                            stage.setScene(scene);
                            stage.show();
                            
                            rootPane.getScene().getWindow().hide();
                        }
                    });
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaLoadingController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
        }
        
        
    }
    
    

