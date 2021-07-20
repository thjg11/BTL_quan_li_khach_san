

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GiaodienKH extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JPanel p1=new JPanel();
    JLabel l1=new JLabel("Chào Mừng Bạn Đến Với Khách Sạn chúng Tôi! Xin Mời Bạn Chọn Các Chưc Năng Sau : ");

    JButton b1=new JButton("Đặt Phòng");
    JButton b2=new JButton("Trang chủ");
    JButton b3=new JButton("Thoát");

    JPanel pdatphong=new JPanel();
    ImageIcon iconnnen=new ImageIcon("hinhanh/nen.png");
    JLabel lnen=new JLabel(iconnnen);

    ImageIcon i1=new ImageIcon("hinhanh/iconkhachsan.jpg");


    JPanel pphong=new JPanel();

    JTable tb;
    Vector<String> rowtitle=new Vector<String>();
    @SuppressWarnings("rawtypes")
    Vector Row;
    DefaultTableModel dtm;
    Statement stm;
    ResultSet rs;

    JTextField t1=new JTextField(20);
    JTextField t2=new JTextField(20);
    JTextField t3=new JTextField(20);
    JTextField t4=new JTextField(20);
    JComboBox c1=new JComboBox();
    JComboBox c2=new JComboBox();
    JButton b4=new JButton("Đăng Ký");

    JLabel li1=new JLabel(i1);
    JPanel pthongtinp=new JPanel();
    public GiaodienKH()
    {
        this.setSize(1000, 600);
        this.setLayout(null);
        this.add(p1);
        p1.setBounds(0, 0, 1000, 50);
        p1.setBackground(Color.GRAY);

        this.add(pdatphong);
        pdatphong.setBounds(0, 50, 500, 530);

        this.add(pphong);
        pphong.setBounds(500, 50, 500, 500);
        p1();
        datphong();
        loadphong();
        loadmaphong();
        b4.addActionListener(this);
        pdatphong.setVisible(false);
        pphong.setVisible(false);
        this.add(li1);
        li1.setBounds(0, 50, 500, 500);

    }
    public void p1()
    {
        p1.setLayout(null);
        p1.add(l1);
        l1.setBounds(0, 0, 500, 50);
        l1.setForeground(Color.WHITE);

        p1.add(b1);
        b1.setBounds(500, 0, 150, 50);
        p1.add(b2);
        b2.setBounds(700, 0, 150, 50);

        p1.add(b3);
        b3.setBounds(880, 0, 100, 50);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    @SuppressWarnings("unchecked")
    public void datphong(){

        pdatphong.setLayout(null);

        JLabel l3=new JLabel("Ngày Nhân Phòng:");
        pdatphong.add(l3);
        l3.setBounds(10, 20, 100, 50);
        pdatphong.add(t1);
        t1.setBounds(130, 30, 200, 30);
        JLabel l4=new JLabel("vd:yyyy-mm-dd");
        pdatphong.add(l4);
        l4.setBounds(330, 20, 100, 50);

        JLabel l5=new JLabel("Ngày Trả Phòng:");
        pdatphong.add(l5);
        l5.setBounds(10, 60, 100, 50);
        pdatphong.add(t2);
        t2.setBounds(130, 70, 200, 30);
        JLabel l6=new JLabel("vd:yyyy-mm-dd");
        pdatphong.add(l6);
        l6.setBounds(330, 60, 100, 50);

        JLabel l7=new JLabel("Chọn Số Người");
        pdatphong.add(l7);
        l7.setBounds(10, 100, 100, 50);

        pdatphong.add(c1);
        c1.setBounds(130, 110, 100, 30);
//		c1.addItem("-Select-");
        for(int i=1;i<=10;i++)
        {
            c1.addItem(i);
        }

        JLabel l8=new JLabel("Chọn đơn giá");
        pdatphong.add(l8);
        l8.setBounds(10, 140, 100, 50);
        pdatphong.add(c2);
        c2.setBounds(130, 150, 100, 30);

        JLabel l9=new JLabel("Họ Tên");
        pdatphong.add(l9);
        l9.setBounds(10, 180, 100, 50);
        pdatphong.add(t3);
        t3.setBounds(130, 190, 200, 30);

        JLabel l10=new JLabel("CMND/Ho Chiếu");
        pdatphong.add(l10);
        l10.setBounds(10, 220, 100, 50);
        pdatphong.add(t4);
        t4.setBounds(130, 230, 200, 30);


        pdatphong.add(b4);
        b4.setBounds(150, 300, 100, 30);
        pdatphong.add(lnen);
        lnen.setBounds(0, 0, 500, 530);
    }
    public void dangky()
    {
        KetNoi kn=new KetNoi();
        String sql="Insert into phieudatphong values('"+t3.getText()+"','"+t4.getText()+"','"+t1.getText()+"','"+t2.getText()+"','"+c2.getSelectedItem()+"','"+c1.getSelectedItem()+"')";
        try{
            stm=kn.con.createStatement();
            int rs=stm.executeUpdate(sql);
            if(rs>0)
            {
                JOptionPane.showMessageDialog(null, "Thanh Cong");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "That bai");
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "loi");
        }
    }
    public void loadmaphong()
    {
        KetNoi kn=new KetNoi();
        try {
            String sql="Select distinct dongia from phong ";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);


        } catch (SQLException e) {


            e.printStackTrace();
        }
