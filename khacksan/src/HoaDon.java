

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
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

public class HoaDon extends GiaoDienNhanVien implements ItemListener {


    
    private static final long serialVersionUID = 1L;
    JPanel pcacnut=new JPanel();
    JPanel table=new JPanel();
    JPanel pthongtin=new JPanel();
    JPanel ptraphong=new JPanel();
    JPanel ptimphong=new JPanel();

    JButton bload=new JButton("Load Dữ Liệu");
    JButton bsua=new JButton("Sữa Hóa Đơn");
    JButton btrp=new JButton("Trả Phòng");
    JButton bghp=new JButton("Gia Hạn Phòng");
    JButton btimkiem=new JButton("Tìm Kiếm");
    @SuppressWarnings("rawtypes")
    Vector Row;
    DefaultTableModel dtm;
    JTable tbhoadon;
    Vector<String> rowtitle=new Vector<String>();

    JLabel lmhd=new JLabel("Mã Hóa Đơn");
    JLabel lshd=new JLabel("Số Hóa Đơn");
    JLabel lmnv=new JLabel("Mã Nhân Viên");
    JLabel lmkh=new JLabel("Mã Khách Hàng");
    JLabel lmaphong=new JLabel("Mã Phòng");
    JLabel lngayden=new JLabel("Ngày Đến");
    JLabel lngaydi=new JLabel("Ngày Đi");
    JLabel lsngo=new JLabel("Số Ngày Ở");
    JLabel lsttt=new JLabel("Trả Trước");
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

    JTextField tmhd1=new JTextField(20);
    JTextField tshd1=new JTextField(20);
    JTextField tmnv1=new JTextField(20);
    JTextField tmkh1=new JTextField(20);
    JTextField tmp1=new JTextField(20);
    JTextField tsnd1=new JTextField(20);
    JTextField tsngdi1=new JTextField(20);
    JTextField tsongayo1=new JTextField(20);
    JTextField tttt1=new JTextField(20);
    JTextField ttt1=new JTextField(20);
    @SuppressWarnings("rawtypes")
    JComboBox chonphong=new JComboBox();
    @SuppressWarnings("rawtypes")
    JComboBox chonmhd=new JComboBox();
    @SuppressWarnings("rawtypes")
    JComboBox c3=new JComboBox();

    JButton bluulai=new JButton("Lưu Lại");
    JButton bluulai1=new JButton("Gia Hạn");

    ImageIcon iconnnen=new ImageIcon("hinhanh/nen.png");
    JLabel lnen1=new JLabel(iconnnen);

    JLabel lnen2=new JLabel(iconnnen);
    JTextField timkiemshd=new JTextField(20);

    JButton btimkiem1=new JButton("Tìm Kiếm");

    JTextField dongia=new JTextField(20);
    JTextField stpt=new JTextField(20);
    JButton btinhtien=new JButton("Tính Tiền");

    public HoaDon(String title)

