

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

@SuppressWarnings("serial")
public class Dangky extends GiaoDienNhanVien  implements ActionListener{

    JPanel pdk=new JPanel();
    JPanel pphong=new JPanel();
    JPanel phoadon =new JPanel();
    JPanel ppdp=new JPanel();

    JLabel lgt=new JLabel("Thông Tin Đăng Ký Khách Hàng ");

    JTable tb;
    JTable tbhoadon;
    JTable phieudp;
    Vector Row;
    Vector Row1;
    DefaultTableModel dtm;
    DefaultTableModel dtm1;
    Vector<String> rowtitle=new Vector<String>();
    Vector<String> rowtitle1=new Vector<String>();

    Vector Row2;
    DefaultTableModel dtm2;
    Vector<String> rowtitle2=new Vector<String>();
    JLabel lmhd=new JLabel("Mã Hóa Đơn");
    JLabel lshd=new JLabel("Số Hóa Đơn");
    JLabel lmnv=new JLabel("Mã Nhân Viên");
    JLabel lmkh=new JLabel("Mã Khách Hàng");
    JLabel lmaphong=new JLabel("Mã Phòng");
    JLabel lngayden=new JLabel("Ngày Đến");
    JLabel lngaydi=new JLabel("Ngày Đi");
    JLabel lsngo=new JLabel("Số Ngày Ở");
    JLabel lsttt=new JLabel("Số Tiền Trả Trước");
    JLabel ltt=new JLabel("Tông Tiền");

    JTextField tmhd=new JTextField(20);
    JTextField tshd=new JTextField(20);
    JTextField tmnv=new JTextField(20);
    JTextField tmkh=new JTextField(20);
    JTextField tmp=new JTextField(20);
    JTextField tsnd=new JTextField(20);
    JTextField tsngdi=new JTextField(20);
    JTextField tsongayo=new JTextField(20);
    JTextField tttt=new JTextField(20);
    JTextField ttt=new JTextField(20);

    @SuppressWarnings("rawtypes")
    JComboBox c1=new JComboBox();
    JButton bthem=new JButton("Thêm");
    JButton bxoa=new JButton("Tính");

    @SuppressWarnings("rawtypes")
    JComboBox c2=new JComboBox();
    @SuppressWarnings("rawtypes")
    JComboBox c3=new JComboBox();
    @SuppressWarnings("rawtypes")
    JComboBox c4=new JComboBox();

    JTextField tyyyy=new JTextField();
    JTextField tmm=new JTextField();
    JTextField tdd=new JTextField();

    JTextField tyyyy1=new JTextField();
    JTextField tmm1=new JTextField();
    JTextField tdd1=new JTextField();


