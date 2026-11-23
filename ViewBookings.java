import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewBookings extends JFrame {

    JTable table;

    public ViewBookings() {

        setTitle("All Bookings");

        setSize(1000, 500);

        setLocationRelativeTo(null);

        table = new JTable();

        JScrollPane scroll =
                new JScrollPane(table);

        add(scroll);

        loadBookings();

        setVisible(true);
    }

    private void loadBookings() {

        DefaultTableModel model =
                new DefaultTableModel();

        model.addColumn("PNR");
        model.addColumn("Email");
        model.addColumn("Train");
        model.addColumn("Passenger");
        model.addColumn("Age");
        model.addColumn("Gender");
        model.addColumn("Journey Date");
        model.addColumn("Seat");
        model.addColumn("Fare");
        model.addColumn("Status");

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM bookings"
                    );

            while (rs.next()) {

                model.addRow(
                        new Object[]{

                                rs.getString("pnr"),

                                rs.getString(
                                        "user_email"
                                ),

                                rs.getString(
                                        "train_no"
                                ),

                                rs.getString(
                                        "passenger_name"
                                ),

                                rs.getInt("age"),

                                rs.getString("gender"),

                                rs.getDate(
                                        "journey_date"
                                ),

                                rs.getInt("seat_no"),

                                rs.getDouble("fare"),

                                rs.getString("status")

                        }
                );
            }

            table.setModel(model);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}