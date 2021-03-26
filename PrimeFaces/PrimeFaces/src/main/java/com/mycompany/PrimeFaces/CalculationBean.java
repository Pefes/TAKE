/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.PrimeFaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Pefes
 */
@Named(value = "calculationBean")
@RequestScoped
public class CalculationBean {
    private int a;
    private int b;
    private int result;
    private Date currentDate;
    private List<Student> students = new ArrayList<>();
    private LineChartModel lineModel = this.initLineChartModel();
    
    /**
     * Creates a new instance of CalculationBean
     */
    public CalculationBean() {
        this.currentDate = new Date();
        
        for (int i = 0; i < 100; i ++) {
            this.students.add(new Student("name" + Integer.toString(i), "surname" + Integer.toString(i), i));
        }
        
        
    }
    
    private LineChartModel initLineChartModel() {
        LineChartModel lineModel = new LineChartModel();
        LineChartSeries sin = new LineChartSeries();
        LineChartSeries cos = new LineChartSeries();
        sin.setLabel("Sin");
        cos.setLabel("Cos");

        for (int i = 0; i <= 360; i += 10) {
            sin.set(i, Math.sin(Math.toRadians(i)));
            cos.set(i, Math.cos(Math.toRadians(i)));
        }

        lineModel.addSeries(sin);
        lineModel.addSeries(cos);
        lineModel.setLegendPosition("e");
        lineModel.setZoom(true);
    
        Axis y = lineModel.getAxis(AxisType.Y);
        y.setLabel("Y");

        Axis x = lineModel.getAxis(AxisType.X);
        x.setLabel("X");
        
        return lineModel;
    }
    
    public void calculate() {
        this.result = a + b;
        
        String msg = Integer.toString(this.a) + " + " + Integer.toString(this.b) + " = " + Integer.toString(this.result);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Result", msg));
    }

    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public int getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * @return the currentDate
     */
    public Date getCurrentDate() {
        return currentDate;
    }

    /**
     * @param currentDate the currentDate to set
     */
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * @return the lineModel
     */
    public LineChartModel getLineModel() {
        return lineModel;
    }

    /**
     * @param lineModel the lineModel to set
     */
    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }
    
}
