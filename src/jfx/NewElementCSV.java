package jfx;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.ChargementDonneesUtil;
import main.Iris;
import main.Pokemon;
import main.Titanic;

public class NewElementCSV {

	// Pokemon
	static String namePk;
	@FXML
	TextField namePField;
	@FXML
	TextField attField;
	@FXML
	TextField besField;
	@FXML
	TextField crField;
	@FXML
	TextField defField;
	@FXML
	TextField egField;
	@FXML
	TextField hpField;
	@FXML
	TextField saField;
	@FXML
	TextField sdField;
	@FXML
	TextField t1Field;
	@FXML
	TextField t2Field;
	@FXML
	TextField speedField;
	@FXML
	Button createPokemon;
	List<Pokemon> dataP = null;

	// Titanic
	static String nameT;
	@FXML
	TextField pcField;
	@FXML
	TextField nameTField;
	@FXML
	TextField sexField;
	@FXML
	TextField ageField;
	@FXML
	TextField ssField;
	@FXML
	TextField parchField;
	@FXML
	TextField fareField;
	@FXML
	Button createTitanic;
	List<Titanic> dataT = null;

	// Iris
	@FXML
	TextField plField;
	@FXML
	TextField pwField;
	@FXML
	TextField slField;
	@FXML
	TextField swField;
	@FXML
	Button createIris;
	List<Iris> dataI = null;

	public void createNewPokemon(ActionEvent e) throws IOException {
		namePk = namePField.getText();
		Pokemon nouveau = new Pokemon(namePField.getText(), Integer.parseInt(attField.getText()), Integer.parseInt(besField.getText()),
				Double.parseDouble(crField.getText()), Integer.parseInt(defField.getText()),
				Integer.parseInt(egField.getText()), Integer.parseInt(hpField.getText()),
				Integer.parseInt(saField.getText()), Integer.parseInt(sdField.getText()), t1Field.getText(), t2Field.getText(),
				Double.parseDouble(speedField.getText()), false);
		Controller.dataP.add(nouveau);
		Controller.stageAdd.close();
	}

	public void createNewPassenger(ActionEvent e) throws IOException {
		nameT = nameTField.getText();
		Titanic nouveau = new Titanic(Controller.dataT.size() + 1, false, Integer.parseInt(pcField.getText()), nameTField.getText(), sexField.getText(),
				Double.parseDouble(ageField.getText()), Integer.parseInt(ssField.getText()),
				Integer.parseInt(parchField.getText()), "", Double.parseDouble(fareField.getText()), "", ' ');
		Controller.dataT.add(nouveau);
		Controller.stageAdd.close();
	}
	
	public void createNewIris(ActionEvent e) throws IOException {
		Controller.dataI = ChargementDonneesUtil.chargerIris("ressources/csv/iris.csv");
		Iris nouveau = new Iris(Double.parseDouble(plField.getText()), Double.parseDouble(pwField.getText()),
				Double.parseDouble(slField.getText()), Double.parseDouble(swField.getText()), "");
		Controller.dataI.add(nouveau);
		Controller.stageAdd.close();
	}

}
