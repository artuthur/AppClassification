package jfx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import main.ChargementDonneesUtil;
import main.Iris;
import main.MethodeKnn;
import main.Pokemon;
import main.Titanic;

public class Controller {

	@FXML
	MenuButton colX;
	@FXML
	MenuButton colY;
	@FXML
	ListView<String> listViewCSV;
	@FXML
	ScatterChart<Double, Double> scatterChart;
	@FXML
	NumberAxis numberAxisX;
	@FXML
	NumberAxis numberAxisY;
	@FXML
	MenuItem openCSVP;
	@FXML
	MenuItem openCSVT;
	@FXML
	MenuItem openCSVI;
	@FXML
	MenuItem saveCSV;
	@FXML
	MenuItem addPoint;
	@FXML
	static Stage stage;
	@FXML
	Button load;
	@FXML
	Button classi;
	@FXML
	MenuItem x1;
	@FXML
	MenuItem x2;
	@FXML
	MenuItem x3;
	@FXML
	MenuItem x4;
	@FXML
	MenuItem x5;
	@FXML
	MenuItem x6;
	@FXML
	MenuItem x7;
	@FXML
	MenuItem x8;
	@FXML
	MenuItem x9;
	@FXML
	MenuItem y1;
	@FXML
	MenuItem y2;
	@FXML
	MenuItem y3;
	@FXML
	MenuItem y4;
	@FXML
	MenuItem y5;
	@FXML
	MenuItem y6;
	@FXML
	MenuItem y7;
	@FXML
	MenuItem y8;
	@FXML
	MenuItem y9;
	MenuItem x5tmp;
	MenuItem x6tmp;
	MenuItem x7tmp;
	MenuItem x8tmp;
	MenuItem x9tmp;
	MenuItem y5tmp;
	MenuItem y6tmp;
	MenuItem y7tmp;
	MenuItem y8tmp;
	MenuItem y9tmp;
	int xAxex = 1;
	int yAxey = 1;
	final static FileChooser fileChooser = new FileChooser();
	public static List<MenuItem> itemsX;
	public static List<MenuItem> itemsY;
	MenuItem[] selectedItem = new MenuItem[2];
	static Stage stageAdd;
	static List<Pokemon> dataP = null;
	static List<Titanic> dataT = null;
	static List<Iris> dataI = null;

	public void initialize() {
		System.out.println("Initialisation ...");
	}

	static File fileExtractor() {
		fileChooser.setTitle("Open a CSV File");
		fileChooser.setInitialDirectory(new File("ressources/csv/"));
		fileChooser.getExtensionFilters().add(new ExtensionFilter("CSV Files", "*.csv"));
		File file = fileChooser.showOpenDialog(stage);
		return file;
	}

	public void openCsvFilePokemon(ActionEvent e) throws IOException, ClassNotFoundException {
		System.out.println("Open Pokemon");
		dataP = null;
		dataT = null;
		dataI = null;
		clear();
		File file = fileExtractor();
		if (file != null) {
			dataP = ChargementDonneesUtil.chargerPokemon(file.getCanonicalPath());
			initializeListView(file, dataP, Pokemon.ATTRIBUTSALL);
			initializeColY(dataP, Pokemon.ATTRIBUTS);
			initializeColX(dataP, Pokemon.ATTRIBUTS);
		}
	}

	public void openCsvFileTitanic(ActionEvent e) throws IOException, ClassNotFoundException {
		System.out.println("Open Titanic");
		dataP = null;
		dataT = null;
		dataI = null;
		clear();
		File file = fileExtractor();
		if (file != null) {
			dataT = ChargementDonneesUtil.chargerTitanic(file.getCanonicalPath());
			initializeListView(file, dataT, Titanic.ATTRIBUTSALL);
			initializeColY(dataT, Titanic.ATTRIBUTS);
			initializeColX(dataT, Titanic.ATTRIBUTS);
		}
	}

	public void openCsvFileIris(ActionEvent e) throws IOException, ClassNotFoundException {
		System.out.println("Open Iris");
		dataP = null;
		dataT = null;
		dataI = null;
		clear();
		File file = fileExtractor();
		if (file != null) {
			dataI = ChargementDonneesUtil.chargerIris(file.getCanonicalPath());
			initializeListView(file, dataI, Iris.ATTRIBUTS);
			initializeColY(dataI, Iris.ATTRIBUTS);
			initializeColX(dataI, Iris.ATTRIBUTS);
		}
	}

	public void initializeListView(File file, List<?> data, String[] att) {
		if (listViewCSV == null)
			listViewCSV = new ListView<String>();
		listViewCSV.getItems().add(file.getName());
		listViewCSV.getItems().add(data.size() + " elements");
		for (int i = 0; i < att.length; i++)
			listViewCSV.getItems().add(att[i]);
	}

	public void clicColX(ActionEvent e) {
		xAxex = Integer.parseInt(((MenuItem) e.getSource()).getId().substring(1));
		colX.setText(((MenuItem) e.getSource()).getText());
	}

