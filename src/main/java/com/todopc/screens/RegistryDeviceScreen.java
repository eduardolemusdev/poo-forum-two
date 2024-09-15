package com.todopc.screens;

import com.todopc.database.models.DesktopDevice;
import com.todopc.database.models.LaptopDevice;
import com.todopc.database.models.TabletDevice;
import com.todopc.database.repositories.IDevicesRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RegistryDeviceScreen extends JFrame {
    private JPanel mainPanel;
    private JPanel DeviceToRegisterPanel;
    private JComboBox comboBox1;

    private JPanel CardSectionPanel;

    private JPanel DeviceCommonPropertiesPanel;
    private JTextField txtFieldDeviceMadeBy;
    private JTextField txtFieldDeviceModel;
    private JTextField txtFieldDeviceIntegratedChip;

    private JPanel RamAndHardDiskPropertiesPanel;
    private JTextField txtFieldMemoryRamCapacity;
    private JTextField txtFieldHardDriveCapacity;

    private JPanel DesktopsPropertiesPanel;
    private JTextField txtFieldDesktopGPU;
    private JTextField txtFieldDesktopTowerSize;

    private JPanel LaptopsPropertiesPanel;
    private JTextField txtFieldLaptopScreenSize;

    private JPanel TabletsPropertiesPanel;
    private JTextField txtFieldTableScreenDiagonalSize;
    private JComboBox comboBoxTabletScreenTech;
    private JTextField txtFieldTabletMemoryNandCapacity;
    private JTextField txtFieldTabletOperativeSystem;

    private JPanel SaveDevicePanel;
    private JButton btnSaveDevice;

    private JTabbedPane tabbedPane1;
    private JPanel ListPanel;

    private final String DESKTOPS_OPTION = "1. Desktops";
    private final String LAPTOPS_OPTION = "2. Laptops";
    private final String TABLETS_OPTION = "3. Tablets";

    private final IDevicesRepository<DesktopDevice> desktopRepository;
    private final IDevicesRepository<LaptopDevice> laptopRepository;
    private final IDevicesRepository<TabletDevice> tabletRepository;

    public RegistryDeviceScreen(IDevicesRepository<DesktopDevice> desktopRepository, IDevicesRepository<LaptopDevice> laptopRepository, IDevicesRepository<TabletDevice> tabletRepository) {
        this.desktopRepository = desktopRepository;
        this.laptopRepository = laptopRepository;
        this.tabletRepository = tabletRepository;

        this.initRegisterComboBox();
        this.handleDeviceToRegisterEvent();
        this.handleSaveDeviceEvent();

        this.initTable();
    }

    public void executeScreen() {

        this.setContentPane(this.mainPanel);
        this.setTitle("UDB Heritage Registry Manager");
        this.setSize(700, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initRegisterComboBox() {
        comboBox1.addItem(DESKTOPS_OPTION);
        comboBox1.addItem(LAPTOPS_OPTION);
        comboBox1.addItem(TABLETS_OPTION);
    }

    // En este metodo se encuentra la logica para manejar el cambio de equipo a registrar
    private void handleDeviceToRegisterEvent() {

        //Por defecto el primer "Formulario" que se puede ver es para registrar PCDesktops
        // Asi que hacemos visibles los paneles correspondientes y los demas los ocultamos
        DesktopsPropertiesPanel.setVisible(true);
        RamAndHardDiskPropertiesPanel.setVisible(true);
        LaptopsPropertiesPanel.setVisible(false);
        TabletsPropertiesPanel.setVisible(false);

        //Cuando cambia el combobox seguimos esa logica de ocultar paneles segun el equipo a registrar
        comboBox1.addItemListener((ItemEvent evt) -> {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                System.out.println(comboBox1.getSelectedItem());
                switch (comboBox1.getSelectedItem().toString()) {
                    case DESKTOPS_OPTION:
                        DesktopsPropertiesPanel.setVisible(true);
                        RamAndHardDiskPropertiesPanel.setVisible(true);
                        LaptopsPropertiesPanel.setVisible(false);
                        TabletsPropertiesPanel.setVisible(false);
                        break;
                    case LAPTOPS_OPTION:
                        LaptopsPropertiesPanel.setVisible(true);
                        RamAndHardDiskPropertiesPanel.setVisible(true);
                        DesktopsPropertiesPanel.setVisible(false);
                        TabletsPropertiesPanel.setVisible(false);
                        break;
                    case TABLETS_OPTION:
                        TabletsPropertiesPanel.setVisible(true);
                        LaptopsPropertiesPanel.setVisible(false);
                        DesktopsPropertiesPanel.setVisible(false);
                        RamAndHardDiskPropertiesPanel.setVisible(false);
                        break;
                }
            }
        });
    }

    private void handleSaveDeviceEvent() {
        this.btnSaveDevice.addActionListener((ActionEvent evt) -> {
            switch (comboBox1.getSelectedItem().toString()) {
                case DESKTOPS_OPTION:

                    DesktopDevice newDesktop = new DesktopDevice(
                            this.txtFieldDeviceMadeBy.getText(),
                            this.txtFieldDeviceModel.getText(),
                            this.txtFieldDeviceIntegratedChip.getText(),
                            this.txtFieldDesktopGPU.getText(),
                            this.txtFieldDesktopTowerSize.getText(),
                            this.txtFieldHardDriveCapacity.getText(),
                            this.txtFieldMemoryRamCapacity.getText()
                    );
                    this.desktopRepository.saveDevice(newDesktop);
                    break;
                case LAPTOPS_OPTION:
                    LaptopDevice newLaptop = new LaptopDevice(
                            this.txtFieldDeviceMadeBy.getText(),
                            this.txtFieldDeviceModel.getText(),
                            this.txtFieldDeviceIntegratedChip.getText(),
                            this.txtFieldMemoryRamCapacity.getText(),
                            this.txtFieldLaptopScreenSize.getText(),
                            this.txtFieldHardDriveCapacity.getText()
                    );
                    this.laptopRepository.saveDevice(newLaptop);
                    break;
                case TABLETS_OPTION:
                    TabletDevice newTablet = new TabletDevice(
                            this.txtFieldDeviceMadeBy.getText(),
                            this.txtFieldDeviceModel.getText(),
                            this.txtFieldDeviceIntegratedChip.getText(),
                            this.txtFieldTableScreenDiagonalSize.getText(),
                            this.comboBoxTabletScreenTech.getSelectedItem().toString(),
                            this.txtFieldTabletMemoryNandCapacity.getText(),
                            this.txtFieldTabletOperativeSystem.getText()
                    );
                    this.tabletRepository.saveDevice(newTablet);
                    JOptionPane.showMessageDialog(this,"Guardado Con Exito.");
                    break;
            }
        });
    }

    private void initTable(){

        //Layout manager para el panel de listar dispositivos
        GridBagLayout gridbag = new GridBagLayout();

        //Sirve para posicionar los elementos en un punto (X,Y)
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel selectDevicesLabel = new JLabel("Selecciona el tipo de dispositvo que deseas listar:");
        JComboBox<String> selectDevicesComboBox = new JComboBox<>();

        selectDevicesComboBox.addItem("1. Desktops");
        selectDevicesComboBox.addItem("2. Laptops");
        selectDevicesComboBox.addItem("3. Tablets");

        //agregamos el layout manager, manipula el comportamiento de como ordenamos los elementos en el Jframe
        this.ListPanel.setLayout(gridbag);

        //agregamos el label al panel
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.ListPanel.add(selectDevicesLabel, gbc);

        //agregamos el comboBox abajo del label
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.ListPanel.add(selectDevicesComboBox, gbc);

        //Columnas para dispositvos desktop
        List<String> desktopColumsHeaders = Arrays.asList(
                "Fabricante",
                "Modelo",
                "Microprocesador",
                "RAM",
                "GPU",
                "Tamaño de Torre",
                "Capacidad de Disco Duro"
        );


        // Inicializmos la tabla, DefaultTableModel nos sirve para agregar columnas y rows a la tabla
        JTable listTable = new JTable();

        //El DefaultTableModel continee toda la información, de la tabla
        DefaultTableModel model = new DefaultTableModel();

        //Construimos las columnas
        desktopColumsHeaders.forEach(model::addColumn);

        //agregamos una fila de prueba
        model.addRow(new Object[] { "data", "data", "data",
                "data", "data", "data", "data" });

        //Agregamos el modelo a la tabla
        listTable.setModel(model);


        //Agregamos la tabla en un JscrollPane, se hace por si la tabla crece podamos scrollear
        JScrollPane scrollPane = new JScrollPane(listTable);

        //le asignamos un tamaño por default - puede variar en base al layout
        scrollPane.setPreferredSize(new Dimension(500, 150));

        //Agregamos la tabla abajo del combobox
        gbc.fill = GridBagConstraints.HORIZONTAL; // Asegura que se expanda horizontal y verticalmente
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.ListPanel.add(scrollPane, gbc);



    }
}
