package lab4.part2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This class is the main GUI class that creates the frame and adds the components to the frame.

public class CarLotGUI extends JFrame {
    private DefaultTableModel tableModel;
    private JTable carTable;
    private JButton addButton, editButton, deleteButton;

    public CarLotGUI() {
        setTitle("Used Car Lot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void initComponents() {
        // Initialize components and set up the table
        carTable = new JTable();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        // Set up the table and add the columns
        String[] columnNames = {"Title", "Price", "Copies"};
        tableModel = new DefaultTableModel(columnNames, 0);
        carTable.setModel(tableModel);

        // Set layout manager and add components to the frame
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Add components to the frame
        add(new JScrollPane(carTable));
        add(addButton);
        add(editButton);
        add(deleteButton);

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editCar();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCar();
            }
        });
    }

    //add the car

    private void addCar() {
        Car car = new Car("", 0.0, 0);
        car.initialize();
        tableModel.addRow(new Object[]{car.getTitle(), car.getPrice(), car.getCopies()});
    }

    //edit the car
    private void editCar() {
        int selectedRow = carTable.getSelectedRow();
        if (selectedRow != -1) {
            Car selectedCar = new Car(
                    (String) tableModel.getValueAt(selectedRow, 0),
                    (double) tableModel.getValueAt(selectedRow, 1),
                    (int) tableModel.getValueAt(selectedRow, 2)
            );
            selectedCar.edit();
            tableModel.setValueAt(selectedCar.getTitle(), selectedRow, 0);
            tableModel.setValueAt(selectedCar.getPrice(), selectedRow, 1);
            tableModel.setValueAt(selectedCar.getCopies(), selectedRow, 2);
        }
    }

    //delete the car
    private void deleteCar() {
        int selectedRow = carTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        }
    }


    //run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CarLotGUI();
            }
        });
    }
}
