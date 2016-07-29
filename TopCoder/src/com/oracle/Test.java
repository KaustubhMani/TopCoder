package com.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by sshil on 7/26/2016.
 */
public class Test {


    public static void main(String[] args) {
        try {
            String dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=ndc-vedip1.walmart.com)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=edip1)))";
            String strUserID = "integration_user";
            String strPassword = "intgrt10n1";
            Connection myConnection= DriverManager.getConnection(dbURL, strUserID, strPassword);

            Statement sqlStatement = myConnection.createStatement();
            String readRecordSQL = "select * from wfu_distributor";
            ResultSet myResultSet = sqlStatement.executeQuery(readRecordSQL);
            while (myResultSet.next()) {
                System.out.println("Record values: " + myResultSet.getString("distributor_id"));
            }
            myResultSet.close();
            myConnection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
