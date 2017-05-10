package it.polito.tdp.metrodeparis;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import it.polito.tdp.metrodeparis.model.Fermata;
import it.polito.tdp.metrodeparis.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import java.util.*;

public class MetroDeParisController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Fermata> cmbPartenza;

    @FXML
    private ComboBox<Fermata> cmbArrivo;

    @FXML
    private Button btnPercorso;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCalcolaPercorso(ActionEvent event) throws SQLException {
    	txtResult.setText(model.calcolaPercorso(cmbPartenza.getValue(), cmbArrivo.getValue()));
    }


    @FXML
    void initialize() {
        assert cmbPartenza != null : "fx:id=\"cmbPartenza\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
        assert cmbArrivo != null : "fx:id=\"cmbArrivo\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
        assert btnPercorso != null : "fx:id=\"btnPercorso\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'MetroDeParis.fxml'.";

    }

	public void setModel(Model model) {
		// TODO Auto-generated method stub
		this.model = model;
    	cmbPartenza.getItems().addAll(model.getFermate());
    	cmbArrivo.getItems().addAll(model.getFermate());
	}
    
    
}



/*
List<Country> raggiungibili = model.getRaggiungibili(partenza) ;

txtResult.appendText(raggiungibili.toString()+"\n");

boxDestinazione.getItems().clear(); 
boxDestinazione.getItems().addAll(raggiungibili) ;
*/