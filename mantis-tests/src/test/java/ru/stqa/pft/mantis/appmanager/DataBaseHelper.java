package ru.stqa.pft.mantis.appmanager;

import ru.stqa.pft.mantis.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataBaseHelper extends HelperBase {


    public DataBaseHelper(ApplicationManager app) {
        super(app);
    }

    public List<User> allUser() {
        Connection conn = null;
        List<User> users = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtrackertwo?user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id,username,email from mantis_user_table");
            while (rs.next()) {
                users.add(new User().withId(rs.getInt("id")).withEmail(rs.getString("email"))
                        .withUserName(rs.getString("username")));
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println(users);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return users.stream().filter((u)->!u.getUserName().equals("administrator"))
                .collect(Collectors.toList());
    }

}
