import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AddressBookRepo {
    static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/AddressBookDB";
        String username = "root";
        String password = "Monali@12345";
        Connection connection = null;
        try {
            //Loading and registering driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public List<Person> retrieveData() {
        ResultSet resultSet = null;
        List<Person> employeeInfoList = new ArrayList<>(

        );
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from addressBook;";
            resultSet = statement.executeQuery(sql);
            int count = 1;
            while (resultSet.next()) {
                count++;
                Person employeeInfo = new Person();
                employeeInfo.setFirstName(resultSet.getString("firstName"));
                employeeInfo.setLastName(resultSet.getString("LastName"));
                employeeInfo.setAddress(resultSet.getString("address"));
                employeeInfo.setCity(resultSet.getString("city"));
                employeeInfo.setZip(resultSet.getString("zip"));
                employeeInfo.setPhoneNumber(resultSet.getString("phoneNumber"));
                employeeInfoList.add(employeeInfo);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return employeeInfoList;
    }
    public static void updateSalary(String fName, int zip) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "update addressBook set zip=" + zip + " where firstName=" + fName + "";
            int result = statement.executeUpdate(query);
            if (result == 1)
                System.out.println("salary updated");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}