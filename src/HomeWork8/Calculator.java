package HomeWork8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Calculator extends JFrame {
    String value = "";
    static int operatorsCount = 0;

    public Calculator() {
        setBounds(500, 500, 400, 400);
        setTitle("Калькулятор");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final CalcButton plus = new CalcButton("+");
        final CalcButton minus = new CalcButton("-");
        final CalcButton multiply = new CalcButton("*");
        final CalcButton share = new CalcButton("÷");
        final CalcButton equals = new CalcButton("=");
        final CalcButton clear = new CalcButton("C");
        final CalcButton point = new CalcButton(".");
        final CalcButton backspace = new CalcButton("←");


        JPanel operatorsPanel = new JPanel();
        add(operatorsPanel, BorderLayout.WEST);
        operatorsPanel.setLayout(new GridLayout(4, 1));
        operatorsPanel.add(plus);
        operatorsPanel.add(minus);
        operatorsPanel.add(share);
        operatorsPanel.add(multiply);

        JPanel calculationsPanel = new JPanel();
        add(calculationsPanel, BorderLayout.NORTH);
        JTextArea calculations = new JTextArea();
        calculations.setBackground(new Color(0xFBFBFD));
        calculations.setFont(new Font("Arial", Font.BOLD, 25));
        calculations.setMargin(new Insets(15, 5, 15, 5));
        calculationsPanel.add(calculations);

        JPanel numsPanel = new JPanel();
        add(numsPanel, BorderLayout.CENTER);
        numsPanel.setLayout(new GridLayout(4, 3));
        for (int i = 1; i <= 10; i++) {
            String buttonTitle;
            if (i == 10) {
                buttonTitle = "0";
            } else {
                buttonTitle = "" + i;
            }
            CalcButton newBut = new CalcButton(buttonTitle);
            numsPanel.add(newBut);
            newBut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    value += buttonTitle;
                    calculations.setText(value);
                }
            });
        }
        numsPanel.add(point);
        numsPanel.add(backspace);
        backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char forStr;
                String valueClone = "";
                for (int i = 0; i < value.length() - 1; i++) {
                    forStr = value.charAt(i);
                    valueClone += forStr;
                }
                value = valueClone;
                calculations.setText(value);
            }
        });


        JPanel equalsAndClear = new JPanel();
        equalsAndClear.setLayout(new GridLayout(2, 1));
        add(equalsAndClear, BorderLayout.EAST);
        equalsAndClear.add(equals);
        equalsAndClear.add(clear);
        equals.setEnabled(false);


        CalcButton[] buttons = {plus, minus, multiply, share, equals, point};
        for (int i = 0; i < buttons.length; i++) {
            String name = buttons[i].getName();
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (name != point.getName()) {
                        operatorsCount++;
                        equals.setEnabled(true);
                    }
                    if (operatorsCount > 1) {
                        equals.setEnabled(false);
                        double res = checkResult(value + name);
                        if (checkInt(res) == false) {
                            value = String.valueOf(res);
                            operatorsCount = 0;
                            calculations.setText(value);
                        } else {
                            value = String.valueOf((int) res);
                            operatorsCount = 0;
                            calculations.setText(value);
                        }
                    } else {
                        value += name;
                        calculations.setText(value);
                    }

                }
            });
        }
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = "";
                calculations.setText(value);
            }
        });


        setVisible(true);
    }

    static double checkResult(String value) {
        String a = "";
        String b = "";
        double result = 0;
        int operatorsCount = 0;
        char operator = 'i';
        char num;
        for (int i = 0; i < value.length(); i++) {
            num = value.charAt(i);
            if (num == '+' || num == '-' || num == '*' || num == '÷') {
                operatorsCount++;
                if (operatorsCount == 1) {
                    operator = num;
                }
            }
            if (operatorsCount > 1 || num == '=') {
                result = Double.parseDouble(a);
                if (operator == '+') {
                    result += Double.parseDouble(b);
                } else if (operator == '-') {
                    result -= Double.parseDouble(b);
                } else if (operator == '*') {
                    result *= Double.parseDouble(b);
                } else if (operator == '÷') {
                    if (result == 0) {
                        return 0;
                    }
                    double bb = Double.parseDouble(b);
                    if (bb == 0) {
                        return 0;
                    }
                    result /= Double.parseDouble(b);
                }
            }

            if (num == '+' || num == '-' || num == '*' || num == '÷') {
                continue;
            } else {
                if (operatorsCount == 0) {
                    a += num;
                } else {
                    b += num;
                }
            }


        }

        return result;
    }

    static boolean checkInt(double res) {
        String r = String.valueOf(res);
        String r2 = "";
        int pointCount = 0;
        char num = '?';
        for (int i = 0; i < r.length(); i++) {
            num = r.charAt(i);
            if (num == '.') {
                pointCount++;
                continue;
            }
            if (pointCount > 0) {
                r2 += num;
            }
        }
        if (Double.parseDouble(r2) == 0) {
            return true;
        } else return false;
    }

}

