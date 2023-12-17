import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main extends JFrame implements ActionListener {

    JTextField field1;
    JTextField field2;
    JTextField field3;
    JButton first;
    JButton second;
    Main(){

        setLayout(null);
        setSize(400,400);
        addComponent();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void addComponent(){
        field1= new JTextField();
        field2= new JTextField();
        field3= new JTextField();

        first=new JButton("sort by first");
        second=new JButton("sort by second");




        field1.setBounds(20,50,100,50);
        field2.setBounds(140,50,100,50);
        field3.setBounds(260,50,100,50);

        first.setBounds(20,200,150,60);
        second.setBounds(220,200,150,60);


    add(field1);
    add(field2);
    add(field3);
    add(first);
    add(second);

    first.addActionListener(this);
    second.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e){

            ArrayList<Point> points=new ArrayList<>();
            String values1= field1.getText();
            String values2= field2.getText();
            String values3= field3.getText();

            String parts[]= values1.split(",");
            int x1=Integer.parseInt(parts[0]);
            int y1=Integer.parseInt(parts[1]);
            String parts2[]= values2.split(",");
            int x2=Integer.parseInt(parts2[0]);
            int y2=Integer.parseInt(parts2[1]);
            String parts3[]= values3.split(",");
            int x3=Integer.parseInt(parts3[0]);
            int y3=Integer.parseInt(parts3[1]);


            Point p1= new Point(x1,y1);
            Point p2= new Point(x2,y2);
            Point p3= new Point(x3,y3);

            points.add(p1);
            points.add(p2);
            points.add(p3);



        if(e.getSource()==first){
            Point.state=1;
            Collections.sort(points);
            int afterx1=points.get(0).x;
            int aftery1=points.get(0).y;
            String aftervalues1 =String.valueOf(afterx1)+","+String.valueOf(aftery1);
            field1.setText(aftervalues1);

            int afterx2=points.get(1).x;
            int aftery2=points.get(1).y;
            String aftervalues2 =String.valueOf(afterx2)+","+String.valueOf(aftery2);
            field2.setText(aftervalues2);

            int afterx3=points.get(2).x;
            int aftery3=points.get(2).y;
            String aftervalues3 =String.valueOf(afterx3)+","+String.valueOf(aftery3);
            field3.setText(aftervalues3);

//            System.out.println(x1);
//            System.out.println(y1);
//            System.out.println("++++++++");
//            System.out.println(x2);
//            System.out.println(y2);
//            System.out.println("++++++++");
//            System.out.println(x3);
//            System.out.println(y3);
//            System.out.println("++++++++");



        } else if (e.getSource()==second) {
            Point.state=2;

            Collections.sort(points);
            int afterx1=points.get(0).x;
            int aftery1=points.get(0).y;
            String aftervalues1 =String.valueOf(afterx1)+","+String.valueOf(aftery1);
            field1.setText(aftervalues1);

            int afterx2=points.get(1).x;
            int aftery2=points.get(1).y;
            String aftervalues2 =String.valueOf(afterx2)+","+String.valueOf(aftery2);
            field2.setText(aftervalues2);

            int afterx3=points.get(2).x;
            int aftery3=points.get(2).y;
            String aftervalues3 =String.valueOf(afterx3)+","+String.valueOf(aftery3);
            field3.setText(aftervalues3);
        }


    }





    public static void main(String[] args) {
       new Main();
    }
}

class Point implements Comparable<Point> {
    static int state=0;
    int x;
    int y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Point o) {

        if(Point.state==1) {
            if (x > o.x) {
                return 1;
            } else if (x < o.x) {
                return -1;
            }
            return 0;
        } else  {
            if (y > o.y) {
                return 1;
            } else if (y < o.y) {
                return -1;
            }
            return 0;
        }
    }
}