    {
        super(title);
        p2.setVisible(false);
        lql.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.add(pcacnut);
        pcacnut.setBounds(200, 0, 785, 50);

        this.add(pthongtin);
        pthongtin.setBounds(200, 50, 785, 400);
        this.add(ptraphong);
        ptraphong.setBounds(200, 50, 785, 400);
        this.add(ptimphong);
        ptimphong.setBounds(200, 50, 785, 400);

        ptraphong.setVisible(false);
        ptimphong.setVisible(false);
        this.add(table);
        table.setBounds(200, 450, 785, 200);

        load();
        nut();
        thongtin();
        ptraphong();
        ptimphong();

        loadcombobo();
        laydongia();
        loadmhd();

        DateFormat ddd = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        tsngdi1.setText(ddd.format(d));

        tbhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index=tbhoadon.getSelectedRow();
                tmhd.setText(String.valueOf(dtm.getValueAt(index, 0)));
                tshd.setText(String.valueOf(dtm.getValueAt(index, 1)));
                tmnv.setText(String.valueOf(dtm.getValueAt(index, 2)));
                tmkh.setText(String.valueOf(dtm.getValueAt(index, 3)));
                tmp.setText(String.valueOf(dtm.getValueAt(index, 4)));
                tsnd.setText(String.valueOf(dtm.getValueAt(index, 5)));
                tsngdi.setText(String.valueOf(dtm.getValueAt(index, 6)));
                tsongayo.setText(String.valueOf(dtm.getValueAt(index, 7)));
                tttt.setText(String.valueOf(dtm.getValueAt(index, 8)));
                ttt.setText(String.valueOf(dtm.getValueAt(index, 9)));

            }

        });
        chonphong.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                @SuppressWarnings("rawtypes")
                JComboBox jcmbType = (JComboBox) e.getSource();
                String cmbType = (String) jcmbType.getSelectedItem();
	                tmkh1.setText(cmbType);
                laydongia();

                float a=Float.parseFloat(tsongayo1.getText());
                float b=Float.parseFloat(dongia.getText());
                float c=a*b;
                ttt1.setText(String.valueOf(c));
                float d=Float.parseFloat(ttt1.getText());
                float f=Float.parseFloat(tttt1.getText());
                float g=d-f;
                stpt.setText(String.valueOf(g));

            }
        });
        chonmhd.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                @SuppressWarnings("rawtypes")
                JComboBox jcmbType = (JComboBox) e.getSource();
                String cmbType = (String) jcmbType.getSelectedItem();
	                tmkh1.setText(cmbType);
                laythongtinhd();
            }
        });


        bluulai.setVisible(false);
        bluulai.addActionListener(this);
        bluulai1.addActionListener(this);
        bluulai1.setVisible(false);
        c3.setVisible(false);
        btimkiem1.addActionListener(this);
        btinhtien.addActionListener(this);

    }
    public void laydongia()
    {
        KetNoi kn=new KetNoi();
        try{
            String sql="select dongia from phong where maphong='"+chonphong.getSelectedItem()+"'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                dongia.setText(rs.getString("dongia"));
            }
        }catch(Exception e)
        {
            System.out.println("loi");
        }
    }

    public void thanhtoan()
    {
        KetNoi kn=new KetNoi();
        String sql="UPDATE chitiethoadon set mahd='"+tmhd1.getText()+"',makh='"+tmkh1.getText()+"',ngayden='"+tsnd1.getText()+"',ngaydi='"+tsngdi1.getText()+"',songayo="+tsongayo1.getText()+",tongtientratruoc="+tttt1.getText()+",tongtien="+stpt.getText()+" where mahd='"+tmhd1.getText()+"'";
        try{
            stm=kn.con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Thanh Cong");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Loi", "title",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void returnphong()
    {
        KetNoi kn=new KetNoi();
        try{

            String sql="UPDATE PHONG SET tinhtrang='null' where maphong='"+tmp1.getText()+"'";
            stm=kn.con.createStatement();
            stm.executeUpdate(sql);
        }catch(Exception e)
        {

        }
    }
    public void laythongtinhd()
    {
        KetNoi kn=new KetNoi();
        try{
            String sql="select c.mahd,h.sohd,h.manv,c.makh,c.maphong,c.ngayden,c.ngaydi,c.songayo,c.tongtientratruoc,c.tongtien" +
                    "    from hoadon as h,chitiethoadon as c" +
                    "    where h.mahd = c.mahd'"+chonmhd.getSelectedItem()+"' order by c.mahd Desc";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                tmhd1.setText(rs.getString("c.mahd"));
                tshd1.setText(rs.getString("h.sohd"));
                tmnv1.setText(rs.getString("h.manv"));
                tmkh1.setText(rs.getString("c.makh"));
                tmp1.setText(rs.getString("c.maphong"));
                tsnd1.setText(rs.getString("c.ngayden"));
                tsngdi1.setText(rs.getString("c.ngaydi"));
                tsongayo1.setText(rs.getString("c.songayo"));
                tttt1.setText(rs.getString("c.tongtientratruoc"));
                ttt1.setText(rs.getString("c.tongtien"));
            }
        }catch(Exception e)
        {
            System.out.println("loi");
        }
    }
    public void nut()
    {
        pcacnut.setLayout(null);
        pcacnut.setBackground(Color.GRAY);
        pcacnut.add(bload);
        bload.setBounds(0, 0, 150, 50);
        bload.setFont(new Font("SansSerif", Font.ITALIC, 15));

        pcacnut.add(bsua);
        bsua.setBounds(155, 0, 150, 50);
        bsua.setFont(new Font("SansSerif", Font.ITALIC, 15));
        pcacnut.add(btrp);
        btrp.setBounds(310, 0, 150, 50);

        pcacnut.add(bghp);
        bghp.setBounds(465, 0, 150, 50);
        bghp.setFont(new Font("SansSerif", Font.ITALIC, 15));

        pcacnut.add(btimkiem);
        btimkiem.setBounds(620, 0, 165, 50);
        btimkiem.setFont(new Font("SansSerif", Font.ITALIC, 15));

        bload.addActionListener(this);
        bsua.addActionListener(this);
        btrp.addActionListener(this);
        btimkiem.addActionListener(this);
        bghp.addActionListener(this);
    }
    public void thongtin()
    {
        pthongtin.setLayout(null);

        pthongtin.add(lmhd);
        lmhd.setBounds(10, 50, 100, 50);
        
        pthongtin.add(tmhd);
        tmhd.setBounds(100, 60, 200, 30);

        pthongtin.add(lshd);
        lshd.setBounds(10, 90, 100, 50);
        pthongtin.add(tshd);
        tshd.setBounds(100, 100, 200, 30);
        pthongtin.add(lmnv);
        lmnv.setBounds(10, 140, 100, 50);
        pthongtin.add(tmnv);
        tmnv.setBounds(100, 150, 200, 30);

        pthongtin.add(lmkh);
        lmkh.setBounds(10, 180, 100, 50);
        
        pthongtin.add(tmkh);
        tmkh.setBounds(100, 190, 200, 30);

        pthongtin.add(lmaphong);
        lmaphong.setBounds(10, 220, 100, 50);

        
        pthongtin.add(tmp);
        tmp.setBounds(100, 230, 200, 30);

        pthongtin.add(c3);
        c3.setBounds(100, 230, 200, 30);

        pthongtin.add(lngayden);
        lngayden.setBounds(0, 260, 100, 50);
        pthongtin.add(tsnd);
        tsnd.setBounds(100, 270, 200, 30);
        pthongtin.add(lngaydi);
        lngaydi.setBounds(0, 300, 100, 50);
        pthongtin.add(tsngdi);
        tsngdi.setBounds(100, 310, 200, 30);

        pthongtin.add(lsngo);
        lsngo.setBounds(350, 50, 100, 50);
        pthongtin.add(tsongayo);
        tsongayo.setBounds(450, 60, 200, 30);
        pthongtin.add(lsttt);
        lsttt.setBounds(350, 90, 100, 50);
        pthongtin.add(tttt);
        tttt.setBounds(450, 100, 200, 30);

        pthongtin.add(ltt);
        ltt.setBounds(350, 130, 100, 50);
        pthongtin.add(ttt);
        ttt.setBounds(450, 140, 200, 30);

        pthongtin.add(bluulai);
        bluulai.setBounds(450, 200, 100, 30);
        pthongtin.add(bluulai1);
        bluulai1.setBounds(450, 200, 100, 30);

        pthongtin.add(lnen);
        lnen.setBounds(0, 0, 785, 400);

        tmhd.setEditable(false);
        tshd.setEditable(false);
        tmnv.setEditable(false);
        tmkh.setEditable(false);
        tmp.setEditable(false);
        tsnd.setEditable(false);
        tsngdi.setEditable(false);
        tsongayo.setEditable(false);
        tttt.setEditable(false);
        ttt.setEditable(false);


    }

    public void ptraphong()
    {
        ptraphong.setLayout(null);
        JLabel lmhd1=new JLabel("Mã Hóa Đơn");
        JLabel lshd1=new JLabel("Số Hóa Đơn");
        JLabel lmnv1=new JLabel("Mã Nhân Viên");
        JLabel lmkh1=new JLabel("Mã Khách Hàng");
        JLabel lmaphong1=new JLabel("Mã Phòng");
        JLabel lngayden1=new JLabel("Ngày Đến");
        JLabel lngaydi1=new JLabel("Ngày Đi");
        JLabel lsngo1=new JLabel("Số Ngày Ở");
        JLabel lttt1=new JLabel("Trả Trước");
        JLabel ltt1=new JLabel("Tông Tiền");

        JLabel nhan=new JLabel("x");


        ptraphong.add(chonphong);
        chonphong.setBounds(450, 10, 200, 30);
        ptraphong.add(chonmhd);
        chonmhd.setBounds(100, 10, 200, 30);
        ptraphong.add(lmhd1);
        lmhd1.setBounds(10, 50, 100, 50);
        
        ptraphong.add(tmhd1);
        tmhd1.setBounds(100, 60, 200, 30);

        ptraphong.add(lshd1);
        lshd1.setBounds(10, 90, 100, 50);
        ptraphong.add(tshd1);
        tshd1.setBounds(100, 100, 200, 30);
        ptraphong.add(lmnv1);
        lmnv1.setBounds(10, 140, 100, 50);
        ptraphong.add(tmnv1);
        tmnv1.setBounds(100, 150, 200, 30);

        ptraphong.add(lmkh1);
        lmkh1.setBounds(10, 180, 100, 50);
        
        ptraphong.add(tmkh1);
        tmkh1.setBounds(100, 190, 200, 30);

        ptraphong.add(lmaphong1);
        lmaphong1.setBounds(10, 220, 100, 50);

        
        ptraphong.add(tmp1);
        tmp1.setBounds(100, 230, 200, 30);

			ptraphong.add(c3);
			c3.setBounds(100, 230, 200, 30);

        ptraphong.add(lngayden1);
        lngayden1.setBounds(0, 260, 100, 50);
        ptraphong.add(tsnd1);
        tsnd1.setBounds(100, 270, 200, 30);
        ptraphong.add(lngaydi1);
        lngaydi1.setBounds(0, 300, 100, 50);
        ptraphong.add(tsngdi1);
        tsngdi1.setBounds(100, 310, 200, 30);

        ptraphong.add(lsngo1);
        lsngo1.setBounds(350, 50, 100, 50);
        ptraphong.add(tsongayo1);
        tsongayo1.setBounds(450, 60, 100, 30);
        ptraphong.add(nhan);
        nhan.setBounds(550, 50, 50, 50);
        ptraphong.add(dongia);
        dongia.setBounds(560, 60, 100, 30);

        ptraphong.add(lttt1);
        lttt1.setBounds(350, 90, 100, 50);
        ptraphong.add(tttt1);
        tttt1.setBounds(450, 100, 200, 30);

        ptraphong.add(ltt1);
        ltt1.setBounds(350, 130, 100, 50);
        ptraphong.add(ttt1);
        ttt1.setBounds(450, 140, 200, 30);

        JLabel l2=new JLabel("Số Tiền Phải Trả :");
        ptraphong.add(l2);
        l2.setBounds(350, 170, 200, 50);

        ptraphong.add(btinhtien);
        btinhtien.setBounds(500, 220, 100, 30);

        ptraphong.add(stpt);
        stpt.setBounds(450, 180, 200, 30);

        ptraphong.add(lnen2);
        lnen2.setBounds(0, 0, 785, 400);

        tmhd1.setEditable(false);
        tshd1.setEditable(false);
        tmnv1.setEditable(false);
        tmkh1.setEditable(false);
        tmp1.setEditable(false);
        tsnd1.setEditable(false);
        dongia.setEditable(false);
        tttt1.setEditable(false);
        ttt1.setEditable(false);
        stpt.setEditable(false);
    }
    public void ptimphong()
    {
        ptimphong.setLayout(null);

        JLabel l1=new JLabel("Nhập Mã Khách Hàng Cần Tìm kiếm");

        ptimphong.add(l1);
        l1.setBounds(100, 100, 300, 50);
        ptimphong.add(timkiemshd);
        timkiemshd.setBounds(300, 110, 200, 30);
        ptimphong.add(btimkiem1);
        btimkiem1.setBounds(550, 110, 100, 30);
        ptimphong.add(lnen1);
        lnen1.setBounds(0, 0, 785, 400);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void load()
    {
        rowtitle.add("Mã Hóa Đơn");
        rowtitle.add("Số Hóa Đơn");
        rowtitle.add("Mã NV");
        rowtitle.add("Mã KH");
        rowtitle.add("Mã Phòng");
        rowtitle.add("Ngày Đến");
        rowtitle.add("Ngày Đi");
        rowtitle.add("Số Ngày Ở");
        rowtitle.add("ST Trả Trước");
        rowtitle.add("Tổng Tiền");
        dtm=new DefaultTableModel(rowtitle,0);

        tbhoadon=new JTable(dtm);
        JTableHeader header = tbhoadon.getTableHeader();
        header.setBackground(Color.GREEN);
        table.setLayout(null);
        JScrollPane scrollTable = new JScrollPane(tbhoadon);
        scrollTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setSize(785, 200);
        table.add(scrollTable);

        KetNoi kn=new KetNoi();
        try{
            String sqlhd="Select hoadon.mahd,sohd,manv,chitiethoadon.makh,chitiethoadon.maphong,chitiethoadon.ngayden,chitiethoadon.ngaydi,chitiethoadon.songayo,chitiethoadon.tongtientratruoc,chitiethoadon.tongtien from hoadon,chitiethoadon where hoadon.mahd=chitiethoadon.mahd order by hoadon.mahd Desc";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sqlhd);
            while(rs.next())
            {
                Row=new Vector();
                Row.addElement(rs.getString("hoadon.mahd").trim());
                Row.addElement(rs.getInt("hoadon.sohd"));
                Row.addElement(rs.getString("hoadon.manv").trim());
                Row.addElement(rs.getString("chitiethoadon.makh").trim());
                Row.addElement(rs.getString("chitiethoadon.maphong").trim());
                Row.addElement(rs.getDate("chitiethoadon.ngayden"));
                Row.addElement(rs.getDate("chitiethoadon.ngaydi"));
                Row.addElement(rs.getInt("chitiethoadon.songayo"));
                Row.addElement(rs.getFloat("chitiethoadon.tongtientratruoc"));
                Row.addElement(rs.getFloat("chitiethoadon.Tongtien"));

                dtm.addRow(Row);
            }
            tbhoadon.setModel(dtm);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Xin Loi!!!");
        }
    }
    public void suathongtinhd()
    {
        KetNoi kn=new KetNoi();
        String sql="UPDATE chitiethoadon set mahd='"+tmhd.getText()+"',makh='"+tmkh.getText()+"',ngayden='"+tsnd.getText()+"',ngaydi='"+tsngdi.getText()+"',songayo="+tsongayo.getText()+",tongtientratruoc="+tttt.getText()+",tongtien="+ttt.getText()+" where mahd='"+tmhd.getText()+"'";
        try{
            stm=kn.con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Thanh Cong");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Loi", "title",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void suahd()
    {
        KetNoi kn=new KetNoi();
        try {

            String sql="update hoadon set mahd='"+tmhd.getText()+"',sohd="+tshd.getText()+",manv='"+tmnv.getText()+"' where mahd='"+tmhd.getText()+"'";
            stm=kn.con.createStatement();
            stm.executeUpdate(sql);

        } catch (Exception e) {

        }
    }
    public void giahanphong()
    {
        KetNoi kn=new KetNoi();

        try {

            String sql="update chitiethoadon set mahd='"+tmhd.getText()+"',ngaydi='"+tsngdi.getText()+"',songayo="+tsongayo.getText()+"',tongtien="+ttt.getText()+"',tongtientratruoc="+tttt.getText()+" where mahd='"+tmhd.getText()+"'";
            stm=kn.con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Thành Công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thất Bại", "titile",JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })

    public void timshd()
    {
        KetNoi kn=new KetNoi();
        try{
            String sql="SELECT DISTINCT chitiethoadon.mahd,sohd,manv,makh,maphong,ngayden,ngaydi,songayo,tongtientratruoc,tongtien from chitiethoadon,hoadon where chitiethoadon.mahd=hoadon.mahd and chitiethoadon.makh like '"+timkiemshd.getText().trim()+"%'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            int dem=0;
            dtm.getDataVector().removeAllElements();
            while(rs.next())
            {
                dem++;
                Row=new Vector();
                Row.addElement(rs.getString(1));
                Row.addElement(rs.getInt(2));
                Row.addElement(rs.getString(3));
                Row.addElement(rs.getString(4));
                Row.addElement(rs.getString(5));
                Row.addElement(rs.getDate(6));
                Row.addElement(rs.getDate(7));
                Row.addElement(rs.getInt(8));
                Row.addElement(rs.getFloat(9));
                Row.addElement(rs.getFloat(10));
                dtm.addRow(Row);

            }
            if(dem==0)
            {
                JOptionPane.showMessageDialog(null, "Không có mã khách hàng nào :" +timkiemshd.getText());
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Có Lỗi Xẩy Ra", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadcombobo()
    {
        KetNoi kn=new KetNoi();
        try {
            String sql="Select maphong from phong where tinhtrang='full'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);


        } catch (SQLException e) {


            e.printStackTrace();
        }
        chonphong.addItem("- Select - mã Phòng");
        try{
            while(rs.next())
            {
                chonphong.addItem(rs.getString("maphong"));
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi !!!!!!!");
        }
    }

    @SuppressWarnings("unchecked")
    public void loadmhd()
    {
        KetNoi kn=new KetNoi();
        try {
            String sql="Select mahd from chitiethoadon order by mahd desc ";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);


        } catch (SQLException e) {


            e.printStackTrace();
        }
        chonmhd.addItem("- Select - mã hóa đơn");
        try{
            while(rs.next())
            {
                chonmhd.addItem(rs.getString("mahd"));
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi !!!!!!!");
        }
    }

    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==bload)
        {
            HoaDon hd=new HoaDon("HÓA ĐƠN");
            hd.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource()==bsua)
        {
            tshd.setEditable(true);
            tmnv.setEditable(true);
            tmkh.setEditable(true);
            tsnd.setEditable(true);
            tsngdi.setEditable(true);
            tsongayo.setEditable(true);
            tttt.setEditable(true);
            ttt.setEditable(true);
            bluulai.setVisible(true);
            bluulai1.setVisible(false);
            c3.setVisible(false);
            
            pthongtin.setVisible(true);
            ptimphong.setVisible(false);
        }
        else if(e.getSource()==bluulai)
        {
            int dongdachon=tbhoadon.getSelectedRow();
            if(dongdachon==-1)
            {
                JOptionPane.showMessageDialog(rootPane,
                        "Bạn chưa chọn hóa đơn cần sữa");
            }
            else
            {
                int i=JOptionPane.showConfirmDialog(this,"bạn co muốn Sữa hóa Đơn này không ?","Thông Báo",JOptionPane.OK_CANCEL_OPTION);
                if(i==0)
                {
                    suathongtinhd();
                    suahd();
                }
                else
                {

                }
            }
        }
        else if(e.getSource()==bghp)
        {
            tmhd.setEditable(false);
            tshd.setEditable(false);
            tmnv.setEditable(false);
            tmkh.setEditable(false);
            tmp.setEditable(false);
            tsnd.setEditable(false);
            tsngdi.setEditable(true);
            tsongayo.setEditable(true);
            tttt.setEditable(false);
            ttt.setEditable(false);
            bluulai.setVisible(false);
            bluulai1.setVisible(true);
            pthongtin.setVisible(true);
            ptimphong.setVisible(false);
            btinhtien.setVisible(false);
        }
        else if(e.getSource()==bluulai1)
        {
            int dongdachon=tbhoadon.getSelectedRow();
            if(dongdachon==-1)
            {
                JOptionPane.showMessageDialog(rootPane,
                        "Bạn chưa chọn phong cần gia hạn");
            }
            else
            {
                int i=JOptionPane.showConfirmDialog(this,"bạn co muốn Gia hạn không ?","Thông Báo",JOptionPane.OK_CANCEL_OPTION);
                if(i==0)
                {
                    giahanphong();
                }
                else
                {

                }
            }
        }
        else if(e.getSource()==btrp)
        {
            pthongtin.setVisible(false);
            ptimphong.setVisible(false);
            ptraphong.setVisible(true);
        }
        else if(e.getSource()==btimkiem)
        {
            pthongtin.setVisible(false);
            ptraphong.setVisible(false);
            ptimphong.setVisible(true);
        }
        else if(e.getSource()==btimkiem1)
        {
            timshd();
        }
        else if(e.getSource()==btinhtien)
        {
            if(tmhd1.getText().length()<=0)
            {
                JOptionPane.showMessageDialog(null, "Bạn chưa Nhập Hóa Đơn", "title",JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                thanhtoan();
                returnphong();
            }
        }
    }
    @Override
    public void itemStateChanged(ItemEvent arg0) {

        chonphong.getSelectedIndex();
        laydongia();

    }

}
