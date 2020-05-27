package oblig4.B;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;


public class FXMain extends Application {
    TableView table = new TableView();
    Button add = new Button("add");
    Button delete = new Button("delete");
    Button upgrade = new Button("upgrade");
    private MemberArchive memberArchive = new MemberArchive();
    private ObservableList<BonusMember> oBonus;
    final HBox mainView = new HBox();
    final VBox vbox = new VBox();
    final HBox hBox = new HBox();
    Logger logger = Logger.getLogger(FXMain.class.getName());


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        babyBOM();
        oBonus = listifier();

        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        //stage.setWidth(100);
        stage.setHeight(500);
        stage.setResizable(true);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);
        table.setItems(oBonus);
        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        table.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if(mainView.getChildren().size() == 2){
                mainView.getChildren().remove(1);
            }else{
                stage.setWidth(stage.getWidth()+300);
            }
            viewMember();
        });



        add.setOnAction(e -> addAction());
        upgrade.setOnAction(e -> setUpgrade());
        delete.setOnAction(e -> {
            if(mainView.getChildren().size() == 2){
                mainView.getChildren().remove(1);
                stage.setWidth(300);
                deleteMember();
            }
        });



        TableColumn memberNo = new TableColumn("memberNo");
        TableColumn<BonusMember, String> lastName = new TableColumn("Surname");
        TableColumn<BonusMember, String> memberType = new TableColumn("Member Type");
        memberType.setMinWidth(100);

        memberNo.setCellValueFactory(new PropertyValueFactory<BonusMember, Integer>("MEMBER_NO"));

        memberType.setCellValueFactory(bonusMemberStringCellDataFeatures -> new SimpleStringProperty(bonusMemberStringCellDataFeatures.getValue().getClass().getSimpleName()));

        lastName.setCellValueFactory(bonus -> new SimpleStringProperty(bonus.getValue().getPERSONALS().getSurname()));

        table.getColumns().addAll(memberNo, lastName, memberType);


        hBox.getChildren().addAll(add, delete, upgrade);
        mainView.getChildren().addAll(table);
        vbox.setSpacing(5);
        vbox.setFillWidth(true);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label,hBox, mainView);


        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();


    }

    private void addAction() {
        Personals newDummy = new Personals("Dummy", "Dummy", "Dummy", "Dummy");
        memberArchive.newMember(newDummy, LocalDate.now());
        table.setItems(listifier());

    }

    private void setUpgrade(){
        memberArchive.checkMembers();
        table.setItems(listifier());
    }

    private void deleteMember(){
        if(table.getSelectionModel().getSelectedItem() == null){
            return;
        }
        memberArchive.getMemberHashMap().remove(((BonusMember)table.getSelectionModel().getSelectedItem()).getMEMBER_NO());
        memberArchive.getMemberArrayList().remove(table.getSelectionModel().getSelectedItem());
        table.setItems(listifier());
    }


    public ObservableList<BonusMember> listifier(){
        ObservableList<BonusMember> bonusMemberObservableList = FXCollections.observableList(new ArrayList<>(memberArchive.getMemberHashMap().values()));
        return bonusMemberObservableList;
    }
    public void babyBOM(){
        Personals ole = new Personals("Olsen", "Ole", "ole.olsen@dot.com", "ole");
        Personals tove = new Personals("Hansen", "Tove", "tove.hansen@dot.com", "tove");

        memberArchive.newMember(ole, LocalDate.of(2020, 1, 15));
        memberArchive.newMember(ole, LocalDate.of(2020, 1, 15));
        memberArchive.newMember(ole, LocalDate.of(2020, 1, 15));
        memberArchive.newMember(tove, LocalDate.of(2010, 1, 15));

        memberArchive.registerPoints(30000, 0);
        memberArchive.registerPoints(1, 1);
        memberArchive.registerPoints(100000, 2);
        memberArchive.registerPoints(300000, 3);
    }
    private void viewMember(){

        BonusMember selected = (BonusMember)table.getSelectionModel().getSelectedItem();
        Label YERMMOTHERSNAME = new Label(selected.getPERSONALS().getFirstname());
        Label surname = new Label(selected.getPERSONALS().getSurname());
        Label memberID = new Label(String.valueOf(selected.getMEMBER_NO()));
        Label email = new Label(selected.getPERSONALS().getEPostadr());
        Label classType = new Label(selected.getClass().getSimpleName());
        Label enrollmentDate = new Label(selected.getENROLLED_DATE().toString());
        Label points = new Label(String.valueOf(selected.getPoints()));

        VBox vBoxer = new VBox(YERMMOTHERSNAME, surname, memberID, email, classType, enrollmentDate, points);
        vBoxer.setMinWidth(300);
        vBoxer.setPadding(new Insets(30, 0, 0, 10));
        mainView.getChildren().addAll(vBoxer);


    }

}
