/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.telas.principal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.regexp.internal.REDebugCompiler;
import hibernate.Dao;
import static java.awt.Color.RED;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;
import objetos.Funcionario;
import objetos.MaskFieldUtil;
import objetos.Produto;

/**
 *
 * @author Lurguers
 */
public class principalController implements Initializable{
    
    public Dao d;
    
    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnCadProd;
    @FXML
    private JFXButton btnConsProd;
    @FXML
    private JFXButton btnCadFunc;
      
    @FXML
    private Pane consulProd;
    @FXML
    private Pane cadprodu;
    @FXML
    private JFXButton btnCad;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private Label notCod;
    @FXML
    private Label notNome;
    @FXML
    private Label notQtdEstoq;
    @FXML
    private Label notPrecoCompra;
    @FXML
    private Label notPrecoVenda;
    @FXML
    private Label notDesc;
    @FXML
    private Label notUni;
    @FXML
    private Label Notificacao;
    @FXML
    private JFXTextField cod;
    @FXML
    private JFXTextField nome;
    @FXML
    private JFXTextField qtdEstoq;
    @FXML
    private JFXTextField precoCompra;
    @FXML
    private JFXTextField precoVenda;
    @FXML
    private JFXTextField desc;
    @FXML
    private JFXTextField unid;
    @FXML
    private Pane quartos;
    @FXML
    private Label nomeLogado;
    @FXML
    private Pane cadFuncionario;
    @FXML
    private JFXTextField nomeFunc;
    @FXML
    private JFXTextField cpfFunc;
    @FXML
    private JFXTextField telFunc;
    @FXML
    private JFXTextField salarioFunc;
    @FXML
    private JFXTextField emailFunc;
    @FXML
    private JFXComboBox<Label> boxCargos;
    @FXML
    private JFXTextField userFunc;
    @FXML
    private JFXPasswordField senhaFunc;
    @FXML
    private JFXPasswordField confirmSenhaFunc;
    @FXML
    private JFXTextField cepFunc;
    @FXML
    private JFXTextField enderecoFunc;
    @FXML
    private JFXTextField cidFunc;
    @FXML
    private JFXTextField bairroFunc;
    @FXML
    private JFXTextField ufFunc;
    @FXML
    private JFXTextField descFunc;
    @FXML
    private JFXTextField numFunc;
    @FXML
    private JFXButton btnCadFuncionario;
    @FXML
    private JFXButton btnLimparFunc;
    @FXML
    private Label notnomeFunc;
    @FXML
    private Label notcpfFunc;
    @FXML
    private Label notTelFunc;
    @FXML
    private Label notSalFunc;
    @FXML
    private Label notUserFunc;
    @FXML
    private Label notSenhaFunc;
    @FXML
    private Label notSenhaFuncConfirmada;
    @FXML
    private Label notcepFunc;
    @FXML
    private Label notnumerocasaFunc;
    @FXML
    private Label Notificacao1;
    @FXML
    private Label NotificacaoSenhas;
    
    @FXML
    private Button btnBuscaProdID;
    @FXML
    private Button btnBuscaProdNome;  
    @FXML
    private JFXTextField txtCodProd;
    @FXML
    private JFXTextField txtNomeProd;
    @FXML
    private TableView<Produto> tabelaProdutos;
    @FXML
    private TableColumn<Produto, Integer> colid;
    @FXML
    private TableColumn<Produto, String> colcodigo;
    @FXML
    private TableColumn<Produto, String> colnome;
    @FXML
    private TableColumn<Produto, String> coldesc;
    @FXML
    private TableColumn<Produto, Float> colvalcompra;
    @FXML
    private TableColumn<Produto, Float> colvalvenda;
    @FXML
    private TableColumn<Produto, Integer> colqtdestoque;
    @FXML
    private TableColumn<Produto, String> colunidade;
    @FXML
    private Label lblStatusConProd;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //seta o combobox de cargos do cadastro de funcionario
        boxCargos.getItems().add(new Label("Limpeza"));
        boxCargos.getItems().add(new Label("Controle"));
        boxCargos.getItems().add(new Label("Adiministrador"));
        boxCargos.getSelectionModel().select(1);
        //seta para home aparecer quando iniciar
        quartos.setVisible(true);
        cadprodu.setVisible(false);
        consulProd.setVisible(false);
        cadFuncionario.setVisible(false);
        //seta o nome do usuario logado na label
        d = new Dao();
        List<Funcionario> funcionarioLogado = d.consultar(Funcionario.class, "logado", true);
        nomeLogado.setText("Bem vindo, "+funcionarioLogado.get(0).getNome()+".");
        //valida os campos do cadastro de produtos
        MaskFieldUtil.monetaryField(precoCompra);
        MaskFieldUtil.monetaryField(precoVenda);
        MaskFieldUtil.numericField(qtdEstoq);
        MaskFieldUtil.numericField(cod);
        //valida os campos do cadastro de funionarios
        MaskFieldUtil.cepField(cepFunc);
        MaskFieldUtil.cpfField(cpfFunc);
        MaskFieldUtil.foneField(telFunc);
        MaskFieldUtil.monetaryField(salarioFunc);
        MaskFieldUtil.onlyAlfaNumericValue(numFunc);
        