	public void clicColY(ActionEvent e) {
		yAxey = Integer.parseInt(((MenuItem) e.getSource()).getId().substring(1));
		colY.setText(((MenuItem) e.getSource()).getText());
	}

	public void initializeColX(List<?> data, String[] att) throws IOException {
		if (x5 != null && x6 != null && x7 != null && x8 != null && x9 != null) {
			x5tmp = x5;
			x6tmp = x6;
			x7tmp = x7;
			x8tmp = x8;
			x9tmp = x9;
		}
		if (x5 == null) {
			x5 = x5tmp;
			x6 = x6tmp;
		}
		if (x7 == null) {
			x7 = x7tmp;
			x8 = x8tmp;
			x9 = x9tmp;
		}
		int decal = 0;
		if (Controller.dataT != null)
			decal = 3;
		else if (Controller.dataI != null)
			decal = 5;
		Controller.itemsX = new ArrayList<MenuItem>();
		itemsX.add(x1);
		itemsX.add(x2);
		itemsX.add(x3);
		itemsX.add(x4);
		if ((dataP != null || dataT != null) && dataI == null) {
			itemsX.add(x5);
			itemsX.add(x6);
		}
		if (dataP != null && dataT == null && dataI == null) {
			itemsX.add(x7);
			itemsX.add(x8);
			itemsX.add(x9);
		}
		if (dataI != null) {
			x5 = null;
			x6 = null;
		}
		if (dataI != null || dataT != null) {
			x7 = null;
			x8 = null;
			x9 = null;
		}
		for (int i = 0; i < att.length - decal; i++)
			itemsX.get(i).setText(att[i]);
		colX.getItems().addAll(itemsX);
	}

