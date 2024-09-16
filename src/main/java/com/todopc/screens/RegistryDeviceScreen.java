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
                    JOptionPane.showMessageDialog(this, "Guardado Con Exito.");
                    break;
            }
        });
    }

    private void initTable() {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel selectDevicesLabel = new JLabel("Selecciona el tipo de dispositvo que deseas listar:");
        JComboBox<String> selectDevicesComboBox = new JComboBox<>();

        selectDevicesComboBox.addItem("1. Desktops");
        selectDevicesComboBox.addItem("2. Laptops");
        selectDevicesComboBox.addItem("3. Tablets");

        this.ListPanel.setLayout(gridbag);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.ListPanel.add(selectDevicesLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.ListPanel.add(selectDevicesComboBox, gbc);

        JTable listTable = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        listTable.setModel(model);
        JScrollPane scrollPane = new JScrollPane(listTable);
        scrollPane.setPreferredSize(new Dimension(500, 150));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.ListPanel.add(scrollPane, gbc);

        selectDevicesComboBox.addActionListener(e -> {
            String selectedItem = (String) selectDevicesComboBox.getSelectedItem();
            model.setRowCount(0);
            model.setColumnCount(0);

            switch (selectedItem) {
                case "1. Desktops":
                    model.setColumnIdentifiers(new String[]{"Fabricante", "Modelo", "Microprocesador", "RAM", "GPU", "Tamaño de Torre", "Capacidad de Disco Duro"});
                    for (DesktopDevice device : desktopRepository.getDevices()) {
                        model.addRow(new Object[]{device.getMadeBy(), device.getModel(), device.getIntegratedChip(), device.getMemoryRamCapacity(), device.getGpu(), device.getTowerSize(), device.getHardDriveCapacity()});
                    }
                    break;
                case "2. Laptops":
                    model.setColumnIdentifiers(new String[]{"Fabricante", "Modelo", "Microprocesador", "RAM", "Tamaño de Pantalla", "Capacidad de Disco Duro"});
                    for (LaptopDevice device : laptopRepository.getAllDevices()) {
                        model.addRow(new Object[]{device.getMadeBy(), device.getModel(), device.getIntegratedChip(), device.getMemoryRamCapacity(), device.getScreenSize(), device.getHardDriveCapacity()});
                    }
                    break;
                case "3. Tablets":
                    model.setColumnIdentifiers(new String[]{"Fabricante", "Modelo", "Microprocesador", "Tamaño de Pantalla", "Tecnología de Pantalla", "Capacidad de Memoria NAND", "Sistema Operativo"});
                    for (LaptopDevice device : tabletRepository.getAllDevices()) {
                        model.addRow(new Object[]{device.getMadeBy(), device.getModel(), device.getIntegratedChip(), device.getScreenDiagonalSize(), device.getScreenTech(), device.getMemoryNandCapacity(), device.getOperativeSystem()});
                    }
                    break;
            }
        });
    }
}