package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblErrore"
    private Label lblErrore; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    Model model=new Model();
    
    @FXML
    void doAnagrammi(ActionEvent event) {
    	String parola=txtParola.getText();
    	txtParola.clear();
    	lblErrore.setText("");
    	txtCorretti.clear();
    	txtErrati.clear();
    	
    	if(parola.length()==0) {
    		lblErrore.setText("Inserire parola");
    	} else {
    		List<String> anagrammi=new LinkedList<String>(model.anagrammi(parola));
    		for(String s : anagrammi) {
    			if(model.isCorrect(s))
    				txtCorretti.appendText(s+"\n");
    			else
    				txtErrati.appendText(s+"\n");
    		}
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    	lblErrore.setText("");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblErrore != null : "fx:id=\"lblErrore\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }

}
