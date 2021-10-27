
package Inicio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JPanel;

public class Panel extends JPanel{
    public double[][] Focos =new double[4][2]; 
    public double[][] puntos =new double[21][2];
    public double t;
    public int lugar=0;
    public Panel() {
        setLayout(null);
        Lienzo lienzo=new Lienzo(puntos,Focos);
        GLCanvas canvas=new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(lienzo);
        canvas.setBounds(0, 0, 500,500);
        add(canvas);
        /*canvas.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e) {
                for(int i=0;i<Focos.length;i++){
                    if(((Math.abs(((e.getX()/2.5)-lienzo.miraX-100)-Focos[i][0]))
                            +Math.abs((((-e.getY()/2.5)-lienzo.miraY+100)-Focos[i][1]))<=4)){
                        Focos[i][0]=(e.getX()/2.5)-lienzo.miraX-100;
                        Focos[i][1]=(-e.getY()/2.5)-lienzo.miraY+100;
                        t=0;
                        if(Focos[i][0]>100){Focos[i][0]=100;}
                        if(Focos[i][0]<-100){Focos[i][0]=-100;}
                        if(Focos[i][1]>100){Focos[i][1]=100;}
                        if(Focos[i][1]<-100){Focos[i][1]=-100;}
                        for(int j=0;j<puntos.length;j++){
                            puntos[j][0]=calcularX(Focos.length,t,Focos,0);
                            puntos[j][1]=calcularY(Focos.length,t,Focos,0);
                            t+=0.05;
                        }
                        lienzo.cambiar(puntos,Focos);
                        canvas.repaint();
                        break;
                    }
                }  
            }
            @Override
            public void mouseMoved(MouseEvent e) {}
        });
        
        canvas.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                if(lugar<Focos.length){
                    for(int i=lugar;i<Focos.length;i++){
                        Focos[i][0]=(e.getX()/2.5)-lienzo.miraX-100;
                        Focos[i][1]=(-e.getY()/2.5)-lienzo.miraY+100;
                    }
                    lugar++;
                    t=0;
                    for(int i=0;i<puntos.length;i++){
                        puntos[i][0]=calcularX(Focos.length,t,Focos,0);
                        puntos[i][1]=calcularY(Focos.length,t,Focos,0);
                        t+=0.05;
                    }
                    lienzo.cambiar(puntos,Focos);
                    canvas.repaint();
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });*/
        
        canvas.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                /*if(e.getKeyCode()==KeyEvent.VK_X){
                    lugar=0;
                    for(int i=0;i<Focos.length;i++){    
                        Focos[i][0]=200;
                        Focos[i][0]=200;
                    }
                    for(int i=0;i<puntos.length;i++){
                        puntos[i][0]=200;
                        puntos[i][0]=200;
                    }
                    lienzo.cambiar(puntos, Focos);
                }*/
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    lienzo.vistaY(1);
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    lienzo.vistaY(-1);
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    lienzo.vistaX(-1);
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    lienzo.vistaX(1);
                }
                if(e.getKeyCode()==KeyEvent.VK_C){
                    lienzo.vistaZ(-1);
                }
                if(e.getKeyCode()==KeyEvent.VK_V){
                    lienzo.vistaZ(1);
                }
                if(e.getKeyCode()==KeyEvent.VK_Z){
                    lienzo.rotaZ(1);
                }
                if(e.getKeyCode()==KeyEvent.VK_X){
                    lienzo.rotaZ(-1);
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    lienzo.rotaX(1);
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    lienzo.rotaX(-1);
                }
                if(e.getKeyCode()==KeyEvent.VK_Q){
                    lienzo.rotaY(-1);
                }
                if(e.getKeyCode()==KeyEvent.VK_W){
                    lienzo.rotaY(-1);
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    lienzo.grados(10);
                }
                if(e.getKeyCode()==KeyEvent.VK_F){
                    lienzo.grados(-10);
                }
                if(e.getKeyCode()==KeyEvent.VK_E){
                    lienzo.miraX=0;
                    lienzo.miraY=0;
                    lienzo.miraZ=0;
                    lienzo.rotaX=0;
                    lienzo.rotaY=0;
                    lienzo.rotaZ=0;
                    lienzo.gra=0;
                    lienzo.EscalaX=1;
                    lienzo.EscalaY=1;
                    lienzo.EscalaZ=1;
                    double[][] coor={{0,0,0}
                            ,{0,10,0}
                            ,{10,10,0}
                            ,{10,0,0}
                            ,{0,0,10}
                            ,{0,10,10}
                            ,{10,10,10}
                            ,{10,0,10}};
                    lienzo.coor=coor;
                }
                if(e.getKeyCode()==KeyEvent.VK_G){
                    lienzo.escalarY(0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_H){
                    lienzo.escalarY(-0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_T){
                    lienzo.escalarX(0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_Y){
                    lienzo.escalarY(-0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_B){
                    lienzo.escalarZ(0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_N){
                    lienzo.escalarZ(-0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_U){
                    lienzo.sesgarX(0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_I){
                    lienzo.sesgarX(-0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_J){
                    lienzo.sesgarY(0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_K){
                    lienzo.sesgarY(-0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_M){
                    lienzo.sesgarZ(0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_P){
                    lienzo.sesgarZ(-0.1);
                }
                canvas.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
    
    public double calcularX(int n,double t,double[][] puntos,int p){
        double punto;
        if(n<=2){
            return (1-t)*puntos[p][0]+(t*puntos[p+1][0]);
        }else{
            return ((1-t)*calcularX(n-1,t,puntos,p))+t*calcularX(n-1,t,puntos,p+1);
        }
    } 
    public double calcularY(int n,double t,double[][] puntos,int p){
        double punto;
        if(n<=2){
            return (1-t)*puntos[p][1]+(t*puntos[p+1][1]);
        }else{
            return ((1-t)*calcularY(n-1,t,puntos,p))+t*calcularY(n-1,t,puntos,p+1);
        }
    } 
}
