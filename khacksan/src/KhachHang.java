

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
@SuppressWarnings("serial")
public class KhachHang extends GiaoDienNhanVien implements ActionListener{

    JPanel pbutton=new JPanel();
    JPanel ptable=new JPanel();
    JPanel pthongtinkh=new JPanel();
    JPanel ptimkiem=new JPanel();

    JTable tb;
    @SuppressWarnings("rawtypes")
    Vector Row;
    DefaultTableModel dtm;

    JLabel lmkh=new JLabel("Mã khách hàng");
    JLabel lhoten=new JLabel("Họ Tên");
    JLabel lmd=new JLabel("Mã Đoàn");
    JLabel lcmnd=new JLabel("CMND");
    JLabel lngs=new JLabel("Ngày Sinh");
    JLabel lquequan=new JLabel("Quê Quán");
    JLabel lsdt=new JLabel("SDT");

    JTextField tmkh=new JTextField(20);
    JTextField thtkh=new JTextField(20);
    JTextField tmd=new JTextField(20);
    JTextField tcmnd=new JTextField(20);
    JTextField tngs=new JTextField(20);
    JTextField tquequan=new JTextField(20);
    JTextField tsdt=new JTextField(20);

    ImageIcon ip3=new ImageIcon("hinhanh/nen.png");
    JLabel lnen=new JLabel(ip3);
    ImageIcon ip2=new ImageIcon("hinhanh/nen.png");
    JLabel lnen2=new JLabel(ip2);
    ImageIcon ip1=new ImageIcon("hinhanh/nen.png");
    JLabel lnen1=new JLabel(ip1);

    JButton bload=new JButton("Load Dữ Liệu");
    JButton bsuakh=new JButton("Sữa Thông Tin");
    JButton bxoakh=new JButton("Xóa Thông Tin");
    JButton btimkiemkh=new JButton("Tìm Kiếm ");
    JButton bcapnhat=new JButton("Cập Nhật");

    JButton bluusua=new JButton("Lưu Lại");
    JButton blamlai=new JButton("Làm Lại");
    JButton bokxoa=new JButton("Xóa Khách Hàng");
    JButton btimkiem=new JButton("Tìm Kiếm");

    JLabel ltimkiem=new JLabel("Tìm Kiếm Thông Tin Khách Hàng");
    JLabel lhotenkh=new JLabel("Nhập Họ Tên Khách Hàng :");
    JTextField thtkhtk=new JTextField(20);

    JPanel capnhat=new JPanel();
    @SuppressWarnings("rawtypes")
    JComboBox combo=new JComboBox();

    JLabel lmkh1=new JLabel("Mã khách hàng");
    JLabel lhoten1=new JLabel("Họ Tên");
    JLabel lmd1=new JLabel("Mã Đoàn");
    JLabel lcmnd1=new JLabel("CMND");
    JLabel lngs1=new JLabel("Ngày Sinh");
    JLabel lquequan1=new JLabel("Quê Quán");
    JLabel lsdt1=new JLabel("SDT");
    JTextField tmkh1=new JTextField(20);
    JTextField thtkh1=new JTextField(20);
    JTextField tmd1=new JTextField(20);
    JFormattedTextField tcmnd1=new JFormattedTextField();
    JTextField tngs1=new JTextField(20);
    JTextField tquequan1=new JTextField(20);
    JTextField tsdt1=new JTextField(20);

