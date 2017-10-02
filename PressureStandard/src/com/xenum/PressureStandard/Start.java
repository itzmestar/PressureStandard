package com.xenum.PressureStandard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Start extends JFrame implements MouseListener, ActionListener 
{    
	private static final long serialVersionUID = 1L;

	private static final int NEW_WIDTH = 70;

	private static final int NEW_HEIGHT = 70;
    public void mouseEntered(MouseEvent e){} 

    public void mouseReleased(MouseEvent e){}

    public void mouseExited(MouseEvent e){}  

    public void mousePressed(MouseEvent e){}

    //private JPanel[][] pnlChessCells = new JPanel[8][8];

    private JPanel pnlMain = new JPanel(new GridLayout(0,4,10,10));
    private JPanel pnlMain1 = new JPanel(new GridLayout(1,1));
    //private JPanel pnlMain = new JPanel(new GridLayout(0,2,10,10));
    //private JPanel pnlMain = new JPanel(null);
    

    String[] pressureUnitStr = { "Pa", "mmHg", "TORR", "BAR", "mBAR", 
    		                   "kPa", "MPa", "KG/cm^2", "PSI",
    		                   "cmWC", "mmWC", "inWC"};    

    String[] standardUsed = { "PG"};
    String[] yesNoStr = { "Yes", "No"};
    String[] pistonGaugeSelectionStr = {"PG270KPA","PG28MPA","PG60MPA","PG100MPA",
    		"PG100MPN", "PG140MPA","PG200MPA", "PG200MPN", "PG280MPA","PG500MPA",
    		"PG500MPN"
    };
    String[] tempModeStr = { "Resistance", "0'C"}; 
    String[] gaugeUnderTestStr = {"DEAD WEIGHT TESTER",
    		"PRESSURE DIAL GAUGE",
    		"TRANSDUCER"};
    String[] uncertainEstUsingStr = {"UNIVERSAL", "NABL APPROACH"};
    String[] fileInputStr = {"DATA INPUT THROUGH KEYBOARD", "EXISTING DATA FILE"};
    String[] coverageFactorStr = { "1", "2", "3"};
    private Container c;
    
    JButton submit;
    
    //JLabel pressureUnitTxt, caliPointTxt;
    JTextArea dataPointTxt, scaleReadTxt, standardUsedTxt, ambTempTxt, diffMeterTxt, tareWeightTxt;
    JTextArea fixedAirDensitytxt, fixedAirDensityValTxt, pistonGaugeSelectionTxt, pistonGaugeConfigTxt;
    JTextArea pistonGaugeConfigValTxt, tempModeTxt, resistancePRTTxt, uncertainityTxt, LRANGETxt, HRANGETxt;
    JTextArea gaugeUnderTestTxt, uncertainEstUsingTxt, fileInputTxt, dataFileTxt, gmanfTxt, RESTxt;
    JTextArea calAccuracyTxt, TESTxt, outputToFileTxt, outputFileTxt, pressureUnitTxt, caliPointTxt;
    JTextArea curveFittingTxt, CFOutputFileTxt, fittedOutputFileTxt, numTermsTxt, coverageFactorTxt;
    
    JComboBox pressureUnitList, standardUsedList, fixedAirDensityList, pistonGaugeSelectionList;
    JComboBox tempModeList, gaugeUnderTestList, uncertainEstUsingList, fileInputList;
    JComboBox calAccuracyList, TESList, outputToFileList, curveFittingList, coverageFactorList;
    
    JTextField caliPointVal, dataPointVal, scaleReadVal, ambTempVal, diffMeterVal, tareWeightVal, fixedAirDensityVal;
    JTextField resistancePRTVal, uncertainityVal, LRANGEVal, HRANGEVal, dataFileVal, gmanfVal, RESVal;
    JTextField outputFileVal, CFOutputFileVal, fittedOutputFileVal, numTermsVal;

    String caliPointStr, dataPointStr, scaleReadStr, ambTempStr, diffMeterStr, tareWeightStr, fixedAirDensityStr;
    String resistancePRTStr, uncertainityStr, LRANGEStr, HRANGEStr, dataFileStr, gmanfStr, RESStr;
    String outputFileStr, CFOutputFileStr, fittedOutputFileStr, numTermsStr;
    
    double LRANGE, USTD, FSR, HRANGE, STDB, gmanf, RES;
    
	public static void main(String[] args)
      {
			//final Sender s= new Sender();
            final Start app = new Start(); 
            app.setVisible(true);
      }

	
      public Start()
      {

            c = getContentPane();

            //setBounds(200, 10, 460, 740);
            setBounds(200, 10, 860, 710);
            setBackground(new Color(204, 204, 204));
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Pressure Standard");
            setResizable(false);
            c.setLayout(null);    
            //c.setLayout(new GridLayout(8,2,10,10));

           // pnlMain.set
           
            //pnlMain.setBounds(5, 5, 445, 690);
            //pnlMain.setBounds(5, 5, 845, 490);
            pnlMain.setBounds(5, 5, 845, 630);

            pnlMain.setBackground(new Color(255,255 , 255));
            pnlMain.setBackground(new Color(211,211,211));
            //pnlMain.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            //pnlMain.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
            
            
            pnlMain1.setBounds(5, 640, 845, 35);
            pnlMain1.setBackground(new Color(211,211,211));
            
            addComponent();
      }
      
      private void addComponent(){
    	  
            pressureUnitTxt = new JTextArea("Pressure Unit: ");
            pressureUnitTxt.setLineWrap(true);
            pressureUnitTxt.setWrapStyleWord(true);
            pressureUnitTxt.setBackground(new Color(211,211,211));
            
            caliPointTxt = new JTextArea("Number of Calibration Points: ");
            caliPointTxt.setLineWrap(true);
            caliPointTxt.setWrapStyleWord(true);
            caliPointTxt.setBackground(new Color(211,211,211));
            
            dataPointTxt = new JTextArea("Number of repeated Data Points at each Calibration Point: ");
            dataPointTxt.setLineWrap(true);
            dataPointTxt.setWrapStyleWord(true);
            dataPointTxt.setBackground(new Color(211,211,211));
            dataPointTxt.setAlignmentX(CENTER_ALIGNMENT);
            dataPointTxt.setAlignmentY(CENTER_ALIGNMENT);
            
            scaleReadTxt = new JTextArea("Full Scale Reading of the Gauge under test:");
            scaleReadTxt.setLineWrap(true);
            scaleReadTxt.setWrapStyleWord(true);
            scaleReadTxt.setBackground(new Color(211,211,211));
            
            standardUsedTxt = new JTextArea("Name of the Standard Used: (PISTON GAUGE)");
            standardUsedTxt.setLineWrap(true);
            standardUsedTxt.setWrapStyleWord(true);
            standardUsedTxt.setBackground(new Color(211,211,211));
               
            ambTempTxt = new JTextArea("Ambient Temperature at which pressured is to be measured:");
            ambTempTxt.setLineWrap(true);
            ambTempTxt.setWrapStyleWord(true);
            ambTempTxt.setBackground(new Color(211,211,211));
     
            diffMeterTxt = new JTextArea("Hight difference in Units of Meter if above (+) or down (-):");
            diffMeterTxt.setLineWrap(true);
            diffMeterTxt.setWrapStyleWord(true);
            diffMeterTxt.setBackground(new Color(211,211,211));
            
            tareWeightTxt = new JTextArea("Tare Weight Component(Tw) in Kilograms:");
            tareWeightTxt.setLineWrap(true);
            tareWeightTxt.setWrapStyleWord(true);
            tareWeightTxt.setBackground(new Color(211,211,211));
            
            fixedAirDensitytxt = new JTextArea("Use Fixed value of Air Density:");
            fixedAirDensitytxt.setLineWrap(true);
            fixedAirDensitytxt.setWrapStyleWord(true);
            fixedAirDensitytxt.setBackground(new Color(211,211,211));
            
            fixedAirDensityValTxt = new JTextArea("Fixed value of Air Density:");
            fixedAirDensityValTxt.setLineWrap(true);
            fixedAirDensityValTxt.setWrapStyleWord(true);
            fixedAirDensityValTxt.setBackground(new Color(211,211,211));
            
            pistonGaugeSelectionTxt = new JTextArea("Select Piston Gauge:");
            pistonGaugeSelectionTxt.setLineWrap(true);
            pistonGaugeSelectionTxt.setWrapStyleWord(true);
            pistonGaugeSelectionTxt.setBackground(new Color(211,211,211));
            
            pistonGaugeConfigTxt = new JTextArea("Piston Gauge Configuration selected:");
            pistonGaugeConfigTxt.setLineWrap(true);
            pistonGaugeConfigTxt.setWrapStyleWord(true);
            pistonGaugeConfigTxt.setBackground(new Color(211,211,211));
            
            pistonGaugeConfigValTxt = new JTextArea("etc/PG/PG270KPA.DAT");
            pistonGaugeConfigValTxt.setLineWrap(true);
            pistonGaugeConfigValTxt.setWrapStyleWord(true);
            pistonGaugeConfigValTxt.setBackground(new Color(211,211,211));
            
            tempModeTxt = new JTextArea("Mode of Temperature Measured:");
            tempModeTxt.setLineWrap(true);
            tempModeTxt.setWrapStyleWord(true);
            tempModeTxt.setBackground(new Color(211,211,211));
            
            resistancePRTTxt = new JTextArea("Resistance of PRT of the Standard Gauge at 0'C:");
            resistancePRTTxt.setLineWrap(true);
            resistancePRTTxt.setWrapStyleWord(true);
            resistancePRTTxt.setBackground(new Color(211,211,211));
            
            uncertainityTxt = new JTextArea("UNCERTAINTY (k = 1 in ppm):");
            uncertainityTxt.setLineWrap(true);
            uncertainityTxt.setWrapStyleWord(true);
            uncertainityTxt.setBackground(new Color(211,211,211));
            
            fileInputTxt = new JTextArea("FILE INPUT:");
            fileInputTxt.setLineWrap(true);
            fileInputTxt.setWrapStyleWord(true);
            fileInputTxt.setBackground(new Color(211,211,211));
                        
            LRANGETxt = new JTextArea("Lowest Pressure:");
            LRANGETxt.setLineWrap(true);
            LRANGETxt.setWrapStyleWord(true);
            LRANGETxt.setBackground(new Color(211,211,211));
    
            HRANGETxt = new JTextArea("Highest Pressure:");
            HRANGETxt.setLineWrap(true);
            HRANGETxt.setWrapStyleWord(true);
            HRANGETxt.setBackground(new Color(211,211,211));
            
            gaugeUnderTestTxt = new JTextArea("THE GAUGE UNDER TEST:");
            gaugeUnderTestTxt.setLineWrap(true);
            gaugeUnderTestTxt.setWrapStyleWord(true);
            gaugeUnderTestTxt.setBackground(new Color(211,211,211));
            
            uncertainEstUsingTxt = new JTextArea("UNCERTAINITY ESTIMATION USING:");
            uncertainEstUsingTxt.setLineWrap(true);
            uncertainEstUsingTxt.setWrapStyleWord(true);
            uncertainEstUsingTxt.setBackground(new Color(211,211,211));
            
            dataFileTxt = new JTextArea("DATA FILE TO BE OPENED:");
            dataFileTxt.setLineWrap(true);
            dataFileTxt.setWrapStyleWord(true);
            dataFileTxt.setBackground(new Color(211,211,211));
            
            gmanfTxt = new JTextArea("ACCELERATION OF GRAVITY AT MANUFECTURER'S SITE (gmanf):");
            gmanfTxt.setLineWrap(true);
            gmanfTxt.setWrapStyleWord(true);
            gmanfTxt.setBackground(new Color(211,211,211));
            
            RESTxt = new JTextArea("RESOLUTION OF TEST GAUGE:");
            RESTxt.setLineWrap(true);
            RESTxt.setWrapStyleWord(true);
            RESTxt.setBackground(new Color(211,211,211));
            
            calAccuracyTxt = new JTextArea("CALCULATE ACCURACY OF THE GAUGE UNDER TEST:");
            calAccuracyTxt.setLineWrap(true);
            calAccuracyTxt.setWrapStyleWord(true);
            calAccuracyTxt.setBackground(new Color(211,211,211));
            
            TESTxt = new JTextArea("ESTIMATE EFFECTIVE AREA OF THE TEST PISTON GAUGE:");
            TESTxt.setLineWrap(true);
            TESTxt.setWrapStyleWord(true);
            TESTxt.setBackground(new Color(211,211,211));
            
            outputToFileTxt = new JTextArea("PRINT THE DATA IN OUTPUT FILE:");
            outputToFileTxt.setLineWrap(true);
            outputToFileTxt.setWrapStyleWord(true);
            outputToFileTxt.setBackground(new Color(211,211,211));
            
            outputFileTxt = new JTextArea("NAME OF THE OUTPUT FILE ( ****.DAT ):");
            outputFileTxt.setLineWrap(true);
            outputFileTxt.setWrapStyleWord(true);
            outputFileTxt.setBackground(new Color(211,211,211));
            
            curveFittingTxt = new JTextArea("WANT TO DO CURVE FITTING?");
            curveFittingTxt.setLineWrap(true);
            curveFittingTxt.setWrapStyleWord(true);
            curveFittingTxt.setBackground(new Color(211,211,211));
                       
            CFOutputFileTxt = new JTextArea("NAME OF THE OUTPUT FILE ( ****.DAT ):");
            CFOutputFileTxt.setLineWrap(true);
            CFOutputFileTxt.setWrapStyleWord(true);
            CFOutputFileTxt.setBackground(new Color(211,211,211));
            
            fittedOutputFileTxt= new JTextArea("NAME OF THE OUTPUT FILE WHERE FITTED DATA TO BE STORED:");
            fittedOutputFileTxt.setLineWrap(true);
            fittedOutputFileTxt.setWrapStyleWord(true);
            fittedOutputFileTxt.setBackground(new Color(211,211,211));
            
            numTermsTxt = new JTextArea("NUMBER OF TERMS:");
            numTermsTxt.setLineWrap(true);
            numTermsTxt.setWrapStyleWord(true);
            numTermsTxt.setBackground(new Color(211,211,211));
            
            coverageFactorTxt = new JTextArea("COVERAGE FACTOR k:");
            coverageFactorTxt.setLineWrap(true);
            coverageFactorTxt.setWrapStyleWord(true);
            coverageFactorTxt.setBackground(new Color(211,211,211));
            
           // pressureUnitTxt.setBounds(0, 0, 50, 20);
            pressureUnitList = new JComboBox(pressureUnitStr);
            //petList.setBounds(x, y, width, height);
            pressureUnitList.setSelectedIndex(0);
            
            standardUsedList = new JComboBox(standardUsed);
            
            fixedAirDensityList = new JComboBox(yesNoStr);
            fixedAirDensityList.setSelectedIndex(0);
            fixedAirDensityList.addActionListener(this);
            
            pistonGaugeSelectionList = new JComboBox(pistonGaugeSelectionStr);
            pistonGaugeSelectionList.setSelectedIndex(0);
            pistonGaugeSelectionList.addActionListener(this);
            
            tempModeList = new JComboBox(tempModeStr);
            tempModeList.setSelectedIndex(0);
            tempModeList.addActionListener(this);
            
            gaugeUnderTestList = new JComboBox(gaugeUnderTestStr);
            gaugeUnderTestList.setSelectedIndex(0);
            gaugeUnderTestList.addActionListener(this);
            
            uncertainEstUsingList = new JComboBox(uncertainEstUsingStr);
            uncertainEstUsingList.setSelectedIndex(0);
            uncertainEstUsingList.addActionListener(this);
            
            fileInputList = new JComboBox(fileInputStr);
            fileInputList.setSelectedIndex(0);
            fileInputList.addActionListener(this);
            
            calAccuracyList = new JComboBox(yesNoStr);
            calAccuracyList.setSelectedIndex(0);
            calAccuracyList.addActionListener(this);
            
            TESList = new JComboBox(yesNoStr);
            TESList.setSelectedIndex(0);
            TESList.addActionListener(this);
            TESList.setEnabled(true);
            
            outputToFileList = new JComboBox(yesNoStr);
            outputToFileList.setSelectedIndex(0);
            outputToFileList.addActionListener(this);
            outputToFileList.setEnabled(true);
            
            curveFittingList = new JComboBox(yesNoStr);
            curveFittingList.setSelectedIndex(0);
            curveFittingList.addActionListener(this);
            curveFittingList.setEnabled(true);
            
            coverageFactorList = new JComboBox(coverageFactorStr);
            coverageFactorList.setSelectedIndex(0);
            coverageFactorList.addActionListener(this);
            coverageFactorList.setEnabled(true);
            
            
            caliPointVal = new JTextField();
            dataPointVal = new JTextField();
            scaleReadVal = new JTextField();
            ambTempVal = new JTextField();
            diffMeterVal = new JTextField();
            tareWeightVal = new JTextField();
            fixedAirDensityVal = new JTextField();
            resistancePRTVal = new JTextField();
            uncertainityVal  = new JTextField();
            HRANGEVal= new JTextField();
            LRANGEVal= new JTextField();
            dataFileVal = new JTextField();
            gmanfVal = new JTextField();
            RESVal = new JTextField();RESVal.setEditable(false);
            outputFileVal = new JTextField();
            CFOutputFileVal = new JTextField();
            fittedOutputFileVal = new JTextField();
            numTermsVal = new JTextField();
            
            submit = new JButton("Submit");
            submit.addActionListener(this);
            pnlMain1.add(submit);
            
            
            pnlMain.add(pressureUnitTxt);
            pnlMain.add(pressureUnitList);
            pnlMain.add(caliPointTxt);
            pnlMain.add(caliPointVal);
            pnlMain.add(dataPointTxt);
            pnlMain.add(dataPointVal);
            pnlMain.add(scaleReadTxt);
            pnlMain.add(scaleReadVal);
            pnlMain.add(standardUsedTxt);
            pnlMain.add(standardUsedList);
            pnlMain.add(ambTempTxt);
            pnlMain.add(ambTempVal);
            pnlMain.add(diffMeterTxt);
            pnlMain.add(diffMeterVal);
            pnlMain.add(tareWeightTxt);
            pnlMain.add(tareWeightVal);
            pnlMain.add(fixedAirDensitytxt);
            pnlMain.add(fixedAirDensityList);
            pnlMain.add(fixedAirDensityValTxt);
            pnlMain.add(fixedAirDensityVal);
            pnlMain.add(pistonGaugeSelectionTxt);
            pnlMain.add(pistonGaugeSelectionList);
            pnlMain.add(pistonGaugeConfigTxt);
            pnlMain.add(pistonGaugeConfigValTxt);
            pnlMain.add(tempModeTxt);
            pnlMain.add(tempModeList);   
            pnlMain.add(resistancePRTTxt);
            pnlMain.add(resistancePRTVal);
            pnlMain.add(uncertainityTxt);
            pnlMain.add(uncertainityVal);
            pnlMain.add(LRANGETxt);
            pnlMain.add(LRANGEVal);
            pnlMain.add(HRANGETxt);
            pnlMain.add(HRANGEVal);
            pnlMain.add(gaugeUnderTestTxt);
            pnlMain.add(gaugeUnderTestList);
            pnlMain.add(uncertainEstUsingTxt);
            pnlMain.add(uncertainEstUsingList);
            pnlMain.add(fileInputTxt);
            pnlMain.add(fileInputList);
            pnlMain.add(dataFileTxt);
            pnlMain.add(dataFileVal);
            pnlMain.add(gmanfTxt);
            pnlMain.add(gmanfVal);
            pnlMain.add(RESTxt);
            pnlMain.add(RESVal);
            pnlMain.add(calAccuracyTxt);
            pnlMain.add(calAccuracyList);
            pnlMain.add(TESTxt);
            pnlMain.add(TESList);
            pnlMain.add(outputToFileTxt);
            pnlMain.add(outputToFileList);          
            pnlMain.add(outputFileTxt); pnlMain.add(outputFileVal);
            pnlMain.add(curveFittingTxt); pnlMain.add(curveFittingList);
            pnlMain.add(CFOutputFileTxt);pnlMain.add(CFOutputFileVal);
            pnlMain.add(fittedOutputFileTxt);pnlMain.add(fittedOutputFileVal);
            pnlMain.add(numTermsTxt);pnlMain.add(numTermsVal);
            pnlMain.add(coverageFactorTxt);pnlMain.add(coverageFactorList);
          //pnlMain.add();pnlMain.add();
          //pnlMain.add();pnlMain.add();
          //pnlMain.add();pnlMain.add();
            
            
            c.add(pnlMain);
            c.add(pnlMain1);
      }

      public void showMsg(String msg, String type){
    	  JOptionPane.showMessageDialog(c, "         "+msg,
    			  type, JOptionPane.PLAIN_MESSAGE);
      }

      public void mouseClicked(MouseEvent e)
      {

      }
      

      public boolean checkFields()
      {
    	  boolean error=false;
		  caliPointStr=caliPointVal.getText();
		  //System.out.println("String:"+caliPointStr+"EE");
		  if (caliPointStr.isEmpty())
		  {
			  //caliPointVal.setBorder(arg0);
			  caliPointVal.setBackground(Color.pink);
			  //showMsg("Empty Field: Marked Red","Error");
			  error=true;
			  //return false;
		  }else{
			  caliPointVal.setBackground(Color.white); 
		  }
		  
		  dataPointStr=dataPointVal.getText();
		  if (dataPointStr.isEmpty())
		  {
			  //dataPointVal.setBorder(arg0);
			  dataPointVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  dataPointVal.setBackground(Color.white); 
		  }
		  
		  scaleReadStr=scaleReadVal.getText();
		  if (scaleReadStr.isEmpty())
		  {
			  //scaleReadVal.setBorder(arg0);
			  scaleReadVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  scaleReadVal.setBackground(Color.white); 
		  }
		  
		  ambTempStr=ambTempVal.getText();
		  if (ambTempStr.isEmpty())
		  {
			  //ambTempVal.setBorder(arg0);
			  ambTempVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  ambTempVal.setBackground(Color.white); 
		  }
		  
		  diffMeterStr=diffMeterVal.getText();
		  if (diffMeterStr.isEmpty())
		  {
			  //diffMeterVal.setBorder(arg0);
			  diffMeterVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  diffMeterVal.setBackground(Color.white); 
		  }
		  
		  tareWeightStr=tareWeightVal.getText();
		  if (tareWeightStr.isEmpty())
		  {
			  //tareWeightVal.setBorder(arg0);
			  tareWeightVal.setBackground(Color.pink);
			  error=true;
			  // showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  tareWeightVal.setBackground(Color.white); 
		  }
		  
		  fixedAirDensityStr=fixedAirDensityVal.getText();
		  if (fixedAirDensityStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  fixedAirDensityVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  fixedAirDensityVal.setBackground(Color.white); 
		  }
		  
		  resistancePRTStr=resistancePRTVal.getText();
		  if (resistancePRTStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  resistancePRTVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  resistancePRTVal.setBackground(Color.white); 
		  }
		  
		  uncertainityStr= uncertainityVal.getText();
		  if (uncertainityStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  uncertainityVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  uncertainityVal.setBackground(Color.white); 
		  }
		  
		  LRANGEStr= LRANGEVal.getText();
		  if (LRANGEStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  LRANGEVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  LRANGEVal.setBackground(Color.white); 
		  }
		  
		  HRANGEStr= HRANGEVal.getText();
		  if (HRANGEStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  HRANGEVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  HRANGEVal.setBackground(Color.white); 
		  }
		  
		  dataFileStr= dataFileVal.getText();
		  if (dataFileStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  dataFileVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  dataFileVal.setBackground(Color.white); 
		  }
		  
		  if(gmanfVal.isEditable()==true){
		  gmanfStr= gmanfVal.getText();
		  if (gmanfStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  gmanfVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  gmanfVal.setBackground(Color.white); 
		  }
		  }
		  
		  if(RESVal.isEditable()==true){
		  RESStr= RESVal.getText();
		  if (RESStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  RESVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  RESVal.setBackground(Color.white); 
		  }
		  }
		  
		   // JTextField 
		  outputFileStr= outputFileVal.getText();
		  if (outputFileStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  outputFileVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  outputFileVal.setBackground(Color.white); 
		  }
		  
		  CFOutputFileStr=CFOutputFileVal.getText();
		  if (CFOutputFileStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  CFOutputFileVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  CFOutputFileVal.setBackground(Color.white); 
		  }
		  
		  fittedOutputFileStr=fittedOutputFileVal.getText();
		  if (fittedOutputFileStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  fittedOutputFileVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  fittedOutputFileVal.setBackground(Color.white); 
		  }
		  
		  numTermsStr=numTermsVal.getText();
		  if (numTermsStr.isEmpty())
		  {
			  //fixedAirDensityVal.setBorder(arg0);
			  numTermsVal.setBackground(Color.pink);
			  error=true;
			  //showMsg("Empty Field: Marked Red","Error");
			  //return false;
		  }else{
			  numTermsVal.setBackground(Color.white); 
		  }
		  
		  
		  if (error == true){
			  showMsg("Empty Field(s): Marked Red","Error");
			  return false;
		  }
    	  return true;
      }
      
      
      /** Listens to the combo box and other sources. */
      public void actionPerformed(ActionEvent e) {
    	  if(e.getSource()==submit){

    		  checkFields();
    		  
    	  }else if(e.getSource()==fixedAirDensityList){
              JComboBox cb = (JComboBox)e.getSource();
              String str = (String)cb.getSelectedItem();
              if(str.equals("No")){
            	  fixedAirDensityVal.setEditable(false);
              } else{
            	  fixedAirDensityVal.setEditable(true);
              }                  		  
    	  } else if(e.getSource()==pistonGaugeSelectionList){
    		  JComboBox cb = (JComboBox)e.getSource();
              String str = (String)cb.getSelectedItem();
              String configFile="etc/PG/";
              configFile=configFile+str+".DAT";
              pistonGaugeConfigValTxt.setText(configFile);
              if(str.equals("PG270KPA")){
            	  ;
              } else if(str.equals("PG28MPA")){
            	  USTD = 0.000074 * FSR;
            	  LRANGE = 0.07;
            	  HRANGE = 28;
              }else if(str.equals("PG60MPA")){
            	  USTD = 0.000074 * FSR;
            	  LRANGE = 10;
            	  HRANGE = 800;
              }else if(str.equals("PG100MPA")){
            	  USTD = 0.000075 * FSR;
            	  LRANGE = 0.2;
            	  HRANGE = 100;
              }else if(str.equals("PG100MPN")){
            	  USTD = 0.000061 * FSR;
            	  LRANGE = 0.2;
            	  HRANGE = 100;
              }else if(str.equals("PG140MPA")){
            	  USTD = 0.000074 * FSR;
            	  LRANGE = 0.24;
            	  HRANGE = 140;
              }else if(str.equals("PG200MPA")){
            	  USTD = 0.000068 * FSR;
            	  LRANGE = 0.4;
            	  HRANGE = 200;
              }else if(str.equals("PG200MPN")){
            	  USTD = 0.000068 * FSR;
            	  LRANGE = 0.4;
            	  HRANGE = 200;
              }else if(str.equals("PG280MPA")){
            	  USTD = 0.000068 * FSR;
            	  LRANGE = 0.48;
            	  HRANGE = 280;
              }else if(str.equals("PG500MPA")){
            	  USTD = 0.000067 * FSR;
            	  LRANGE = 1;
            	  HRANGE = 500;
              }else if(str.equals("PG500MPN")){
            	  USTD = 0.000068 * FSR;
            	  LRANGE = 1;
            	  HRANGE = 500;
              }
              
              STDB = USTD / FSR;
    	  
    	  }else if(e.getSource()==tempModeList){
    		  JComboBox cb = (JComboBox)e.getSource();
              String str = (String)cb.getSelectedItem();
              if(str.equals("0'C")){
            	  resistancePRTVal.setEditable(false);
              } else{
            	  resistancePRTVal.setEditable(true);
              }                  		  

    	  }else if(e.getSource()==gaugeUnderTestList){
    		  JComboBox cb = (JComboBox)e.getSource();
              String str = (String)cb.getSelectedItem();
              if(str.equals("DEAD WEIGHT TESTER")){
            	  gmanfVal.setEditable(true);
            	  RESVal.setEditable(false);
            	  RESVal.setBackground(Color.white);
            	  TESList.setEnabled(true);
              }else{
            	  gmanfVal.setEditable(false);   
            	  RESVal.setEditable(true);
            	  TESList.setEnabled(false);
              }
    	  }else if(e.getSource()==outputToFileList){
    		  JComboBox cb = (JComboBox)e.getSource();
              String str = (String)cb.getSelectedItem();
              if(str.equals("Yes")){
            	  outputFileVal.setEditable(true);
            	  //RESVal.setEditable(false);
            	  //TESList.setEnabled(true);
              }else{
            	  outputFileVal.setEditable(false);
            	  outputFileVal.setBackground(Color.white);
            	  //RESVal.setEditable(true);
            	  //TESList.setEnabled(false);
              }
    	  }else if(e.getSource()==curveFittingList){
    		  JComboBox cb = (JComboBox)e.getSource();
              String str = (String)cb.getSelectedItem();
              if(str.equals("Yes")){
            	  CFOutputFileVal.setEditable(true);
            	  //RESVal.setEditable(false);
            	  //TESList.setEnabled(true);
              }else{
            	  CFOutputFileVal.setBackground(Color.white);
            	  CFOutputFileVal.setEditable(false);
            	  
            	  //RESVal.setEditable(true);
            	  //TESList.setEnabled(false);
              }
    	  }
    	  
    }
}