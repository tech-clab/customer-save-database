package controller;

import db.DBConnection;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ItemViewController {
    public TextField txtItemName;
    public TextField txtItemPrice;
    public Button btnAdd;


    public void AddItem() throws Exception{
        String name = txtItemName.getText();
        String price = txtItemPrice.getText();
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into Item(?,?)");
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,price);
        boolean execute = preparedStatement.execute();
        System.out.println(execute);
    }
}