    JButton bcap=new JButton("Lưu Lại");
    public KhachHang(String title) {

        super(title);
        p2.setVisible(false);
        this.setLayout(null);
        this.add(ptable);
        ptable.setBounds(200, 50, 785, 300);

        this.add(pbutton);
        pbutton.setBounds(200, 0, 785, 50);
        lql.setVisible(true);
        this.add(pthongtinkh);
        pthongtinkh.setBounds(200, 350, 785, 350);
        pthongtinkh.setBackground(Color.LIGHT_GRAY);

        this.add(capnhat);
        capnhat.setBounds(200, 350, 785, 350);
        capnhat.setBackground(Color.LIGHT_GRAY);
        capnhat.setVisible(false);
        this.add(ptimkiem);
        ptimkiem.setBounds(200, 350, 785, 350);
        ptimkiem.setVisible(false);
        ptimkiem.setBackground(Color.GRAY);
        this.loadata();
        this.Thongtin();
        // load du lieu len texfield
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index=tb.getSelectedRow();
                tmkh.setText(String.valueOf(dtm.getValueAt(index, 0)));
                thtkh.setText(String.valueOf(dtm.getValueAt(index, 1)));
                tmd.setText(String.valueOf(dtm.getValueAt(index, 2)));
                tcmnd.setText(String.valueOf(dtm.getValueAt(index, 3)));
                tngs.setText(String.valueOf(dtm.getValueAt(index, 4)));
                tquequan.setText(String.valueOf(dtm.getValueAt(index, 5)));
                tsdt.setText(String.valueOf(dtm.getValueAt(index, 6)));
            }

        });

        this.cacnut();
        this.ptimkiem();
        this.capnhat();
        bluusua.setVisible(false);
        blamlai.setVisible(false);
        bokxoa.setVisible(false);
        btimkiem.addActionListener(this);
        bcap.addActionListener(this);
        this.loadcombo();
        combo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                @SuppressWarnings("rawtypes")
                JComboBox jcmbType = (JComboBox) e.getSource();
                String cmbType = (String) jcmbType.getSelectedItem();
                tmkh1.setText(cmbType);
            }
        });

    }

    public void cacnut()
    {
        pbutton.setLayout(null);
        pbutton.setBackground(Color.GRAY);
        pbutton.add(bload);
        bload.setBounds(0, 0, 150, 50);
        bload.setFont(new Font("SansSerif", Font.ITALIC, 15));

        pbutton.add(bsuakh);
        bsuakh.setBounds(155, 0, 150, 50);
        bsuakh.setFont(new Font("SansSerif", Font.ITALIC, 15));
        pbutton.add(bcapnhat);
        bcapnhat.setBounds(310, 0, 150, 50);

        pbutton.add(bxoakh);
        bxoakh.setBounds(465, 0, 150, 50);
        bxoakh.setFont(new Font("SansSerif", Font.ITALIC, 15));

        pbutton.add(btimkiemkh);
        btimkiemkh.setBounds(620, 0, 165, 50);
        btimkiemkh.setFont(new Font("SansSerif", Font.ITALIC, 15));

        bload.addActionListener(this);
        bsuakh.addActionListener(this);
        bxoakh.addActionListener(this);
        btimkiemkh.addActionListener(this);
        bcapnhat.addActionListener(this);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void loadata()
    {
        @SuppressWarnings("rawtypes")
        Vector rowtitle=new Vector();
        rowtitle.add("Mã khách hàng");
        rowtitle.add("Họ Tên");
        rowtitle.add("Mã đoàn");
        rowtitle.add("Cmnd");
        rowtitle.add("Ngày Sinh");
        rowtitle.add("Quê Quán");
        rowtitle.add("SDT");
        dtm=new DefaultTableModel(rowtitle,0);

        tb=new JTable(dtm);
        ptable.setLayout(null);
        JScrollPane scrollTable = new JScrollPane(tb);
        scrollTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setSize(780, 300);
        ptable.add(scrollTable);

        KetNoi kn=new KetNoi();


        try
        {
            String sql="select * from khachhang";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                Row=new Vector();
                Row.addElement(rs.getString("makh").trim());
                Row.addElement(rs.getString("hoten").trim());
                Row.addElement(rs.getString("madoan").trim());
                Row.addElement(rs.getInt("cmnd"));
                Row.addElement(rs.getDate("ngaysinh"));
                Row.addElement(rs.getString("quequan").trim());
                Row.addElement(rs.getInt("sdt"));
                dtm.addRow(Row);

            }
            //tb.setModel(new DefaultTableModel(vtData, title));
            tb.setModel(dtm);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Khong tai du lieu!");
            e.printStackTrace();
        }
    }
    public void ptimkiem()
    {
        ptimkiem.setLayout(null);

        ptimkiem.add(ltimkiem);
        ltimkiem.setBounds(200, 20, 500, 50);
        ptimkiem.add(lhotenkh);
        lhotenkh.setBounds(100, 100, 200, 50);
        ptimkiem.add(thtkhtk);
        thtkhtk.setBounds(300, 110, 200, 30);
        ptimkiem.add(btimkiem);
        btimkiem.setBounds(550, 110, 150, 30);

        ptimkiem.add(lnen1);
        lnen1.setBounds(0, 0, 785, 350);
    }


    public void capnhat()
    {
        capnhat.setLayout(null);
        JLabel lchon=new JLabel("Bạn Chọn Mã Khách Hàng Từ Hóa Đơn :");
        capnhat.add(lchon);
        lchon.setBounds(100, 0, 300, 50);
        capnhat.add(combo);
        combo.setBounds(330, 10, 200, 30);

        capnhat.add(lmkh1);
        lmkh1.setBounds(50, 40, 100, 50);
        capnhat.add(tmkh1);
        tmkh1.setBounds(150, 50, 200, 30);

        capnhat.add(lhoten1);
        lhoten1.setBounds(50, 80, 100, 50);
        capnhat.add(thtkh1);
        thtkh1.setBounds(150, 90, 200, 30);

        capnhat.add(lmd1);
        lmd1.setBounds(50, 130, 100, 50);
        capnhat.add(tmd1);
        tmd1.setBounds(150, 140, 200, 30);

        capnhat.add(lcmnd1);
        lcmnd1.setBounds(50, 170, 100, 50);
        capnhat.add(tcmnd1);
        tcmnd1.setBounds(150, 180, 200, 30);
        tcmnd1.setColumns(9);
        capnhat.add(lngs1);
        lngs1.setBounds(400, 40, 100, 50);
        capnhat.add(tngs1);
        tngs1.setBounds(500, 50, 200, 30);

        capnhat.add(lquequan1);
        lquequan1.setBounds(400, 80, 100, 50);
        capnhat.add(tquequan1);
        tquequan1.setBounds(500, 90, 200, 30);

        capnhat.add(lsdt1);
        lsdt1.setBounds(400, 130, 100, 50);
        capnhat.add(tsdt1);
        tsdt1.setBounds(500, 140, 200, 30);

        capnhat.add(bcap);
        bcap.setBounds(200, 250, 100, 30);
//		capnhat.add(blamlai);
//		blamlai.setBounds(350, 250, 100, 30);
//		capnhat.add(bokxoa);
//		bokxoa.setBounds(200, 250, 200, 30);

        capnhat.add(lnen2);
        lnen2.setBounds(0, 0, 785, 350);
        tmkh1.setEditable(false);
        String comm=(String) combo.getSelectedItem();
        tmkh1.setText(comm);
    }

    @SuppressWarnings("unchecked")
    public void loadcombo()
    {
        KetNoi kn=new KetNoi();
        try {
            String sql="Select DISTINCT makh from chitiethoadon  ORDER BY MAKH DESC";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);


        } catch (SQLException e) {


            e.printStackTrace();
        }
        combo.addItem("- Select -");
        try{
            while(rs.next())
            {
                combo.addItem(rs.getString("makh"));
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi !!!!!!!");
        }
    }
    public void Thongtin()
    {
        pthongtinkh.setLayout(null);

        pthongtinkh.add(lmkh);
        lmkh.setBounds(50, 20, 100, 50);
        pthongtinkh.add(tmkh);
        tmkh.setBounds(150, 30, 200, 30);

        pthongtinkh.add(lhoten);
        lhoten.setBounds(50, 60, 100, 50);
        pthongtinkh.add(thtkh);
        thtkh.setBounds(150, 70, 200, 30);

        pthongtinkh.add(lmd);
        lmd.setBounds(50, 110, 100, 50);
        pthongtinkh.add(tmd);
        tmd.setBounds(150, 120, 200, 30);

        pthongtinkh.add(lcmnd);
        lcmnd.setBounds(50, 150, 100, 50);
        pthongtinkh.add(tcmnd);
        tcmnd.setBounds(150, 160, 200, 30);

        pthongtinkh.add(lngs);
        lngs.setBounds(400, 20, 100, 50);
        pthongtinkh.add(tngs);
        tngs.setBounds(500, 30, 200, 30);

        pthongtinkh.add(lquequan);
        lquequan.setBounds(400, 60, 100, 50);
        pthongtinkh.add(tquequan);
        tquequan.setBounds(500, 70, 200, 30);

        pthongtinkh.add(lsdt);
        lsdt.setBounds(400, 110, 100, 50);
        pthongtinkh.add(tsdt);
        tsdt.setBounds(500, 120, 200, 30);

        pthongtinkh.add(bluusua);
        bluusua.setBounds(200, 250, 100, 30);
        pthongtinkh.add(blamlai);
        blamlai.setBounds(350, 250, 100, 30);
        pthongtinkh.add(bokxoa);
        bokxoa.setBounds(200, 250, 200, 30);

        pthongtinkh.add(lnen);
        lnen.setBounds(0, 0, 785, 350);

        tmkh.setEditable(false);
        thtkh.setEditable(false);
        tmd.setEditable(false);
        tngs.setEditable(false);
        tquequan.setEditable(false);
        tsdt.setEditable(false);
        tcmnd.setEditable(false);

        bluusua.addActionListener(this);
        blamlai.addActionListener(this);
        bokxoa.addActionListener(this);
    }
    public void suathongtinkhachhang()
    {
        KetNoi kn=new KetNoi();
        String mkh=tmkh.getText().trim();
        String htkh=thtkh.getText().trim();
        String md=tmd.getText().trim();
        String cmnd=tcmnd.getText();
        String ns=tngs.getText();
        String qq=tquequan.getText().trim();
        String sdt=tsdt.getText();
        try{
            String sql="UPDATE KHACHHANG SET makhachhang='"+ mkh +"',hoten='" +htkh+ "', madoan='"+md+"', cmnd="+cmnd+",ngaysinh='"+ns+"',quequan='"+qq +"',sdt="+sdt+" where makhachhang='"+mkh+"'";
            stm=kn.con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Thành Công");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Thất Bại", "Thông Báo",JOptionPane.OK_OPTION);
        }
    }
    public void xoakhachhang()
    {
        KetNoi kn=new KetNoi();
        String mkh=tmkh.getText();
        String sql= "DELETE from khachhang where makhachhang='"+mkh+"'";
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
    @SuppressWarnings({ "unchecked", "rawtypes" })

    public void timkiem()

    {
        KetNoi kn=new KetNoi();
        int dem=0;
        try
        {
            String sql="SELECT makhachhang,HoTen,madoan,CMND,ngaysinh,QueQuan,SDT from khachhang where khachhang.hoten like '"+thtkhtk.getText().trim()+"%'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            dtm.getDataVector().removeAllElements();
            while(rs.next())
            {
                dem++;
                Row=new Vector();
                Row.addElement(rs.getString(1));
                Row.addElement(rs.getString(2));
                Row.addElement(rs.getString(3));
                Row.addElement(rs.getInt(4));
                Row.addElement(rs.getDate(5));
                Row.addElement(rs.getString(6));
                Row.addElement(rs.getInt(7));
                dtm.addRow(Row);
            }
            if(dem==0)
            {
                JOptionPane.showMessageDialog(null, "Không Có Khách Hàng nào Có Họ Tên : " +thtkhtk.getText());
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Có Lỗi Xẩy Ra", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void themkhachhang()
    {
        KetNoi kn=new KetNoi();
        String mkh=tmkh1.getText().trim();
        String htkh=thtkh1.getText().trim();
        String md=tmd1.getText().trim();
        String cmnd=tcmnd1.getText();
        String ns=tngs1.getText();
        String qq=tquequan1.getText().trim();
        String sdt=tsdt1.getText();
        try{
            String sql="Insert into KHACHHANG values('"+ mkh +"',N'" +htkh+ "','"+md+"',"+cmnd+",'"+ns+"',N'"+qq +"',"+sdt+")";
            stm=kn.con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Thành Công");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Thất Bại", "Thông Báo",JOptionPane.OK_OPTION);
        }
    }
//	public static void main(String args[])
//	{
//		KhachHang kh=new KhachHang();
//		kh.setVisible(true);
//	}

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==bload)
        {
            KhachHang kh=new KhachHang("PHẦN MỀM QUẢN LÝ KHÁCH SẠN");
            kh.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==bcapnhat)
        {
            pthongtinkh.setVisible(false);
            capnhat.setVisible(true);
            ptimkiem.setVisible(false);
        }
        else if(e.getSource()==bcap)
        {
            if(tmkh1.getText().length()<=0 )
            {
                JOptionPane.showMessageDialog(null, "bạn chua chọn mã khách hàng", "thông báo", JOptionPane.ERROR_MESSAGE);
            }
            else {

                String myPhone = "[0-9]+";
                if (!Pattern.matches(myPhone, tsdt1.getText())) {
                    JOptionPane.showMessageDialog(this, "Phone is number!", " Warning !", JOptionPane.WARNING_MESSAGE);
                    tsdt1.requestFocus();
                    tsdt1.setText("");
                }else{
                    themkhachhang();
                }

            }
        }
        else if(e.getSource()==bsuakh)
        {
            tmkh.setEditable(true);
            thtkh.setEditable(true);
            tmd.setEditable(true);
            tngs.setEditable(true);
            tquequan.setEditable(true);
            tsdt.setEditable(true);
            tcmnd.setEditable(true);

            bluusua.setVisible(true);
            blamlai.setVisible(true);
            bokxoa.setVisible(false);

            pthongtinkh.setVisible(true);
            ptimkiem.setVisible(false);
            capnhat.setVisible(false);

        }
        else if(e.getSource()==bxoakh)
        {
            tmkh.setEditable(false);
            thtkh.setEditable(false);
            tmd.setEditable(false);
            tngs.setEditable(false);
            tquequan.setEditable(false);
            tsdt.setEditable(false);
            tcmnd.setEditable(false);

            bluusua.setVisible(false);
            blamlai.setVisible(false);
            bokxoa.setVisible(true);
            pthongtinkh.setVisible(true);
            ptimkiem.setVisible(false);
            capnhat.setVisible(false);
        }
        else if(e.getSource()==btimkiemkh)
        {
            pthongtinkh.setVisible(false);
            ptimkiem.setVisible(true);
            capnhat.setVisible(false);
        }
        else if(e.getSource()==bluusua)
        {
            if(tmkh.getText().length()< 0 )
            {
                JOptionPane.showMessageDialog(null, "Bạn Không Nên bỏ Trông", "thông Báo",JOptionPane.ERROR);
            }
            else
            {
                try{
                    suathongtinkhachhang();
                }catch(Exception b)
                {

                }
            }
        }
        else if(e.getSource()==blamlai)
        {
            tmkh.setText("");
            thtkh.setText("");
            tmd.setText("");
            tcmnd.setText("");
            tngs.setText("");
            tquequan.setText("");
            tsdt.setText("");
        }
        else if(e.getSource()==bokxoa)
        {
            int dongdachon=tb.getSelectedRow();
            if(dongdachon==-1)
            {
                JOptionPane.showMessageDialog(rootPane,
                        "Bạn chưa chọn dòng cần xóa");
            }
            else
            {
                int i=JOptionPane.showConfirmDialog(this,"bạn co muốn xóa khách hàng này không ?","Thông Báo",JOptionPane.OK_CANCEL_OPTION);
                if(i==0)
                {
                    xoakhachhang();
                }
                else
                {

                }
            }
        }
        else if(e.getSource()==bthoat)

        {

            GiaoDien gd=new GiaoDien("PHẦN MỀM QUẢN LÝ KHÁCH SẠN");
            gd.setVisible(true);
            gd.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        else if(e.getSource()==btimkiem)
        {
            timkiem();
        }
    }

}