    public Dangky(String title)
    {
        super(title);
        p2.setVisible(false);
        this.setLayout(null);
        this.add(pdk);
        pdk.setBounds(200, 0, 400, 500);
        //pdk.setBackground(Color.BLUE);
        this.add(pphong);
        pphong.setBounds(600, 0, 400, 300);
        pphong.setBackground(Color.GRAY);

        this.add(ppdp);
        ppdp.setBounds(600, 300, 400, 200);
        this.add(phoadon);
        phoadon.setBounds(200, 500, 800, 160);
        phoadon.setBackground(Color.BLACK);

        this.loadphong();
        this.loadhoadon();
        this.dangkykhachhang();
        this.loadcombo();
        bthem.addActionListener(this);
        bxoa.addActionListener(this);
        lql.setVisible(true);
        loadphieu();


    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void loadphieu()
    {
        rowtitle2.add("Họ Tên");
        rowtitle2.add("CMND/HC");
        rowtitle2.add("Ngày Đến");
        rowtitle2.add("Ngày Đi");
        rowtitle2.add("Đơn Giá");
        rowtitle2.add("Số người");
        dtm2=new DefaultTableModel(rowtitle2,0);

        phieudp=new JTable(dtm2);

        JTableHeader header = phieudp.getTableHeader();
        header.setBackground(Color.GREEN);
        ppdp.setLayout(null);
        JScrollPane scrollTable = new JScrollPane(phieudp);
        scrollTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setSize(390, 200);
        ppdp.add(scrollTable);

        KetNoi kn=new KetNoi();


        try
        {
            String sql="select hoten,cmnd,ngayden,ngaydi,dongia,songuoi from phieudatphong ";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                Row2=new Vector();
                Row2.addElement(rs.getString("hoten").trim());
                Row2.addElement(rs.getString("cmnd"));
                Row2.addElement(rs.getDate("ngayden"));
                Row2.addElement(rs.getDate("ngaydi"));
                Row2.addElement(rs.getFloat("dongia"));
                Row2.addElement(rs.getInt("songuoi"));
                dtm2.addRow(Row2);

            }

            phieudp.setModel(dtm2);
            kn.con.close();
            stm.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Khong the tai du lieu!");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void dangkykhachhang()
    {
        pdk.setLayout(null);
        pdk.add(lgt);
        lgt.setBounds(100, 0, 300, 50);

        pdk.add(lmhd);
        lmhd.setBounds(0, 40, 100, 50);
        pdk.add(tmhd);
        tmhd.setBounds(100, 50, 200, 30);

        pdk.add(lshd);
        lshd.setBounds(0, 80, 100, 50);
        pdk.add(tshd);
        tshd.setBounds(100, 90, 200, 30);

        pdk.add(lmnv);
        lmnv.setBounds(0, 130, 100, 50);
        pdk.add(tmnv);
        tmnv.setBounds(100, 140, 200, 30);

        pdk.add(lmkh);
        lmkh.setBounds(0, 170, 100, 50);
        pdk.add(tmkh);
        tmkh.setBounds(100, 180, 200, 30);
        pdk.add(lmaphong);
        lmaphong.setBounds(0, 440, 100, 50);
        pdk.add(c1);
        c1.setBounds(100, 450, 200, 30);
        //	c1.addItem("Chọn Mã Phòng");
        pdk.add(lngayden);
        lngayden.setBounds(0, 220, 100, 50);
        pdk.add(tsnd);
        //tsnd.setBounds(100, 230, 200, 30);
        pdk.add(tyyyy);
        pdk.add(tmm);
        pdk.add(tdd);
        tyyyy.setBounds(100, 230, 100, 30);
        tmm.setBounds(230, 230, 50, 30);
        tdd.setBounds(300, 230, 50, 30);
        pdk.add(lngaydi);
        lngaydi.setBounds(0, 260, 100, 50);
        pdk.add(tsngdi);
        //tsngdi.setBounds(100, 270, 200, 30);
        pdk.add(tyyyy1);
        pdk.add(tmm1);
        pdk.add(tdd1);
        tyyyy1.setBounds(100, 270, 100, 30);
        tmm1.setBounds(230, 270, 50, 30);
        tdd1.setBounds(300, 270, 50, 30);
        c2.addItem("Năm");
        for(int i=2005;i<=2020;i++)
        {
            c2.addItem(i);
        }
        c3.addItem("Tháng");
        for(int j=1;j<=12;j++)
        {
            c3.addItem(j);
        }
        c4.addItem("Ngày");
        for(int k=1;k<=31;k++)
        {
            c4.addItem(k);
        }
        pdk.add(lsngo);
        lsngo.setBounds(0, 300, 100, 50);
        pdk.add(tsongayo);
        tsongayo.setBounds(100, 310, 200, 30);

        pdk.add(lsttt);
        lsttt.setBounds(0, 350, 100, 50);
        pdk.add(tttt);
        tttt.setBounds(100, 360, 200, 30);

        pdk.add(ltt);
        ltt.setBounds(0, 390, 100, 50);
        pdk.add(ttt);
        ttt.setBounds(100, 400, 200, 30);

        pdk.add(bthem);
        bthem.setBounds(320, 450, 80, 30);

        pdk.add(bxoa);
        bxoa.setBounds(320, 310, 80, 30);
        DateFormat yy = new SimpleDateFormat("yyyy");
        DateFormat mm = new SimpleDateFormat("MM");
        DateFormat ddd = new SimpleDateFormat("dd");
        Date d = new Date();
        tyyyy.setText(yy.format(d));
        tmm.setText(mm.format(d));
        tdd.setText(ddd.format(d));


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

        tb=new JTable(dtm);


        pphong.setLayout(null);
        JScrollPane scrollTable = new JScrollPane(tb);
        scrollTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setSize(390, 300);
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
                Row.addElement(rs.getFloat("dongia"));
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
    @SuppressWarnings("unchecked")
    public void loadcombo()
    {
        KetNoi kn=new KetNoi();
        try {
            String sql="Select maphong from phong where tinhtrang='null'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);


        } catch (SQLException e) {


            e.printStackTrace();
        }
        c1.addItem("- Select -");
        try{
            while(rs.next())
            {
                c1.addItem(rs.getString("maphong"));
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi !!!!!!!");
        }

    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void loadhoadon()
    {
        rowtitle1.add("Mã Hóa Đơn");
        rowtitle1.add("Số Hóa Đơn");
        rowtitle1.add("Mã NV");
        rowtitle1.add("Mã KH");
        rowtitle1.add("Mã Phòng");
        rowtitle1.add("Ngày Đến");
        rowtitle1.add("Ngày Đi");
        rowtitle1.add("Số Ngày Ở");
        rowtitle1.add("ST Trả Trước");
        rowtitle1.add("Tổng Tiền");
        dtm1=new DefaultTableModel(rowtitle1,0);

        tbhoadon=new JTable(dtm1);
        JTableHeader header = tbhoadon.getTableHeader();
        header.setBackground(Color.GREEN);
        phoadon.setLayout(null);
        JScrollPane scrollTable1 = new JScrollPane(tbhoadon);
        scrollTable1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTable1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTable1.setSize(790, 160);
        phoadon.add(scrollTable1);

        KetNoi kn=new KetNoi();
        try{
            String sqlhd="Select hoadon.mahd,sohd,manv,makh,maphong,ngayden,ngaydi,songayo,tongtientratruoc,tongtien from hoadon,chitiethoadon where hoadon.mahoadon=chitiethoadon.mahoadon order by mahoadon Desc";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sqlhd);
            while(rs.next())
            {
                Row1=new Vector();
                Row1.addElement(rs.getString("hoadon.mahd").trim());
                Row1.addElement(rs.getInt("sohd"));
                Row1.addElement(rs.getString("manv").trim());
                Row1.addElement(rs.getString("makh").trim());
                Row1.addElement(rs.getString("maphong").trim());
                Row1.addElement(rs.getDate("ngayden"));
                Row1.addElement(rs.getDate("ngaydi"));
                Row1.addElement(rs.getInt("songayo"));
                Row1.addElement(rs.getFloat("tongtientratruoc"));
                Row1.addElement(rs.getFloat("Tongtien"));

                dtm1.addRow(Row1);
            }
            tbhoadon.setModel(dtm1);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Xin Loi!!!");
        }
    }
    public void dangkyhd()
    {
        String mhd=tmhd.getText().trim();
        String shd=tshd.getText();
        String mnv=tmnv.getText().trim();

        KetNoi kn=new KetNoi();

        try{

            String sql="INSERT INTO hoadon (mahd,sohd,manv) values('"+mhd+"',"+shd+",'"+mnv+"')";
            stm=kn.con.createStatement();
            stm.executeUpdate(sql);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Loi");
        }
    }
    public void dangkychitiethd()
    {
        String mhd=tmhd.getText().trim();



        String mkh=tmkh.getText().trim();
        String mp=(String) c1.getSelectedItem();


        DateFormat yy = new SimpleDateFormat("yyyy-MM-dd");

        Date d = new Date();
        tyyyy.setText(yy.format(d));

        //String sndi=tsngdi.getText();
        String songo=tsongayo.getText();

        String tratruoc=tttt.getText();

        KetNoi kn=new KetNoi();

        try{

            String sql="INSERT INTO chitiethoadon(mahd,makh,maphong,ngayden,ngaydi,songayo,tongtientratruoc,tongtien) values('"+mhd+"','"+mkh+"','"+mp+"','"+yy.format(d)+"','"+tyyyy1.getText()+"-"+tmm1.getText()+"-"+tdd1.getText()+"',"+songo+","+tratruoc+",'0')";
            stm=kn.con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Thêm Thành Công!!");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Loi");
        }
    }
    public void chenphong()
    {
        String mp=(String) c1.getSelectedItem();
        KetNoi kn=new KetNoi();
        try{

            String sql="UPDATE PHONG SET tinhtrang='full' where maphong='"+mp+"'";
            stm=kn.con.createStatement();
            stm.executeUpdate(sql);
        }catch(Exception e)
        {

        }
    }
    @SuppressWarnings("unused")
    private String Int(String sndi) {
        // TODO Auto-generated method stub
        return null;
    }

    public void actionPerformed(ActionEvent e) {

        try{
            int yy,yy2,mm,mm2,dd,dd2;
            yy=Integer.parseInt(String.valueOf(tyyyy1.getText()));
            yy2=Integer.parseInt(String.valueOf(tyyyy.getText()));
            mm=Integer.parseInt(String.valueOf(tmm1.getText()));
            mm2=Integer.parseInt(String.valueOf(tmm.getText()));

            dd=Integer.parseInt(String.valueOf(tdd1.getText()));
            dd2=Integer.parseInt(String.valueOf(tdd.getText()));

            if(e.getSource()==bthem)
            {

                if(tyyyy1.getText().length()<=0 || tmm1.getText().length()<=0 ||tdd1.getText().length()<=0)
                {
                    JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập năm ,Ngày Hoặc Tháng");
                }
                else
                {
                    if(yy<yy2)
                    {
                        JOptionPane.showMessageDialog(null, "Bạn Chọn Năm Không Hợp Lê");
                    }
                    else if(mm<mm2)
                    {
                        JOptionPane.showMessageDialog(null, "Bạn Chọn Thang Không Hợp Lê");
                    }
                    else if(mm==mm2 && dd<dd2)
                    {
                        JOptionPane.showMessageDialog(null, "Bạn Chọn Ngay Không Hợp Lê");
                    }

                    else
                    {
                        dangkyhd();
                        dangkychitiethd();
                        chenphong();
                    }
                }
            }
        }catch(Exception ef)
        {
            JOptionPane.showMessageDialog(null, "Lỗi");
        }
        if(e.getSource()==bxoa)
        {
            try{
                int yy,yy2,mm,mm2,dd,dd2;
                yy=Integer.parseInt(String.valueOf(tyyyy1.getText()));
                yy2=Integer.parseInt(String.valueOf(tyyyy.getText()));
                mm=Integer.parseInt(String.valueOf(tmm1.getText()));
                mm2=Integer.parseInt(String.valueOf(tmm.getText()));

                dd=Integer.parseInt(String.valueOf(tdd1.getText()));
                dd2=Integer.parseInt(String.valueOf(tdd.getText()));

                if(tyyyy1.getText().length()<=0 || tmm1.getText().length()<=0 ||tdd1.getText().length()<=0)
                {
                    JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập năm ,Ngày Hoặc Tháng");
                }
                else
                {
                    if(yy<yy2)
                    {
                        JOptionPane.showMessageDialog(null, "Bạn Chọn Năm Không Hợp Lê");
                    }
                    else if(mm<mm2)
                    {
                        JOptionPane.showMessageDialog(null, "Bạn Chọn Thang Không Hợp Lê");
                    }
                    else if(mm==mm2 && dd<dd2)
                    {
                        JOptionPane.showMessageDialog(null, "Bạn Chọn Ngay Không Hợp Lê");
                    }

                    else
                    {
                        if(yy-yy2==0)
                        {
                            if(mm-mm2==0)
                            {
                                int ngay=Integer.parseInt(String.valueOf(dd-dd2));
                                tsongayo.setText(String.valueOf(ngay));
                            }
                            else if(mm-mm2 >0)
                            {
                                int i=(mm-mm2)*30-dd2+dd;
                                int ngay=Integer.parseInt(String.valueOf(i));
                                tsongayo.setText(String.valueOf(ngay));
                            }
                        }
                    }



                }
            }catch(Exception et)
            {
                JOptionPane.showMessageDialog(null, "Lỗi");
            }
        }
    }
}