//		c2.addItem("- Select -");
        try{
            while(rs.next())
            {
                c2.addItem(rs.getString("dongia"));
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi !!!!!!!");
        }
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void loadphong()
    {
        rowtitle.add("Mã phòng");
        rowtitle.add("Số Phòng");
        rowtitle.add("Mã Loại Phòng");
        rowtitle.add("Tình Trạng");
        rowtitle.add("Đơn Giá");
        dtm=new DefaultTableModel(rowtitle,0);
        pphong.setLayout(null);
        tb=new JTable(dtm);
        JTableHeader header = tb.getTableHeader();
        header.setBackground(Color.GREEN);


        JScrollPane scrollTable = new JScrollPane(tb);
        scrollTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setSize(480, 500);
        pphong.add(scrollTable);

        KetNoi kn=new KetNoi();


        try
        {
            String sql="select * from phong where tinhtrang='null'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                Row=new Vector();
                Row.addElement(rs.getString("maphong").trim());
                Row.addElement(rs.getString("sophong").trim());
                Row.addElement(rs.getString("maloaiphong").trim());
                Row.addElement(rs.getString("tinhtrang").trim());
                Row.addElement(rs.getFloat("Dongia"));
                dtm.addRow(Row);

            }

            tb.setModel(dtm);
            kn.con.close();
            stm.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Khong the tai du lieu!");
            e.printStackTrace();
        }
    }

    //   public static void main(String []args)
//   {
//	   GiaodienKH gdkh=new GiaodienKH();
//	   gdkh.setVisible(true);
//	   gdkh.setLocationRelativeTo(null);
//   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            pdatphong.setVisible(true);
            pphong.setVisible(true);
            li1.setVisible(false);


        }
        else if(e.getSource()==b2)
        {
            pdatphong.setVisible(false);
            pphong.setVisible(false);
            li1.setVisible(true);

        }
        else if(e.getSource()==b3)
        {
            System.exit(0);
        }
        else if(e.getSource()==b4)
        {
            if(t1.getText().length()<=0 || t2.getText().length()<=0 || t3.getText().length()<=0|| t4.getText().length()<=0)
            {
                JOptionPane.showMessageDialog(null, "bạn Không Nên Để Trông");
            }
            else
            {
                int i=JOptionPane.showConfirmDialog(this,"bạn co muốn đăng ký không ?","Thông Báo",JOptionPane.OK_CANCEL_OPTION);
                if(i==0)
                {
                    dangky();
                }
                else
                {

                }
            }
        }

    }
}