	public void initializeColY(List<?> data, String[] att) throws IOException {
		if (y5 != null && y6 != null && y7 != null && y8 != null && y9 != null) {
			y5tmp = y5;
			y6tmp = y6;
			y7tmp = y7;
			y8tmp = y8;
			y9tmp = y9;
		}
		if (y5 == null) {
			y5 = y5tmp;
			y6 = y6tmp;
		}
		if (y7 == null) {
			y7 = y7tmp;
			y8 = y8tmp;
			y9 = y9tmp;
		}
		int decal = 0;
		if (Controller.dataT != null)
			decal = 3;
		else if (Controller.dataI != null)
			decal = 5;
		Controller.itemsY = new ArrayList<MenuItem>();
		itemsY.add(y1);
		itemsY.add(y2);
		itemsY.add(y3);
		itemsY.add(y4);
		if ((dataP != null || dataT != null) && dataI == null) {
			itemsY.add(y5);
			itemsY.add(y6);
		}
		if (dataP != null && dataT == null && dataI == null) {
			itemsY.add(y7);
			itemsY.add(y8);
			itemsY.add(y9);
		}
		if (dataI != null) {
			y5 = null;
			y6 = null;
		}
		if (dataI != null || dataT != null) {
			y7 = null;
			y8 = null;
			y9 = null;
		}
		for (int i = 0; i < att.length - decal; i++)
			itemsY.get(i).setText(att[i]);
		colY.getItems().addAll(itemsY);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void afficheCloudPokemon(List<Pokemon> data, int x, int y) {
		XYChart.Series seriesAdd = null;
		XYChart.Series seriesLeg = new XYChart.Series();
		seriesLeg.setName("Legendaire");
		XYChart.Series seriesNotLeg = new XYChart.Series();
		seriesNotLeg.setName("Normal");
		numberAxisX.setLabel(Pokemon.ATTRIBUTS[x - 1]);
		numberAxisY.setLabel(Pokemon.ATTRIBUTS[y - 1]);
		colX.setText(Pokemon.ATTRIBUTS[x - 1]);
		colY.setText(Pokemon.ATTRIBUTS[y - 1]);
		for (Pokemon p : data) {
			if (!p.name.equals(NewElementCSV.namePk)) {
				if (p.isLegendary)
					seriesLeg.getData().add(new XYChart.Data(p.getAttributs(x) + 0.0, p.getAttributs(y) + 0.0));
				else
					seriesNotLeg.getData().add(new XYChart.Data(p.getAttributs(x) + 0.0, p.getAttributs(y) + 0.0));
			} else {
				seriesAdd = new XYChart.Series();
				seriesAdd.setName(NewElementCSV.namePk);
				seriesAdd.getData().add(new XYChart.Data(p.getAttributs(x) + 0.0, p.getAttributs(y) + 0.0));
			}
		}
		scatterChart.getData().addAll(seriesNotLeg, seriesLeg);
		if (seriesAdd != null)
			scatterChart.getData().add(seriesAdd);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void afficheCloudTitanic(List<Titanic> data, int x, int y) {
		XYChart.Series seriesAdd = null;
		XYChart.Series seriesAlive = new XYChart.Series();
		seriesAlive.setName("Survived");
		XYChart.Series seriesDeath = new XYChart.Series();
		seriesDeath.setName("Dead");
		numberAxisX.setLabel(Titanic.ATTRIBUTS[x - 1]);
		numberAxisY.setLabel(Titanic.ATTRIBUTS[y - 1]);
		colX.setText(Titanic.ATTRIBUTS[x - 1]);
		colY.setText(Titanic.ATTRIBUTS[y - 1]);
		for (Titanic t : data) {
			if (!t.name.equals(NewElementCSV.nameT)) {
				if (t.survived)
					seriesAlive.getData().add(new XYChart.Data(t.getAttributs(x) + 0.0, t.getAttributs(y) + 0.0));
				else
					seriesDeath.getData().add(new XYChart.Data(t.getAttributs(x) + 0.0, t.getAttributs(y) + 0.0));
			} else {
				seriesAdd = new XYChart.Series();
				seriesAdd.setName(NewElementCSV.nameT);
				seriesAdd.getData().add(new XYChart.Data(t.getAttributs(x) + 0.0, t.getAttributs(y) + 0.0));
			}
		}
		scatterChart.getData().addAll(seriesDeath, seriesAlive);
		if (seriesAdd != null)
			scatterChart.getData().add(seriesAdd);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void afficheCloudIris(List<Iris> data, int x, int y) {
		XYChart.Series seriesSetosa = new XYChart.Series();
		seriesSetosa.setName("Setosa");
		XYChart.Series seriesVirginica = new XYChart.Series();
		seriesVirginica.setName("Virginica");
		XYChart.Series seriesVersicolor = new XYChart.Series();
		seriesVersicolor.setName("Versicolor");
		numberAxisX.setLabel(Iris.ATTRIBUTS[x - 1]);
		numberAxisY.setLabel(Iris.ATTRIBUTS[y - 1]);
		colX.setText(Iris.ATTRIBUTS[x - 1]);
		colY.setText(Iris.ATTRIBUTS[y - 1]);
		for (Iris i : data) {
			if (i.variety.equals("Setosa"))
				seriesSetosa.getData().add(new XYChart.Data(i.getAttributs(x) + 0.0, i.getAttributs(y) + 0.0));
			else if (i.variety.equals("Virginica"))
				seriesVirginica.getData().add(new XYChart.Data(i.getAttributs(x) + 0.0, i.getAttributs(y) + 0.0));
			else
				seriesVersicolor.getData().add(new XYChart.Data(i.getAttributs(x) + 0.0, i.getAttributs(y) + 0.0));
		}
		scatterChart.getData().addAll(seriesSetosa, seriesVirginica, seriesVersicolor);
	}

	public void classElement() throws IOException {
		if (dataT == null && dataI == null && dataP != null) {
			MethodeKnn mkk = new MethodeKnn(Controller.dataP);
			for (Pokemon p : dataP) {
				if (p.name.equals(NewElementCSV.namePk)) {
					boolean isLeg = mkk.isLegendary(5, p);
					p.isLegendary = isLeg;
					System.out.println(p);
				}
			}
		}
		if (dataT != null && dataI == null && dataP == null) {
			MethodeKnn mkk = new MethodeKnn(Controller.dataT);
			for (Titanic t : dataT) {
				if (!t.name.equals(NewElementCSV.nameT)) {
					boolean hasSurvived = mkk.whoSurvive(5, t);
					t.survived = hasSurvived;
					System.out.println(t);
				}
			}
		}
	}

	public void loadButton() {
		scatterChart.getData().clear();
		if (dataT == null && dataI == null && dataP != null)
			afficheCloudPokemon(dataP, xAxex, yAxey);
		if (dataP == null && dataI == null && dataT != null)
			afficheCloudTitanic(dataT, xAxex, yAxey);
		if (dataT == null && dataP == null && dataI != null)
			afficheCloudIris(dataI, xAxex, yAxey);
	}

	public void addNewButton() throws IOException {
		stageAdd = new Stage();
		FXMLLoader loader = new FXMLLoader();
		URL fxmlFileUr = null;
		if (dataT == null && dataI == null && dataP != null)
			fxmlFileUr = getClass().getResource("pokemon.fxml");
		if (dataP == null && dataI == null && dataT != null)
			fxmlFileUr = getClass().getResource("titanic.fxml");
		if (dataT == null && dataP == null && dataI != null)
			fxmlFileUr = getClass().getResource("iris.fxml");

		if (fxmlFileUr == null)
			System.out.println("Impossible de charger le fichier fxml");
		loader.setLocation(fxmlFileUr);
		Parent root = loader.load();

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stageAdd.setScene(scene);
		stageAdd.setTitle("Add Element");
		stageAdd.setResizable(false);
		stageAdd.show();
	}

	public void clear() {
		listViewCSV.getItems().clear();
		colX.getItems().clear();
		colY.getItems().clear();
		scatterChart.getData().clear();
	}

}