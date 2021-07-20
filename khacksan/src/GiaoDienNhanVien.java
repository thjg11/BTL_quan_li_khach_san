

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GiaoDienNhanVien extends JFrame implements MouseListener,ActionListener {

    JPanel p1=new JPanel();
    JPanel p2=new JPanel();

    JPanel p5=new JPanel();
    JPanel p6=new JPanel();


    ImageIcon left=new ImageIcon("hinhanh/khungtrai.jpg");
    ImageIcon hinhanhnhanvien=new ImageIcon("hinhanh/icon2.png");

    ImageIcon iconkh=new ImageIcon("hinhanh/khachhang.jpg");
    JLabel liconkh=new JLabel(hinhanhnhanvien);
    ImageIcon icondangky=new ImageIcon("hinhanh/dangkykh.jpg");
    ImageIcon icontimphong=new ImageIcon("hinhanh/timphong.jpg");
    ImageIcon iconhoadon=new ImageIcon("hinhanh/labelhoadon.jpg");
    ImageIcon iconlogout=new ImageIcon("hinhanh/undo1.png");

    ImageIcon huhu=new ImageIcon("hinhanh/iconkhachsan.jpg");
    JLabel lhuhu=new JLabel(huhu);

    ImageIcon qlchinh=new ImageIcon("hinhanh/ql.png");
    JLabel lql=new JLabel(qlchinh);
    JLabel lhoadon=new JLabel(iconlogout);

    JLabel lhinhanhnv=new JLabel(iconkh);
    JLabel lhadk=new JLabel(icondangky);
    JLabel lhaphong=new JLabel(icontimphong);
    JLabel lhahoadon=new JLabel(iconhoadon);

    JButton bthoat=new JButton("Thoát");

    JLabel lleft=new JLabel(left);



    ImageIcon iconnnen=new ImageIcon("hinhanh/nen.png");
    JLabel lnen=new JLabel(iconnnen);

    Statement stm;
    ResultSet rs;

    JLabel lchao=new JLabel("Chương Trình Quản Lý Khách Sạn");


    JLabel liconkhn1=new JLabel("Khách Hàng");
    JLabel licondkn1=new JLabel("Đăng Ký ");
    JLabel liconpn1=new JLabel("Tìm Phòng");
    JLabel liconhdn1=new JLabel("Hóa Đơn");

    GiaoDien gd=new GiaoDien("PHẦN MỀM QUẢN LÝ KHÁCH SẠN");
    String tk=gd.tkdnnv;
    public GiaoDienNhanVien(String title)
    {
        super(title);

        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(p1);
        p1.setBounds(0, 0, 200, 700);
        p1.setBackground(Color.GRAY);
        this.p1();

        this.add(p2);
        p2.setBounds(200, 0, 790, 700);
        p2.setBackground(Color.LIGHT_GRAY);
        this.p2();

        liconkhn1.addMouseListener(this);
        licondkn1.addMouseListener(this);
        liconpn1.addMouseListener(this);
        liconhdn1.addMouseListener(this);
        lql.addMouseListener(this);
        lql.setVisible(false);
    }
    public void p1()
    {
        p1.setLayout(null);
        p1.add(lhinhanhnv);
        liconkh.setBounds(0, 0, 200, 100);

        JLabel l1=new JLabel("Xin Chào :");
        p1.add(l1);
        l1.setBounds(10, 100, 100, 50);
        JLabel l2=new JLabel();
        l2.setText(tk);
        p1.add(l2);
        l2.setBounds(100, 100, 100, 50);
        p1.add(liconkh);
        lhinhanhnv.setBounds(0, 200, 200, 50);

        p1.add(lhadk);
        lhadk.setBounds(0, 270, 200, 50);
        //  p1.add(liconthemkh);
        // liconthemkh.setBounds(0, 260, 200, 50);

        p1.add(lhaphong);
        lhaphong.setBounds(0, 340, 200, 50);
        // p1.add(lPhong);
        // lPhong.setBounds(0, 410, 200, 50);

        p1.add(lhahoadon);
        lhahoadon.setBounds(0, 410, 200, 50);

        p1.add(lhoadon);
        lhoadon.setBounds(0, 590, 200, 80);
        p1.add(lql);
        lql.setBounds(0, 480, 200, 50);
        //p1.add(bthoat);
        //bthoat.setBounds(0, 610, 200, 50);

        p1.add(lleft);
        lleft.setBounds(0, 0, 200, 700);


        lhinhanhnv.addMouseListener(this);
        lhadk.addMouseListener(this);
        lhaphong.addMouseListener(this);
        lhahoadon.addMouseListener(this);
        bthoat.addMouseListener(this);
        bthoat.addActionListener(this);
        lhoadon.addMouseListener(this);
    }
    public void p2()
    {
        p2.setLayout(null);

        p2.add(lchao);
        lchao.setBounds(100, 0, 700, 50);
        lchao.setFont(new Font("SansSerif", Font.BOLD, 20));

        p2.add(liconkhn1);
        liconkhn1.setBounds(70, 50, 100, 50);



        p2.add(licondkn1);
        licondkn1.setBounds(230, 50, 100, 50);


        p2.add(liconpn1);
        liconpn1.setBounds(470, 50, 100, 50);


        p2.add(liconhdn1);
        liconhdn1.setBounds(620, 50, 100, 50);

        p2.add(lhuhu);
        lhuhu.setBounds(100, 200, 600, 450);

        p2.add(lnen);
        lnen.setBounds(0, 0, 800, 700);
    }
    public static void main(String[]args)
    {
        GiaoDienNhanVien gdnv=new GiaoDienNhanVien("NHÂN VIÊN");
        gdnv.setVisible(true);
        //gdnv.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bthoat)

        {

            GiaoDien gd=new GiaoDien("PHẦN MỀM QUẢN LÝ KHÁCH SẠN");
            gd.setVisible(true);
            gd.setLocationRelativeTo(null);
            this.setVisible(false);
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource()==lhinhanhnv)
        {
            KhachHang kh=new KhachHang("KHÁCH HÀNG");
            kh.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==lhadk)
        {
            Dangky dk=new Dangky("NHÂN VIÊN");
            dk.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==lhaphong)
        {
            TimPhong tp=new TimPhong("NHÂN VIÊN");
            tp.setVisible(true);
            tp.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        else if(e.getSource()==lhahoadon)
        {
            HoaDon hd=new HoaDon("HÓA ĐƠN");
            hd.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==lhoadon)
        {
            GiaoDien gd=new GiaoDien("PHẦN MỀM QUẢN LÝ KHÁCH SẠN");
            gd.setVisible(true);
            gd.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        else if(e.getSource()==liconkhn1)
        {
            KhachHang kh=new KhachHang("NHÂN VIÊN");
            kh.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==liconpn1)
        {
            TimPhong tp=new TimPhong("TÌM PHÒNG");
            tp.setVisible(true);
            tp.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        else if(e.getSource()==licondkn1)
        {
            Dangky dk=new Dangky("NHÂN VIÊN");
            dk.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==liconhdn1)
        {
            HoaDon hd=new HoaDon("HÓA ĐƠN");
            hd.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==lql)
        {
            GiaoDienNhanVien gdnv=new GiaoDienNhanVien("NHÂN VIÊN");
            gdnv.setVisible(true);
            this.setVisible(false);
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==lhinhanhnv)
        {
            lhinhanhnv.setBounds(0, 210, 200, 50);
            lhinhanhnv.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if(e.getSource()==lhadk)
        {
            lhadk.setBounds(0, 280, 200, 50);
            lhadk.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if(e.getSource()==lhaphong)
        {
            lhaphong.setBounds(0, 350, 200, 50);
            lhaphong.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if(e.getSource()==lhahoadon)
        {
            lhahoadon.setBounds(0, 420, 200, 50);
            lhahoadon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if(e.getSource()==bthoat)
        {
            bthoat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if(e.getSource()==lhoadon)
        {
            lhoadon.setBounds(0, 600, 200, 80);
            lhoadon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if(e.getSource()==liconkhn1)
        {
            liconkhn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            liconkhn1.setForeground(Color.red);
        }
        else if(e.getSource()==liconpn1)
        {
            liconpn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            liconpn1.setForeground(Color.red);
        }
        else if(e.getSource()==licondkn1)
        {
            licondkn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            licondkn1.setForeground(Color.red);
        }
        else if(e.getSource()==liconhdn1)
        {
            liconhdn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            liconhdn1.setForeground(Color.red);
        }
        else if(e.getSource()==lql)
        {
            lql.setBounds(0, 490, 200, 50);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        lhinhanhnv.setBounds(0, 200, 200, 50);
        lhadk.setBounds(0, 270, 200, 50);
        lhaphong.setBounds(0, 340, 200, 50);
        lhahoadon.setBounds(0, 410, 200, 50);
        lhoadon.setBounds(0, 590, 200, 80);

        liconkhn1.setForeground(Color.BLACK);
        licondkn1.setForeground(Color.BLACK);
        liconpn1.setForeground(Color.BLACK);
        liconhdn1.setForeground(Color.BLACK);

        lql.setBounds(0, 480, 200, 50);
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
