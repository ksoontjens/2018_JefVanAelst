package hellotvxlet;

import javax.tv.xlet.*;


import org.havi.ui.*;

import java.awt.*;
import java.awt.event.*;
import org.havi.ui.event.*;




public class HelloTVXlet implements Xlet, HActionListener {

    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug=true;
    
    private HTextButton knop1 , knop2, resultaat,titel;
    
   
  
    
        
    public void actionPerformed (ActionEvent e){
        System.out.println(e.getActionCommand());  
        
        if(e.getActionCommand() == "knop1_actioned"){
            resultaat.setTextContent("Dag meneer", HState.NORMAL_STATE);
        }
        if(e.getActionCommand() == "knop2_actioned"){
            resultaat.setTextContent("Dag mevrouw", HState.NORMAL_STATE);
        }
        
        
    }
    
    public void initXlet(XletContext context) throws XletStateChangeException {
        if(debug) System.out.println("Xlet Initialiseren");
        this.actueleXletContext = context;
        
        HSceneTemplate sceneTemplate= new HSceneTemplate(); 
        
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension (1.0f, 1.0f), HSceneTemplate.REQUIRED );
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint (0.0f, 0.0f), HSceneTemplate.REQUIRED );
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);

            knop1 = new HTextButton("Man");
            knop1.setLocation(100,250);
            knop1.setSize(200,100);                      
            knop1.setBackground(Color.BLUE);
            knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);      
        
            knop2 = new HTextButton("Vrouw");
            knop2.setLocation(400,250);
            knop2.setSize(200,100);
            knop2.setBackground(Color.BLUE);
            knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            resultaat = new HTextButton("");
            resultaat.setLocation(100,400);
            resultaat.setSize(500,100);
            resultaat.setBackground(Color.BLUE);
            resultaat.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
           
            // titel
            titel = new HTextButton("Bent u een man of vrouw?");
            titel.setLocation(20,20);
            titel.setSize(680,80);
            titel.setBackground(Color.RED);
            titel.setBackgroundMode(HVisible.BACKGROUND_FILL);
            
            
        knop1. setFocusTraversal (null, null, null, knop2 ) ; // op , neer , links ,rechts
        knop2. setFocusTraversal (null, null , knop1 , null ) ; // op , neer , links ,rechts   
    
      knop1.setActionCommand("knop1_actioned");      
      knop2.setActionCommand("knop2_actioned");
      
      
      knop1.addHActionListener(this);
      knop2.addHActionListener(this);
      
      
      scene.add(knop1);
      scene.add(knop2);
      scene.add(resultaat);
      scene.add(titel);    
   
      knop1.requestFocus();     
      
    }    
    
    public void startXlet() throws XletStateChangeException {
        if(debug) System.out.println("Xlet starten");
        
        scene.validate();
        scene.setVisible(true);        
        
        
    }
    
    public void pauseXlet() {
       
    }    
     public void destroyXlet(boolean unconditional) throws XletStateChangeException {
     
    }
     
}