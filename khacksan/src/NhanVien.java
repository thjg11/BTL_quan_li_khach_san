

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
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
import javax.swing.table.TableModel;
public class NhanVien extends QuanTri implements MouseListener,ActionListener{

    private static final long serialVersionUID = 1L;
    ImageIcon iconnv=new ImageIcon("hinhanh/btreset.jpg");

    JButton b1=new JButton(iconnv);
    JButton b2=new JButton("Thêm  Nhân Viên");
    JButton b3=new JButton("Xóa Nhân Viên");
    JButton b4=new JButton("Thay Đổi Thông tin");
    JButton b5=new JButton("Tìm Nhân Viên");

    JLabel lmnv=new JLabel("Mã Nhân Viên");
    JLabel lht=new JLabel("Họ Tên");
    JLabel lcmnd=new JLabel("CMND");
    JLabel lngs=new JLabel("Ngày Sinh");
    JLabel lquequan=new JLabel("Quê Quán");
    JLabel lgt=new JLabel("Giới Tính");
    JLabel lsdt=new JLabel("SDT");
    JLabel lchucvu=new JLabel("Chức Vụ");

    JLabel lmnv1=new JLabel("Mã Nhân viên");
    JLabel lht1=new JLabel("Họ Tên");
    JLabel lcmnd1=new JLabel("CMND");
    JLabel lngs1=new JLabel("Ngày Sinh");
    JLabel lquequan1=new JLabel("Quê Quán");
    JLabel lgt1=new JLabel("Giới Tính");
    JLabel lsdt1=new JLabel("SDT");
    JLabel lchucvu1=new JLabel("Chức Vụ");

    JTextField tmnv1=new JTextField(20);
    JTextField tht1=new JTextField(20);
    JTextField tcmnd1=new JTextField(20);
    JTextField tngs1=new JTextField(20);
    JTextField tquequan1=new JTextField(20);
    JTextField tgt1=new JTextField(20);
    JTextField tsdt1=new JTextField(20);
    JTextField tchucvu1=new JTextField(20);


    JTextField tmnv=new JTextField(20);
    JTextField tht=new JTextField(20);
    JTextField tcmnd=new JTextField(20);
    JTextField tngs=new JTextField(20);
    JTextField tquequan=new JTextField(20);
    JTextField tgt=new JTextField(20);
    JTextField tsdt=new JTextField(20);
    JTextField tchucvu=new JTextField(20);

    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JPanel pttnv=new JPanel();
    JPanel pthemnhanvien=new JPanel();

    ImageIcon iconnnen=new ImageIcon("hinhanh/nen.png");
    JLabel lnen=new JLabel(iconnnen);

    JButton bluuthemnhanvien=new JButton("Thêm Nhân Viên Mới");
    JButton clearbutton=new JButton("Clear");
    JButton luulai=new JButton("LƯU LẠI");
    JButton reselt=new JButton("Làm Lại");

    JButton xoanhanvien=new JButton("Xóa Nhân Viên");

    JTable tb;
    @SuppressWarnings("rawtypes")
    Vector Row;
    DefaultTableModel dtm;
    Vector<String> rowtitle=new Vector<String>();
    @SuppressWarnings("rawtypes")
    Vector vdongdachon=new Vector();

