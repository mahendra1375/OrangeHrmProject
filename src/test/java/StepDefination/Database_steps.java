package StepDefination;
import io.cucumber.java.en.*;

import java.sql.*;

public class Database_steps {
    Connection con;
    ResultSet result;
        @And("connect to the Database")
        public void databaseConnection() throws SQLException {

             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Mahendra@123");

        }


    @When("Trigger the query and capture the data")
    public void triggerTheQuery() throws SQLException {
            String query="Select empID,EmpFname,EmpLname from emp;";
            Statement stmt=con.createStatement();
            result=stmt.executeQuery(query);

    }

    @Then("Validate the data")
    public void validateTheData() throws SQLException {

            while(result.next()){
                int eid=result.getInt("empID");
                String FirstName=result.getString("EmpFname");
                String LastName=result.getString("EmpLname");

                System.out.println(eid+"         "+FirstName+"        "+LastName);

            }

    }

    @And("close the connection")
    public void closeTheConnection() throws SQLException {

            con.close();
    }
}
