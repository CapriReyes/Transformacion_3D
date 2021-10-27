package Inicio;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Lienzo implements GLEventListener{
    public GL gl;
    public GLU glu;
    double[][] puntos;
    double[][] focos;
    public double miraX=0;
    public double miraY=0;
    public double miraZ=0;
    public double rotaZ=0;
    public double rotaX=0;
    public double rotaY=0;
    public double EscalaX=1;
    public double EscalaY=1;
    public double EscalaZ=1;
    public double gra=0;
    public double[][] coor={{0,0,0}
                            ,{0,10,0}
                            ,{10,10,0}
                            ,{10,0,0}
                            ,{0,0,10}
                            ,{0,10,10}
                            ,{10,10,10}
                            ,{10,0,10}};
    public Lienzo(double[][] puntos,double[][] focos){
        this.puntos=puntos;
        this.focos=focos;
    }
    
    public void cambiar(double[][] puntos,double[][] focos){
        this.puntos=puntos;
        this.focos=focos;
    }
    
    public void vistaX(double mira){
        this.miraX+=mira;
    }
    public void vistaY(double mira){
        this.miraY+=mira;
    }
    
    public void vistaZ(double mira){
        this.miraZ+=mira;
    }
    
    public void rotaZ(double mira){
        rotaZ+=mira;
    }
    
    public void rotaX(double mira){
        rotaX+=mira;
    }
    
    public void rotaY(double mira){
        rotaY+=mira;
    }
    
    public void grados(double grad){
        gra+=grad;
    }
    public void escalarX(double escala){
        EscalaX+=escala;
    }
    public void escalarY(double escala){
        EscalaY+=escala;
    }
    public void escalarZ(double escala){
        EscalaZ+=escala;
    }
    public void sesgarX(double c){
        double x;
        double y;
        double z;
        for(int i=0;i<coor.length;i++){
            x=coor[i][0];
            y=coor[i][1];
            z=coor[i][1];
            coor[i][0]+=c*z*y;
        }
    }
    public void sesgarY(double c){
        double x;
        double y;
        double z;
        for(int i=0;i<coor.length;i++){
            x=coor[i][0];
            y=coor[i][1];
            z=coor[i][1];
            coor[i][1]+=c*z*x;
        }
    }
    public void sesgarZ(double c){
        double x;
        double y;
        double z;
        for(int i=0;i<coor.length;i++){
            x=coor[i][0];
            y=coor[i][1];
            z=coor[i][1];
            coor[i][2]+=c*x*y;
        }
    }
    @Override
    public void init(GLAutoDrawable drawable) {
        glu=new GLU();
        gl= drawable.getGL();
        gl.glClearColor(0, 0, 0, 0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        //glu.gluOrtho2D(-100, +100, -100, +100);
        gl.glOrtho(-20, 20,-20,20,-40,40);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl.glLineWidth(5);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glPushMatrix();
            //gl.glRotated(90, 0, 0, 1);
            gl.glTranslated(miraX, miraY, miraZ);
            gl.glRotated(gra, rotaX, rotaY, rotaZ);
            gl.glScaled(EscalaX,EscalaY,EscalaZ);
            gl.glBegin(GL.GL_POLYGON);
               gl.glColor3d(1,0,0);
               gl.glVertex3d(coor[4][0],coor[4][1],coor[4][2]);
               gl.glVertex3d(coor[5][0],coor[5][1],coor[5][2]);
               gl.glVertex3d(coor[6][0],coor[6][1],coor[6][2]);
               gl.glVertex3d(coor[7][0],coor[7][1],coor[7][2]);
            gl.glEnd();
            
            gl.glBegin(GL.GL_POLYGON);
               gl.glColor3d(0,1,0);
               gl.glVertex3d(coor[2][0],coor[2][1],coor[2][2]);
               gl.glVertex3d(coor[3][0],coor[3][1],coor[3][2]);
               gl.glVertex3d(coor[7][0],coor[7][1],coor[7][2]);
               gl.glVertex3d(coor[6][0],coor[6][1],coor[6][2]);
            gl.glEnd();
            gl.glBegin(GL.GL_POLYGON);
               gl.glColor3d(0,0,1);
               gl.glVertex3d(coor[1][0],coor[1][1],coor[1][2]);
               gl.glVertex3d(coor[2][0],coor[2][1],coor[2][2]);
               gl.glVertex3d(coor[6][0],coor[6][1],coor[6][2]);
               gl.glVertex3d(coor[5][0],coor[5][1],coor[5][2]);
            gl.glEnd();
            gl.glBegin(GL.GL_POLYGON);
               gl.glColor3d(1,1,0);
               gl.glVertex3d(coor[0][0],coor[0][1],coor[0][2]);
               gl.glVertex3d(coor[1][0],coor[1][1],coor[1][2]);
               gl.glVertex3d(coor[5][0],coor[5][1],coor[5][2]);
               gl.glVertex3d(coor[4][0],coor[4][1],coor[4][2]);
            gl.glEnd();
            gl.glBegin(GL.GL_POLYGON);
               gl.glColor3d(0,1,1);
               gl.glVertex3d(coor[0][0],coor[0][1],coor[0][2]);
               gl.glVertex3d(coor[3][0],coor[3][1],coor[3][2]);
               gl.glVertex3d(coor[7][0],coor[7][1],coor[7][2]);
               gl.glVertex3d(coor[4][0],coor[4][1],coor[4][2]);
            gl.glEnd();
            gl.glBegin(GL.GL_POLYGON);
               gl.glColor3d(1,1,1);
               gl.glVertex3d(coor[0][0],coor[0][1],coor[0][2]);
               gl.glVertex3d(coor[1][0],coor[1][1],coor[1][2]);
               gl.glVertex3d(coor[2][0],coor[2][1],coor[2][2]);
               gl.glVertex3d(coor[3][0],coor[3][1],coor[3][2]);
            gl.glEnd();
        gl.glPopMatrix();
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height){}

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}
    
}
