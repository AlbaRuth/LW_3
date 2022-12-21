package bsu.rfe.java.group7.lab311.Sakovich.A7;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    public int getColumnCount() {
// В данной модели два столбца
        return 3;
    }
    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }
    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        Double result = 0.0;

        switch (col)
        {
            case 0:
                return x;
            case 1:
            {
                for (int i = coefficients.length - 1; i >= 0; i--) {
                    result += coefficients[i] * Math.pow(x, coefficients.length - 1 - i);
                }
                return result;
            }
            case 2:
            {
                for (int i = coefficients.length - 1; i >= 0; i--) {
                    result += coefficients[i] * Math.pow(x, coefficients.length - 1 - i);
                }
                if (result >0)
                    return true;
                else
                    return false;
            }
        }
        return result;
    }

    public String getColumnName(int col)
    {
        switch (col) {
            case 0:
// Название 1-го столбца
                return "Значение X";
            case 1 :
// Название 2-го столбца
                return "Значение многочлена";
            case 2:
                return "Значение больше 0";
        }
        return "";
    }

    public Class<?> getColumnClass(int col) {
        if (col != 2)
            return Double.class;
        else
            return Boolean.class;
    }
}
