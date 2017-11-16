/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.telas.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import hibernate.Dao;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import objetos.Funcionario;

/**
 *
 * @author andre
 */
public class TelaLoginController implements Initializable {
      
    @FXML
    private Label labelstatus;
    
    @FXML
    private JFXTextField user;
    
    @FXML
    private JFXPasswordField pass;

    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        String usuario = user.getText().trim();
        String Senha = pass.getText().trim();
        Dao d = new Dao();
        List<Funcionario> func = d.consultar(Funcionario.class, "username", usuario);
        if (func.isEmpty()){
            labelstatus.setText("Usuário Incorreto!");
            System.out.println(func.get(0).getUsername());
        }else{
            if (func.get(0).getSenha().trim().equals(Senha.trim())) {
                func.get(0).setLogado(true);
                d.inserir(func.get(0));
                Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("javaFx/telas/principal/tela_principal.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }else{
                labelstatus.setText("Senha Incorreta!");
            }
        }
         
    }
    @FXML    
    private void exitbuttonclick(MouseEvent event) {

        System.exit(0);
        
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Dao d = new Dao();
        /*try {
            
            Parent parent = FXMLLoader.load(getClass().getResource("loading.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            for (int i = 0; i < 10000; i++) {
                System.out.println("a");
            }
            
            stage.hide();
        } catch (IOException ex) {
            Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }    
    
}
