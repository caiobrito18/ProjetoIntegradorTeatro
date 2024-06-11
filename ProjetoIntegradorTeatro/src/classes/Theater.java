package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Theater {
    private final ArrayList<Area> areas;

    public Theater() {
        areas = new ArrayList<>();
        areas.add(new Area(25, 40.00));// Plateia A
        areas.add(new Area(100, 60.00)); // Plateia B
        areas.add(new Area(5, 80.00));// Frisa 1
        areas.add(new Area(5, 80.00));// Frisa 2
        areas.add(new Area(5, 80.00));// Frisa 3
        areas.add(new Area(5, 80.00));// Frisa 4
        areas.add(new Area(5, 80.00));// Frisa 5
        areas.add(new Area(5, 80.00));// Frisa 6
        areas.add(new Area(10, 120.00));// Camarote 1
        areas.add(new Area(10, 120.00));// Camarote 2
        areas.add(new Area(10, 120.00));// Camarote 3
        areas.add(new Area(10, 120.00));// Camarote 4
        areas.add(new Area(10, 120.00));// Camarote 5
        areas.add(new Area(10, 250.00));// Balcão Nobre
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public int getTotalIngressosVendidos() {

        return areas.stream().mapToInt(Area::getTotalIngressosVendidos).sum();
    }

    public double getReceitaTotal() {
        return areas.stream().mapToDouble(Area::getReceita).sum();
    }

}