import model.MyProServer;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyServerFrame extends JFrame implements ActionListener {

    JPanel jp1;
    JButton jb1,jb2;
    public MyServerFrame(){
        jp1=new JPanel();
        jb1=new JButton("启动服务器");
        jb1.addActionListener(this);
        jb2=new JButton("关闭服务器");
        jp1.add(jb1);
        jp1.add(jb2);

        add(jp1);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }




    public static void main(String[] args) {
     new MyProServer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==jb1){
          new MyProServer();
      }
    }
}