        colid.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        colqtdestoque.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQtdEstoque()).asObject());
        
        colvalcompra.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getValorCompra()).asObject());
        colvalvenda.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getValorVenda()).asObject());
        
        colcodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        colnome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
        coldesc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescricao()));
        colunidade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUnidade()));
        
        
        
        
    }
    
    @FXML
    private void btnBuscaProdIdClick(ActionEvent event){
        List<Produto> result = d.consultar(Produto.class, "codigo", txtCodProd.getText());
        if (result.isEmpty()){
            lblStatusConProd.setText("Nenhum produto encontrado.");
        }else{            
            ObservableList<Produto> obsresult = FXCollections.observableArrayList(result);
            tabelaProdutos.setItems(obsresult);
        }
        
    }
    @FXML
    private void btnBuscaProdNomeClick(ActionEvent event){
        List<Produto> result = d.consultarlike(Produto.class, "nome", txtNomeProd.getText());
        if (result.isEmpty()){
            lblStatusConProd.setText("Nenhum produto encontrado.");
        }else{            
            ObservableList<Produto> obsresult = FXCollections.observableArrayList(result);
            tabelaProdutos.setItems(obsresult);
        }
    }
    
    @FXML
    private void homeClick(ActionEvent event){
        quartos.setVisible(true);
        cadprodu.setVisible(false);
        consulProd.setVisible(false);
        cadFuncionario.setVisible(false);
    }
    @FXML
    private void cadProdClick(ActionEvent event){
        cadprodu.setVisible(true);
        quartos.setVisible(false);
        consulProd.setVisible(false);
        cadFuncionario.setVisible(false);
    }
    @FXML
    private void consultPrdoClick(ActionEvent event){
        consulProd.setVisible(true);
        quartos.setVisible(false);
        cadprodu.setVisible(false);
        cadFuncionario.setVisible(false);
    }
    @FXML
    public void cadFunciClick(ActionEvent event){
        consulProd.setVisible(false);
        quartos.setVisible(false);
        cadprodu.setVisible(false);
        cadFuncionario.setVisible(true);
    }
    @FXML    
    private void exitbuttonclick(MouseEvent event) {
        Dao d = new Dao();
        List<Funcionario> funcionarioLogado = d.consultar(Funcionario.class, "logado", true);
        funcionarioLogado.get(0).setLogado(false);
        d.inserir(funcionarioLogado.get(0));
        System.exit(0);
        
    }
    @FXML
    private void cadButtonClick(ActionEvent event){
        if (cod.getText().isEmpty()) {
            notCod.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notCod.setText("");
        }
        
        if (nome.getText().isEmpty()){
            notNome.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notNome.setText("");
        }
        
        if (qtdEstoq.getText().isEmpty()){
            notQtdEstoq.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notQtdEstoq.setText("");
        }
        
        if (precoCompra.getText().isEmpty()){
            notPrecoCompra.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notPrecoCompra.setText("");
        }
        
        if (precoVenda.getText().isEmpty()){
            notPrecoVenda.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notPrecoVenda.setText("");
        }
        
        if (desc.getText().isEmpty()){
            notDesc.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notDesc.setText("");
        }
        
        if (unid.getText().isEmpty()){
            notUni.setText("*");
            Notificacao.setText("Prencha os campos destacados!");
        }else{
            notUni.setText("");
        }
        
        if (!(cod.getText().isEmpty() || nome.getText().isEmpty() ||qtdEstoq.getText().isEmpty() || precoCompra.getText().isEmpty() ||precoVenda.getText().isEmpty() || desc.getText().isEmpty()||unid.getText().isEmpty())) {
            try{
            String precocompra = precoCompra.getText();
            precocompra = precocompra.replace(".","");
            precocompra = precocompra.replace(",00","");
            precocompra = precocompra.replace(",",".");
            String precovenda = precoVenda.getText();
            precovenda = precovenda.replace(".","");
            precovenda = precovenda.replace(",00","");
            precovenda = precovenda.replace(",",".");
            Produto prod = new Produto(cod.getText(), nome.getText(), Integer.parseInt(qtdEstoq.getText()), Float.parseFloat(precocompra), Float.parseFloat(precovenda), desc.getText(), unid.getText());
            Dao dao = new Dao();
            dao.inserir(prod);
            JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!","Sucesso!",1);
            limpar(event);
            cod.focusedProperty();
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro! "+e, "Erro", 0);
            }
        }       
    }
    @FXML
    public void limpar(ActionEvent event){
        cod.setText("");
        nome.setText("");
        qtdEstoq.setText("");
        precoCompra.setText("");
        precoVenda.setText("");
        desc.setText("");
        unid.setText("");
        notCod.setText("");
        notNome.setText("");
        notQtdEstoq.setText("");
        notPrecoCompra.setText("");
        notPrecoVenda.setText("");
        notDesc.setText("");
        notUni.setText("");
        Notificacao.setText("");        
    }
    @FXML
    public void cadFuncClick(ActionEvent event){
        if (nomeFunc.getText().isEmpty()){
            notnomeFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notnomeFunc.setText("");
        }
        if (cpfFunc.getText().isEmpty()){
            notcpfFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notcpfFunc.setText("");
        }
        if (telFunc.getText().isEmpty()){
            notTelFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notTelFunc.setText("");
        }
        if (salarioFunc.getText().isEmpty()){
            notSalFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notSalFunc.setText("");
        }
        if (userFunc.getText().isEmpty()){
            notUserFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notUserFunc.setText("");
        }
        if (senhaFunc.getText().isEmpty()){
            notSenhaFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notSenhaFunc.setText("");
        }
        if (confirmSenhaFunc.getText().isEmpty()){
            notSenhaFuncConfirmada.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notSenhaFuncConfirmada.setText("");
        }
        if (cepFunc.getText().isEmpty()){
            notcepFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notcepFunc.setText("");
        }
        if (numFunc.getText().isEmpty()){
            notnumerocasaFunc.setText("*");
            Notificacao1.setText("Prencha os campos destacados!");
        }else{
            notnumerocasaFunc.setText("");
        }      
        if (!(nomeFunc.getText().isEmpty() || cpfFunc.getText().isEmpty() ||telFunc.getText().isEmpty() || salarioFunc.getText().isEmpty() ||userFunc.getText().isEmpty() || senhaFunc.getText().isEmpty()||confirmSenhaFunc.getText().isEmpty()||cepFunc.getText().isEmpty()|| numFunc.getText().isEmpty())){
            if (senhaFunc.getText().trim().equals(confirmSenhaFunc.getText().trim())) {
                try{
                String salariofuncionario = salarioFunc.getText();
                salariofuncionario = salariofuncionario.replace(".","");
                salariofuncionario = salariofuncionario.replace(",00","");
                salariofuncionario = salariofuncionario.replace(",",".");
                JOptionPane.showMessageDialog(null, salariofuncionario);
                Funcionario func = new Funcionario(nomeFunc.getText(),Float.parseFloat(salariofuncionario), emailFunc.getText(), telFunc.getText(), cpfFunc.getText(), userFunc.getText(), senhaFunc.getText(), cepFunc.getText(), enderecoFunc.getText(), bairroFunc.getText(), cidFunc.getText(), ufFunc.getText(), boxCargos.getSelectionModel().getSelectedIndex(), Integer.parseInt(numFunc.getText()), descFunc.getText());
                Dao dao = new Dao();
                dao.inserir(func);
                JOptionPane.showMessageDialog(null,"Funcionário cadastrado com sucesso!","Sucesso!",1);
                limparFunc(event);
                nomeFunc.focusedProperty();

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro! "+e, "Erro", 0);
                }
            }else{
                NotificacaoSenhas.setText("Senhas não coincidem!");
            }
        }       
    }
    @FXML
    public void limparFunc(ActionEvent event){
        nomeFunc.setText("");
        cpfFunc.setText("");
        telFunc.setText("");        
        salarioFunc.setText("");
        emailFunc.setText("");
        boxCargos.getSelectionModel().select(1);
        userFunc.setText("");
        senhaFunc.setText("");
        confirmSenhaFunc.setText("");
        cepFunc.setText("");
        enderecoFunc.setText("");
        cidFunc.setText("");
        bairroFunc.setText("");
        ufFunc.setText("");
        descFunc.setText("");
        numFunc.setText("");
        notnomeFunc.setText("");
        notcpfFunc.setText("");
        notTelFunc.setText("");
        notSalFunc.setText("");
        notUserFunc.setText("");
        notSenhaFunc.setText("");
        notSenhaFuncConfirmada.setText("");
        notcepFunc.setText("");
        notnumerocasaFunc.setText("");
        Notificacao1.setText("");
        NotificacaoSenhas.setText("");              
    }
}
