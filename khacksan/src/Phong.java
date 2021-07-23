

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class Phong extends QuanTri implements MouseListener,ActionListener {

    private static final long serialVersionUID = 1L;
    JPanel head=new JPanel();
    JPanel Thongtinphong=new JPanel();
    JPanel pantable=new JPanel();

    JButton b1=new JButton("Thông Tin Phòng");
    JButton b2=new JButton("Tạo Phòng Mới");
    JButton b3=new JButton("Xóa Phòng");
    JButton b4=new JButton("Thay Đổi Thông tin Phòng");
    JButton b5=new JButton("Tìm Phòng");

    JButton luuphong=new JButton("Thêm Phòng");
    JButton bxoa=new JButton("Làm Lại");

    JButton thaydoi=new JButton("Thay Đổi");
    JButton timkiem=new JButton("Tìm Kiếm");

    JLabel lmphong=new JLabel("Mã Phòng");
    JLabel lsophong=new JLabel("Số Phòng");
    JLabel lmaloaiphong=new JLabel("Mã Loại Phòng");
    JLabel ltinhtrang=new JLabel("Tình Trạng");
    JLabel ldongia=new JLabel("Đơn Giá");

    JTextField tmaphong=new JTextField(20);
    JTextField tsophong=new JTextField(20);
    JTextField tmaloaiphong=new JTextField(20);
    JTextField ttinhtrang=new JTextField(20);
    JTextField tdongia=new JTextField(20);

    JTextField tnhapmaphong=new JTextField(20);

    JLabel ltimkiemphong=new JLabel("Tìm Kiếm Thông Tin Phòng");
    JLabel lnhapmaphong=new JLabel("Nhập Mã Phòng");
    JLabel lchucvu=new JLabel("Chức Vụ");

    JTable tb;
    @SuppressWarnings("rawtypes")
    Vector Row;
    DefaultTableModel dtm;
    Vector<String> rowtitle=new Vector<String>();

    public Phong(String title)
    {
        super(title);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(head);
        this.setResizable(false);
        p2.setVisible(false);
        head.setBounds(200, 0, 800, 50);
        this.add(Thongtinphong);
        Thongtinphong.setBounds(200, 300, 800, 300);
        Thongtinphong.setBackground(Color.LIGHT_GRAY);

        this.head();

        this.add(pantable);
        pantable.setBounds(200, 50, 800, 250);

        this.thongtinphong();

        this.loadtable();
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index=tb.getSelectedRow();
                tmaphong.setText(String.valueOf(dtm.getValueAt(index, 0)));
                tsophong.setText(String.valueOf(dtm.getValueAt(index, 1)));
                tmaloaiphong.setText(String.valueOf(dtm.getValueAt(index, 2)));
                ttinhtrang.setText(String.valueOf(dtm.getValueAt(index, 3)));
                tdongia.setText(String.valueOf(dtm.getValueAt(index, 4)));

            }

        });

        luuphong.setVisible(false);
        bxoa.setVisible(false);
        thaydoi.setVisible(false);
        thaydoi.addActionListener(this);

        ltimkiemphong.setVisible(false);
        lnhapmaphong.setVisible(false);
        tnhapmaphong.setVisible(false);
        timkiem.setVisible(false);

        timkiem.addActionListener(this);
    }
    public void head()
    {
        head.setLayout(null);
        head.add(b1);
        b1.setBounds(0, 0, 150, 50);
        head.add(b2);
        b2.setBounds(155, 0, 150, 50);
        head.add(b3);
        b3.setBounds(310, 0, 150, 50);
        head.add(b4);
        b4.setBounds(465, 0, 150, 50);
        head.add(b5);
        b5.setBounds(620, 0, 165, 50);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        luuphong.addActionListener(this);

    }
    public void thongtinphong()
    {
        Thongtinphong.setLayout(null);
        Thongtinphong.add(lmphong);
        lmphong.setBounds(50, 20, 100, 50);
        Thongtinphong.add(tmaphong);
        tmaphong.setBounds(200, 30, 200, 30);

        Thongtinphong.add(lsophong);
        lsophong.setBounds(50, 70, 100, 50);
        Thongtinphong.add(tsophong);
        tsophong.setBounds(200, 80, 200, 30);

        Thongtinphong.add(lmaloaiphong);
        lmaloaiphong.setBounds(50, 120, 100, 50);
        Thongtinphong.add(tmaloaiphong);
        tmaloaiphong.setBounds(200, 130, 200, 30);

        Thongtinphong.add(ltinhtrang);
        ltinhtrang.setBounds(50, 170, 100, 50);
        Thongtinphong.add(ttinhtrang);
        ttinhtrang.setBounds(200, 180, 200, 30);

        Thongtinphong.add(ldongia);
        ldongia.setBounds(50, 210, 100, 50);
        Thongtinphong.add(tdongia);
        tdongia.setBounds(200, 220, 200, 30);

        Thongtinphong.add(luuphong);
        luuphong.setBounds(450, 50, 150, 30);
        Thongtinphong.add(bxoa);
        bxoa.setBounds(450, 150, 150, 30);
        Thongtinphong.add(thaydoi);
        thaydoi.setBounds(450, 50, 150, 30);

        Thongtinphong.add(ltimkiemphong);
        ltimkiemphong.setBounds(300, 10, 400, 50);
        ltimkiemphong.setFont(new Font("SansSerif", Font.BOLD, 20));

        Thongtinphong.add(lnhapmaphong);
        lnhapmaphong.setBounds(100, 100, 100, 50);

        Thongtinphong.add(tnhapmaphong);
        tnhapmaphong.setBounds(200, 110, 200, 30);
        tnhapmaphong.setBorder(new BevelBorder(BevelBorder.LOWERED));
        Thongtinphong.add(timkiem);
        timkiem.setBounds(450, 110, 100, 30);

        Thongtinphong.add(lnen);
        lnen.setBounds(0, 0, 800, 300);



        tmaphong.setEditable(false);
        tsophong.setEditable(false);
        tmaloaiphong.setEditable(false);
        ttinhtrang.setEditable(false);
        tdongia.setEditable(false);

    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void loadtable()
    {
        rowtitle.add("Mã phòng");
        rowtitle.add("Số Phòng");
        rowtitle.add("Mã Loại Phòng");
        rowtitle.add("Tình Trạng");
        rowtitle.add("Đơn Giá");
        dtm=new DefaultTableModel(rowtitle,0);

        tb=new JTable(dtm);


        pantable.setLayout(null);
        JScrollPane scrollTable = new JScrollPane(tb);
        scrollTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setSize(785, 250);
        pantable.add(scrollTable);

        KetNoi kn=new KetNoi();


        try
        {
            String sql="select * from phong";
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
    public void taophongmoi()
    {
        KetNoi kn=new KetNoi();
        String maphong=tmaphong.getText();
        String sophong=tsophong.getText();
        String maloaiphong=tmaloaiphong.getText();
        String tinhtrang=ttinhtrang.getText();
        String dongia=tdongia.getText();
        String sql="INSERT INTO Phong(maphong,sophong,maloaiphong,tinhtrang,dongia) values('"+maphong+"',"+sophong+",'"+maloaiphong+"','"+tinhtrang+"',"+dongia+")";
        try
        {
            stm=kn.con.createStatement();
            int rs=stm.executeUpdate(sql);
            if(rs>0)
            {
                JOptionPane.showMessageDialog(null, "Bạn Đã Tạo Phòng Mới Thành Công","Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Xin Lỗi ","Thông Báo", JOptionPane.ERROR_MESSAGE);
            }

            kn.con.close();
            stm.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Xin Lỗi kết nối thật bại ","Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void xoaphong()
    {
        KetNoi kn=new KetNoi();
        String maphong=tmaphong.getText();
        String sql= "DELETE from phong where maphong='"+maphong+"'";
        try
        {
            stm=kn.con.createStatement();
            int rs=stm.executeUpdate(sql);
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Thành công !", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa không thành công !", "Message", JOptionPane.ERROR_MESSAGE);

            }

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Có Vấn Đề Đang Xẩy ra");
        }
    }

    public void thaydoithongtinphong()
    {
        KetNoi kn=new KetNoi();
        String maphong=tmaphong.getText().trim();
        String sophong=tsophong.getText();
        String maloaiphong=tmaloaiphong.getText().trim();
        String tinhtrang=ttinhtrang.getText().trim();
        String dongia=tdongia.getText();
        String sql="UPDATE PHONG SET maphong='"+maphong+"', sophong="+sophong+",maloaiphong='"+maloaiphong+"',tinhtrang='"+tinhtrang+"',dongia='"+dongia+"' where maphong='"+maphong+"'";
        try
        {
            stm=kn.con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Thay Đổi Thành Công","thông báo",JOptionPane.INFORMATION_MESSAGE);

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Có Lỗi Xẩy Ra");
        }
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void timkiem()
    {
        KetNoi kn=new KetNoi();
        try{

            String sql="SELECT maphong,sophong,maloaiphong,tinhtrang,dongia from phong where phong.maphong like '"+tnhapmaphong.getText().trim()+"%'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            dtm.getDataVector().removeAllElements();
            while(rs.next())
            {
                Row=new Vector();
                Row.addElement(rs.getString(1));
                Row.addElement(rs.getInt(2));
                Row.addElement(rs.getString(3));
                Row.addElement(rs.getString(4));
                Row.addElement(rs.getFloat(5));
                dtm.addRow(Row);
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Có Lỗi Xẩy Ra", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1)
        {
            Phong p=new Phong("THÔNG TIN PHÒNG");
            p.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==b2)
        {
            tmaphong.setEditable(true);
            tsophong.setEditable(true);
            tmaloaiphong.setEditable(true);
            ttinhtrang.setEditable(true);
            tdongia.setEditable(true);
            ltimkiemphong.setVisible(false);
            timkiem.setVisible(false);

            luuphong.setVisible(true);
            bxoa.setVisible(true);
            thaydoi.setVisible(false);
            tnhapmaphong.setVisible(false);

            lmphong.setVisible(true);
            lsophong.setVisible(true);
            lmaloaiphong.setVisible(true);
            ltinhtrang.setVisible(true);
            ldongia.setVisible(true);
            tmaphong.setVisible(true);
            tsophong.setVisible(true);
            tmaloaiphong.setVisible(true);
            ttinhtrang.setVisible(true);
            tdongia.setVisible(true);

            ltimkiemphong.setVisible(false);
            lnhapmaphong.setVisible(false);
        }
        else if(e.getSource()==luuphong)
        {
            int i=JOptionPane.showConfirmDialog(this,"bạn co muốn thêm không","Thông Báo",JOptionPane.OK_CANCEL_OPTION);
            if(i==0)
            {
                taophongmoi();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Xin Loi");
            }
        }
        else if(e.getSource()==b3)
        {
            tmaphong.setEditable(false);
            tsophong.setEditable(false);
            tmaloaiphong.setEditable(false);
            ttinhtrang.setEditable(false);
            tdongia.setEditable(false);
            luuphong.setVisible(false);
            bxoa.setVisible(false);
            thaydoi.setVisible(false);
            ltimkiemphong.setVisible(false);
            tnhapmaphong.setVisible(false);
            timkiem.setVisible(false);

            int dongdachon=tb.getSelectedRow();
            if(dongdachon==-1)
            {
                JOptionPane.showMessageDialog(null, "Bạn Chưa chọn dòng để xóa", "Thông Báo",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                int i=JOptionPane.showConfirmDialog(this,"bạn co muốn xóa không","Thông Báo",JOptionPane.OK_CANCEL_OPTION);
                if(i==0)
                {
                    xoaphong();
                }
                else {

                }
            }


        }
        else if(e.getSource()==b4)
        {
            tmaphong.setEditable(true);
            tsophong.setEditable(true);
            tmaloaiphong.setEditable(true);
            ttinhtrang.setEditable(true);
            tdongia.setEditable(true);
            thaydoi.setVisible(true);
            ltimkiemphong.setVisible(false);
            lnhapmaphong.setVisible(false);
            tnhapmaphong.setVisible(false);
            timkiem.setVisible(false);

            luuphong.setVisible(false);
            bxoa.setVisible(true);

            lmphong.setVisible(true);
            lsophong.setVisible(true);
            lmaloaiphong.setVisible(true);
            ltinhtrang.setVisible(true);
            ldongia.setVisible(true);
            tmaphong.setVisible(true);
            tsophong.setVisible(true);
            tmaloaiphong.setVisible(true);
            ttinhtrang.setVisible(true);
            tdongia.setVisible(true);

        }
        else if(e.getSource()==thaydoi)
        {
            int dongdachon=tb.getSelectedRow();
            if(dongdachon==-1)
            {
                JOptionPane.showMessageDialog(null, "Bạn Chưa chọn dòng để thay đổi", "Thông Báo",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                int i=JOptionPane.showConfirmDialog(this,"bạn co muốn thay đổi không","Thông Báo",JOptionPane.OK_CANCEL_OPTION);
                if(i==0)
                {
                    thaydoithongtinphong();
                }
                else {

                }
            }
        }
        else if(e.getSource()==b5)
        {
            tmaphong.setVisible(false);
            tsophong.setVisible(false);
            tmaloaiphong.setVisible(false);
            ttinhtrang.setVisible(false);
            tdongia.setVisible(false);
            lmphong.setVisible(false);
            lsophong.setVisible(false);
            lmaloaiphong.setVisible(false);
            ltinhtrang.setVisible(false);
            ldongia.setVisible(false);
            tnhapmaphong.setVisible(true);

            ltimkiemphong.setVisible(true);
            lnhapmaphong.setVisible(true);
            timkiem.setVisible(true);
            luuphong.setVisible(false);
            thaydoi.setVisible(false);
            bxoa.setVisible(false);
        }
        else if(e.getSource()==timkiem)
        {
            timkiem();
        }

    }

}
