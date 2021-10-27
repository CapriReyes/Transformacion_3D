package Inicio;

import javax.swing.JFrame;

public class Pantalla extends JFrame{
    public Panel panel;
    public Pantalla(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Titulo");
        setSize(516,539);
         setLocationRelativeTo(null);
        componentes();
    }  
    
    public void componentes(){
        setLayout(null);
        panel=new Panel();
        panel.setBounds(0, 0,getWidth(),getHeight() );
        add(panel);
    }
    
    public static void main(String[] args) {
        Pantalla bezier = new Pantalla();
    }
}

