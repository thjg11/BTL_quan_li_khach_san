

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class QuanTri extends JFrame implements MouseListener,ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();

    JPanel p5=new JPanel();
    JPanel p6=new JPanel();

    ImageIcon iconnv=new ImageIcon("hinhanh/nhanvienbutton.jpg");
    ImageIcon left=new ImageIcon("hinhanh/left.png");

    ImageIcon iconphong=new ImageIcon("hinhanh/phong1.jpg");
    ImageIcon iconphong1=new ImageIcon("hinhanh/logout.png");

    ImageIcon huhu=new ImageIcon("hinhanh/iconkhachsan.jpg");
    JLabel lhuhu=new JLabel(huhu);

    JLabel lleft=new JLabel(left);
    JLabel liconnv=new JLabel(iconnv);

    JLabel liconphong=new JLabel(iconphong);
    JLabel liconphong1=new JLabel(iconphong1);

    ImageIcon iconnnen=new ImageIcon("hinhanh/nen.png");
    JLabel lnen=new JLabel(iconnnen);

    Statement stm;
    ResultSet rs;


    public QuanTri(String title)

    {
        super(title);
        this.setSize(1000, 600);
        this.setLayout(null);
        this.add(p1);
        p1.setBounds(0, 0, 200, 600);
        p1.setBackground(Color.GRAY);
        this.p1();

        this.add(p2);
        p2.setBounds(200, 0, 790, 600);
        this.p2();

    }
    public void p1()
    {
        p1.setLayout(null);
        p1.add(liconnv);
        liconnv.setBounds(0, 150, 200, 50);

        p1.add(liconphong);
        liconphong.setBounds(0, 220, 200, 50);
        p1.add(liconphong1);
        liconphong1.setBounds(0, 510, 50, 50);

        p1.add(lleft);
        lleft.setBounds(0, 0, 200, 600);

        liconnv.addMouseListener(this);
        liconphong.addMouseListener(this);
        liconphong1.addMouseListener(this);
    }
    public void p2()
    {
        p2.setLayout(null);
        p2.add(lhuhu);
        lhuhu.setBounds(0, 50, 800, 500);
        p2.add(lnen);
        lnen.setBounds(0, 0, 800, 600);
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==liconnv)
        {
            NhanVien nv=new NhanVien("NHÂN VIÊN");
            nv.setVisible(true);
            nv.setLocationRelativeTo(nv);
            this.setVisible(false);
        }
        else if(e.getSource()==liconphong)
        {
            Phong p=new Phong("PHÒNG");
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            this.setVisible(false);

        }
        else if(e.getSource()==liconphong1)
        {
            GiaoDien gd=new GiaoDien("PHẦN MỀM QUẢN LÝ KHÁCH SẠN");
            gd.setVisible(true);
            gd.setLocationRelativeTo(null);
            this.setVisible(false);
        }


    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==liconnv)
        {
            liconnv.setCursor(new Cursor(Cursor.HAND_CURSOR));
            liconnv.setBounds(0, 160, 200, 50);
        }
        else if(e.getSource()==liconphong)
        {
            liconphong.setCursor(new Cursor(Cursor.HAND_CURSOR));
            liconphong.setBounds(0, 210, 200, 50);
        }
        else if(e.getSource()==liconphong1)
        {
            liconphong1.setBounds(0, 500, 50, 50);
            liconphong1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        liconnv.setBounds(0, 150, 200, 50);
        liconphong.setBounds(0, 220, 200, 50);
        liconphong1.setBounds(0, 510, 50, 50);
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

}