    JLabel Ltimkiemnhanvien=new JLabel("Tìm Kiếm Nhân viên ");
    JLabel ltknv=new JLabel("Nhập Họ Tên nhân viên");
    JTextField ttimkiem=new JTextField(20);
    JButton btimkiem=new JButton("Tìm Kiếm");
    public NhanVien(String title)
    {
        super(title);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(p3);
        p2.setVisible(false);
        p3.setBounds(200, 0, 800, 55);
        p3.setBackground(Color.LIGHT_GRAY);
        this.p3();
        this.add(p4);
        p4.setBounds(200, 60, 800, 300);
        p4.setBackground(Color.lightGray);
        this.p4();


        this.add(pttnv);
        pttnv.setBounds(200, 365, 790, 200);
        this.thongtinnhanvien();
        this.add(pthemnhanvien);
        pthemnhanvien.setBounds(200, 60, 800, 550);
        pthemnhanvien.setVisible(false);
        this.themnhanvien();
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index=tb.getSelectedRow();
                tmnv.setText(String.valueOf(dtm.getValueAt(index, 0)));
                tht.setText(String.valueOf(dtm.getValueAt(index, 1)));
                tcmnd.setText(String.valueOf(dtm.getValueAt(index, 2)));
                tngs.setText(String.valueOf(dtm.getValueAt(index, 3)));
                tquequan.setText(String.valueOf(dtm.getValueAt(index, 4)));
                tgt.setText(String.valueOf(dtm.getValueAt(index, 5)));
                tsdt.setText(String.valueOf(dtm.getValueAt(index, 6)));
                tchucvu.setText(String.valueOf(dtm.getValueAt(index, 7)));
            }

        });

        luulai.setVisible(false);
        reselt.setVisible(false);
        luulai.addActionListener(this);
        reselt.addActionListener(this);
        xoanhanvien.setVisible(false);
        xoanhanvien.addActionListener(this);

        Ltimkiemnhanvien.setVisible(false);
        ltknv.setVisible(false);
        ttimkiem.setVisible(false);
        btimkiem.setVisible(false);
        btimkiem.addActionListener(this);
    }
    public void p3()
    {
        p3.setLayout(null);
        p3.add(b1);
        b1.setBounds(0, 0, 150, 50);
        p3.add(b2);
        b2.setBounds(155, 0, 150, 50);
        p3.add(b3);
        b3.setBounds(310, 0, 150, 50);
        p3.add(b4);
        b4.setBounds(465, 0, 150, 50);
        p3.add(b5);
        b5.setBounds(620, 0, 165, 50);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void p4()
    {

        rowtitle.add("Mã Nhân Viên");
        rowtitle.add("Họ Tên");
        rowtitle.add("CMND");
        rowtitle.add("Ngày Sinh");
        rowtitle.add("Quê Quán");
        rowtitle.add("Giới Tính");
        rowtitle.add("SDT");
        rowtitle.add("Chức Vụ");
        dtm=new DefaultTableModel(rowtitle,0);
        tb=new JTable(dtm);
        p4.setLayout(null);
        JScrollPane scrollTable = new JScrollPane(tb);
        scrollTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setSize(780, 300);
        p4.add(scrollTable);
        KetNoi kn=new KetNoi();
        tb.setModel(new DefaultTableModel(Row, rowtitle));

        try
        {
            String sql="select * from nhanvien";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                Row=new Vector();
                Row.addElement(rs.getString("manv").trim());
                Row.addElement(rs.getString("hoten").trim());
                Row.addElement(rs.getInt("cmnd"));
                Row.addElement(rs.getString("ngaysinh").trim());
                Row.addElement(rs.getString("quequan").trim());
                Row.addElement(rs.getString("gioitinh").trim());
                Row.addElement(rs.getInt("sdt"));
                Row.addElement(rs.getString("chucvu").trim());
                dtm.addRow(Row);

            }

            tb.setModel(dtm);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Khong the tai du lieu!");
            e.printStackTrace();
        }


    }
    public void thongtinnhanvien()
    {
        pttnv.setLayout(null);

        pttnv.add(lmnv);
        lmnv.setBounds(10, 10, 100, 50);
        pttnv.add(tmnv);
        tmnv.setBounds(100, 15, 200, 30);

        pttnv.add(lht);
        lht.setBounds(350, 10, 100, 50);
        pttnv.add(tht);
        tht.setBounds(450, 15, 200, 30);

        pttnv.add(lcmnd);
        lcmnd.setBounds(10, 50, 100, 50);
        pttnv.add(tcmnd);
        tcmnd.setBounds(100, 55, 200, 30);

        pttnv.add(lngs);
        lngs.setBounds(350, 50, 100, 50);
        pttnv.add(tngs);
        tngs.setBounds(450, 55, 200, 30);

        pttnv.add(lquequan);
        lquequan.setBounds(10, 105, 100, 50);
        pttnv.add(tquequan);
        tquequan.setBounds(100, 110, 200, 30);

        pttnv.add(lgt);
        lgt.setBounds(350, 105, 100, 50);
        pttnv.add(tgt);
        tgt.setBounds(450, 110, 200, 30);

        pttnv.add(lsdt);
        lsdt.setBounds(10, 150, 100, 50);
        pttnv.add(tsdt);
        tsdt.setBounds(100	, 155, 200,30);

        pttnv.add(lchucvu);
        lchucvu.setBounds(350, 150, 100, 50);
        pttnv.add(tchucvu);
        tchucvu.setBounds(450, 155, 200, 30);

        pttnv.add(luulai);
        luulai.setBounds(680, 50, 100, 30);
        pttnv.add(reselt);
        reselt.setBounds(680, 120, 100, 30);

        pttnv.add(xoanhanvien);
        xoanhanvien.setBounds(680, 100, 100, 30);

        pttnv.add(Ltimkiemnhanvien);
        Ltimkiemnhanvien.setBounds(250, 10, 300, 50);
        pttnv.add(ltknv);
        ltknv.setBounds(100, 50, 200, 50);
        pttnv.add(ttimkiem);
        ttimkiem.setBounds(350, 60, 200, 30);
        ttimkiem.setBorder(new BevelBorder(BevelBorder.LOWERED));
        pttnv.add(btimkiem);
        btimkiem.setBounds(600, 60, 100, 30);

        tmnv.setEditable(false);
        tht.setEditable(false);
        tcmnd.setEditable(false);
        tngs.setEditable(false);
        tquequan.setEditable(false);
        tgt.setEditable(false);
        tchucvu.setEditable(false);
        tsdt.setEditable(false);

        pttnv.add(lnen);
        lnen.setBounds(0, 0, 790, 200);
    }
    public void themnhanvien()
    {

        pthemnhanvien.setLayout(null);
        pthemnhanvien.add(lmnv1);
        lmnv1.setBounds(100, 40, 100, 50);
        pthemnhanvien.add(tmnv1);
        tmnv1.setBounds(200, 50, 200, 30);
        pthemnhanvien.add(lht1);
        lht1.setBounds(100, 80, 100,50);
        pthemnhanvien.add(tht1);
        tht1.setBounds(200, 90, 200, 30);
        pthemnhanvien.add(lcmnd1);
        lcmnd1.setBounds(100, 120, 100, 50);

        pthemnhanvien.add(tcmnd1);
        tcmnd1.setBounds(200, 130, 200, 30);
        pthemnhanvien.add(lngs1);
        lngs1.setBounds(100, 170, 100, 50);
        pthemnhanvien.add(tngs1);
        tngs1.setBounds(200, 180, 200, 30);

        JLabel lngsinh=new JLabel("Vd :1987-07-08 (yyyy-mm-dd)");
        pthemnhanvien.add(lngsinh);
        lngsinh.setBounds(450, 170, 200, 50);

        pthemnhanvien.add(lquequan1);
        lquequan1.setBounds(100, 220, 100, 50);
        pthemnhanvien.add(tquequan1);
        tquequan1.setBounds(200, 230, 200, 30);
        pthemnhanvien.add(lgt1);
        lgt1.setBounds(100, 260, 100, 50);
        pthemnhanvien.add(tgt1);
        tgt1.setBounds(200, 270, 200, 30);
        pthemnhanvien.add(lsdt1);
        lsdt1.setBounds(100, 300, 100, 50);
        pthemnhanvien.add(tsdt1);
        tsdt1.setBounds(200, 320, 200, 30);
        pthemnhanvien.add(lchucvu1);
        lchucvu1.setBounds(100, 360, 100, 50);
        pthemnhanvien.add(tchucvu1);
        tchucvu1.setBounds(200	, 370, 200, 30);

        pthemnhanvien.add(bluuthemnhanvien);
        bluuthemnhanvien.setBounds(150, 430, 300, 30);

        pthemnhanvien.add(clearbutton);
        clearbutton.setBounds(150, 470, 300, 30);


        pthemnhanvien.add(lnen);
        lnen.setBounds(0, 0, 800, 500);

        bluuthemnhanvien.addActionListener(this);
        clearbutton.addActionListener(this);


    }
    public void xoanhanvien()
    {
        KetNoi kn=new KetNoi();
        String mnv=tmnv.getText();
        String sql= "DELETE from nhanvien where manhanvien='"+mnv+"'";
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

    public void luunhanvien()
    {
        KetNoi kn=new KetNoi();
        String mnv=tmnv1.getText();
        String ht=tht1.getText();
        String cmnd=tcmnd1.getText();
        String ngs=tngs1.getText();
        String qq=tquequan1.getText();
        String gt=tgt1.getText();
        String sdt=tsdt1.getText();
        String chucvu=tchucvu1.getText();
        String sql1="INSERT INTO nhanvien(manhanvien,hoten,cmnd,ngaysinh,quequan,gioitinh,sdt,chucvu) values('"+mnv+"',N'"+ht+"',"+cmnd+",'"+ngs+"',N'"+qq+"',N'"+gt+"',"+sdt+",N'"+chucvu+"')";

        try{


            stm=kn.con.createStatement();

            stm.executeUpdate(sql1);

            JOptionPane.showMessageDialog(null,"Bạn Đã Thêm Thành Công!","Thông Báo", JOptionPane.INFORMATION_MESSAGE);

            kn.con.close();

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Bạn Đã Thêm Thất Bại");
        }

    }
    public void thaydoithongtin()
    {
        KetNoi kn=new KetNoi();
        String mnv=tmnv.getText().trim();
        String ht=tht.getText().trim();
        String cmnd=tcmnd.getText();
        String ngs=tngs.getText();
        String qq=tquequan.getText().trim();
        String gt=tgt.getText().trim();
        String sdt=tsdt.getText();
        String chucvu=tchucvu.getText().trim();

        try{
            String sqll="UPDATE nhanvien set manhanvien='"+mnv+"',HoTen=N'"+ht+"',CMND="+cmnd+",ngaysinh='"+ngs+"',QueQuan=N'"+qq+"',Gioitinh=N'"+gt+"',SDT="+sdt+",chucvu=N'"+chucvu+"' where manhanvien='"+mnv+"' ";
            stm=kn.con.createStatement();
            stm.executeUpdate(sqll);
            JOptionPane.showMessageDialog(null, "Chúc Mừng Bạn Sửa Thành Công");


            kn.con.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Bạn Đã Cập nhật thành Công","Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void timkiemnhanvien()
    {
        KetNoi kn=new KetNoi();
        try{

            String sql="SELECT manhanvien,HoTen,CMND,ngaysinh,QueQuan,Gioitinh,SDT,chucvu from nhanvien where nhanvien.HoTen like '"+ttimkiem.getText().trim()+"%'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            dtm.getDataVector().removeAllElements();
            while(rs.next())
            {
                Row=new Vector();
                Row.addElement(rs.getString(1));
                Row.addElement(rs.getString(2));
                Row.addElement(rs.getInt(3));
                Row.addElement(rs.getDate(4));
                Row.addElement(rs.getString(5));
                Row.addElement(rs.getString(6));
                Row.addElement(rs.getInt(7));
                Row.addElement(rs.getString(8));
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
            NhanVien nv=new NhanVien("NHÂN VIÊN");
            nv.setVisible(true);

            this.setVisible(false);
            tmnv.setEditable(false);
            tht.setEditable(false);
            tcmnd.setEditable(false);
            tngs.setEditable(false);
            tquequan.setEditable(false);
            tgt.setEditable(false);
            tchucvu.setEditable(false);
            tsdt.setEditable(false);
        }
        else if(e.getSource()==b2)
        {
            pttnv.setVisible(false);
            pthemnhanvien.setVisible(true);
            p4.setVisible(false);

        }
        else if(e.getSource()==bluuthemnhanvien)
        {
            if(tmnv1.getText().length()<=0 || tht1.getText().length()<=0)
            {
                JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Mã Nhân Viên hoặc Họ Tên Nhân Viên");


            }
            else
            {
                try {
                    int i=JOptionPane.showConfirmDialog(this,"bạn co muốn thêm không","Thông Báo",JOptionPane.OK_CANCEL_OPTION);
                    if(i==0)
                    {
                        luunhanvien();
                        tmnv1.setText("");
                        tht1.setText("");
                        tcmnd1.setText("");
                        tngs1.setText("");
                        tquequan1.setText("");
                        tgt1.setText("");
                        tsdt1.setText("");
                        tchucvu1.setText("");

                    }
                    else
                    {

                    }

                }catch(Exception b)
                {

                }
            }
        }
        else if(e.getSource()== clearbutton)
        {
            tmnv1.setText("");
            tht1.setText("");
            tcmnd1.setText("");
            tngs1.setText("");
            tquequan1.setText("");
            tgt1.setText("");
            tsdt1.setText("");
            tchucvu1.setText("");

        }
        else if(e.getSource()==b3)
        {
            pthemnhanvien.setVisible(false);
            p4.setVisible(true);
            pttnv.setVisible(true);
            xoanhanvien.setVisible(true);
            luulai.setVisible(false);
            reselt.setVisible(false);

            tmnv.setEditable(false);
            tht.setEditable(false);
            tcmnd.setEditable(false);
            tngs.setEditable(false);
            tquequan.setEditable(false);
            tgt.setEditable(false);
            tchucvu.setEditable(false);
            tsdt.setEditable(false);

            lmnv.setVisible(true);
            lht.setVisible(true);
            lcmnd.setVisible(true);
            lngs.setVisible(true);
            lquequan.setVisible(true);
            lgt.setVisible(true);
            lsdt.setVisible(true);
            lchucvu.setVisible(true);
            tmnv.setVisible(true);
            tht.setVisible(true);
            tcmnd.setVisible(true);
            tngs.setVisible(true);
            tquequan.setVisible(true);
            tgt.setVisible(true);
            tsdt.setVisible(true);
            tchucvu.setVisible(true);



            Ltimkiemnhanvien.setVisible(false);
            ltknv.setVisible(false);
            ttimkiem.setVisible(false);
            btimkiem.setVisible(false);
        }
        else if(e.getSource()==b4)
        {
            pttnv.setVisible(true);
            p4.setVisible(true);
            luulai.setVisible(true);
            reselt.setVisible(true);
            pthemnhanvien.setVisible(false);
            tmnv.setEditable(true);
            tht.setEditable(true);
            tcmnd.setEditable(true);
            tngs.setEditable(true);
            tquequan.setEditable(true);
            tgt.setEditable(true);
            tchucvu.setEditable(true);
            tsdt.setEditable(true);

            lmnv.setVisible(true);
            lht.setVisible(true);
            lcmnd.setVisible(true);
            lngs.setVisible(true);
            lquequan.setVisible(true);
            lgt.setVisible(true);
            lsdt.setVisible(true);
            lchucvu.setVisible(true);
            tmnv.setVisible(true);
            tht.setVisible(true);
            tcmnd.setVisible(true);
            tngs.setVisible(true);
            tquequan.setVisible(true);
            tgt.setVisible(true);
            tsdt.setVisible(true);
            tchucvu.setVisible(true);




            Ltimkiemnhanvien.setVisible(false);
            ltknv.setVisible(false);
            ttimkiem.setVisible(false);
            xoanhanvien.setVisible(false);
            btimkiem.setVisible(false);
        }
        else if(e.getSource()==luulai)
        {
            int dongdachon=tb.getSelectedRow();
            if(dongdachon==-1)
            {
                JOptionPane.showMessageDialog(rootPane,
                        "Bạn chưa chọn dòng cần sữa");
            }
            else
            {
                int i=JOptionPane.showConfirmDialog(this,"bạn co muốn sữa không","Thông Báo",JOptionPane.OK_CANCEL_OPTION);
                if(i==0)
                {
                    thaydoithongtin();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "bạn Da không luu lại");
                }
            }
        }
        else if(e.getSource()==xoanhanvien)
        {
            int dongdachon=tb.getSelectedRow();
            if(dongdachon==-1)
            {
                JOptionPane.showMessageDialog(rootPane,
                        "Bạn chưa chọn dòng cần xóa");
            }
            else
            {
                int i=JOptionPane.showConfirmDialog(this,"bạn co muốn xóa nhân viên này không ?","Thông Báo",JOptionPane.OK_CANCEL_OPTION);
                if(i==0)
                {
                    xoanhanvien();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "bạn Da không xoa");
                }
            }
        }
        else if(e.getSource()==b5)
        {

            Ltimkiemnhanvien.setVisible(true);

            ttimkiem.setVisible(true);
            pttnv.setVisible(true);
            pthemnhanvien.setVisible(false);
            ltknv.setVisible(true);

            lmnv.setVisible(false);
            lht.setVisible(false);
            lcmnd.setVisible(false);
            lngs.setVisible(false);
            lquequan.setVisible(false);
            lgt.setVisible(false);
            lsdt.setVisible(false);
            lchucvu.setVisible(false);
            tmnv.setVisible(false);
            tht.setVisible(false);
            tcmnd.setVisible(false);
            tngs.setVisible(false);
            tquequan.setVisible(false);
            tgt.setVisible(false);
            tsdt.setVisible(false);
            tchucvu.setVisible(false);

            luulai.setVisible(false);
            reselt.setVisible(false);
            btimkiem.setVisible(true);
            p4.setVisible(true);

        }
        else if(e.getSource()==btimkiem)
        {
            if(ttimkiem.getText().length()<0)
            {
                JOptionPane.showMessageDialog(null, "Bạn chưa Nhập họ Tên nhân Viên", "Thông Báo",JOptionPane.ERROR);
            }
            else
            {
                timkiemnhanvien();
            }
        }
    }

}

