package controller;

import db.DBConnection;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerViewController {
    public TextField txtCustomerName;
    public TextField txtCustomerAddress;
    public Button btnAdd;

    public void AddBthOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        System.out.println("Hello");
            String name=txtCustomerName.getText();
            String address=txtCustomerAddress.getText();
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into Customer(?,?)");
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,address);
        boolean execute = preparedStatement.execute();
        System.out.println(execute);

    }
}
