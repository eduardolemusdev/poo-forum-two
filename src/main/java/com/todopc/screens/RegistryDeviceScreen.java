package com.todopc.screens;

import com.todopc.database.models.DesktopDevice;
import com.todopc.database.repositories.IDevicesRepository;
import com.todopc.execeptions.EmptyValueException;
import com.todopc.screens.services.SaveDesktopService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.Arrays;

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

    private final String DESKTOPS_OPTION = "1. Desktops";
    private final String LAPTOPS_OPTION = "2. Laptops";
    private final String TABLETS_OPTION = "3. Tablets";

    private final SaveDesktopService saveDesktopService;

    public RegistryDeviceScreen(SaveDesktopService saveDesktopService) {
        this.saveDesktopService = saveDesktopService;
        this.initRegisterComboBox();
        this.handleDeviceToRegisterEvent();
        this.handleSaveDeviceEvent();
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

    private void handleDeviceToRegisterEvent() {
        DesktopsPropertiesPanel.setVisible(true);
        RamAndHardDiskPropertiesPanel.setVisible(true);
        LaptopsPropertiesPanel.setVisible(false);
        TabletsPropertiesPanel.setVisible(false);

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
                            this.txtFieldMemoryRamCapacity.getText());
                    this.saveDesktopService.save(newDesktop, this);
                    break;
                case LAPTOPS_OPTION:

                    break;
                case TABLETS_OPTION:

                    break;
            }
        });
    }

}
