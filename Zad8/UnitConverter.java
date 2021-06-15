
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.swing.*;
import java.util.List;

public class UnitConverter extends Frame{

    /**
     * Konstruktor bezparametrowy.
     */
    public UnitConverter() {
        super("UnitConverter");
    }

    private double result = 0.0;
    private String[] unit1 = {"metry", "cale"};
    private String[] unit2 = {"Celsjusz", "Fahrenheit"};
    private String[] unit3 = {"kilogram", "funt"};
    private String[] unitStrings = { unit1[0] + "->" + unit1[1], unit2[0] + "->" + unit2[1], unit3[0] + "->" + unit3[1]};
    private String selected_unit1 = "metry";
    private String selected_unit2 = "cale";

    public double meters2inches(double v1) {
        return v1*39.370;
    }
    public double inches2meters(double v1) {
        return v1/39.370;
    }

    public double celsius2fahrenheit(double v1) {
        return v1*9/5 + 32;
    }

    public double fahrenheit2celsius(double v1) {
        return (v1-32)*5/9;
    }

    public double kg2lb(double v1) {
        return v1*2.2046;
    }

    public double lb2kg(double v1) {
        return v1/2.2046;
    }

    public void launchFrame() {

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(1);
            }
        });

        Panel p = new Panel(new BorderLayout());

        Label l1 = new Label("metry");
        Label l2 =  new Label("cale");

        Panel p2 = new Panel();
        TextField t1 = new TextField(5);
        TextField t2 = new TextField(5);
        t2.setEditable(false);
        p2.add(t1);
        p2.add(l1);
        p2.add(t2);
        p2.add(l2);


        Panel p3 = new Panel();
        p3.setBounds(0,0,600, 100);
        Button b1 = new Button("Konwertuj");
        Button b2 = new Button("Zamień kolejność");


        JComboBox unitList = new JComboBox();
        DefaultComboBoxModel mod = new DefaultComboBoxModel(unitStrings);
        unitList.setModel(mod);

        p3.add(b1);
        p3.add(b2);
        p3.add(unitList);

        unitList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = unitList.getSelectedItem().toString();
                System.out.println(s.split("->").toString());
                List<String> splitted = Arrays.asList(s.split("->"));

                l1.setText(splitted.get(0));
                l2.setText(splitted.get(1));
                t1.setText("");
                t2.setText("");
                pack();
            }
        });


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.swap(Arrays.asList(unit1), 0, 1);
                Collections.swap(Arrays.asList(unit2), 0, 1);
                Collections.swap(Arrays.asList(unit3), 0, 1);

                unitStrings = new String[] { unit1[0] + "->" + unit1[1], unit2[0] + "->" + unit2[1], unit3[0] + "->" + unit3[1]};
                int idx =  unitList.getSelectedIndex();
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( unitStrings );
                unitList.setModel( model );

                unitList.setSelectedIndex(idx);
                t1.setText("");
                t2.setText("");
            }
        });


        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String str1 = t1.getText();
                String str2 = t2.getText();
                String unit = (String) unitList.getSelectedItem();
                double val1 = 0.0;
                try{
                    val1 = Double.parseDouble(str1);
                }
                catch (NumberFormatException n) {
                    System.out.println("Nie podano wartości do konwersji!");
                    return;
                }

                if (unit.equals("metry->cale")) {
                    result = meters2inches(val1);
                }
                else if (unit.equals("cale->metry")) {
                    result = inches2meters(val1);

                }
                else if (unit.equals("Celsjusz->Fahrenheit")) {
                    result = celsius2fahrenheit(val1);
                }
                else if (unit.equals("Fahrenheit->Celsjusz")) {
                    result = fahrenheit2celsius(val1);
                }
                else if (unit.equals("kilogram->funt")) {
                    result = kg2lb(val1);
                }
                else if (unit.equals("funt->kilogram")) {
                    result = lb2kg(val1);
                }

                t2.setText(Double.toString(result));
            }
        });

        p.add(p2, BorderLayout.CENTER);

        p.add(p3, BorderLayout.SOUTH);

        add(p);

        setBackground(Color.green);
        pack();

        EventQueue.invokeLater(() -> setVisible(true));
    }

    public static void main(String[] args) {
        UnitConverter guiWindow = new UnitConverter();
        guiWindow.launchFrame();
    }
}
