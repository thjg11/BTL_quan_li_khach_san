

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class TimPhong extends GiaoDienNhanVien implements ItemListener,ActionListener {

    JPanel ptimphong=new JPanel();
    JPanel ptabel=new JPanel();
    JLabel l1=new JLabel("Bạn Chọn Điều Kiền Để Tìm Phòng");

    Vector<String> rowtitle=new Vector<String>();
    @SuppressWarnings("rawtypes")
    Vector Row;
    DefaultTableModel dtm;
    JTable tb;

    ImageIcon ip3=new ImageIcon("hinhanh/nen.png");
    JLabel lnen=new JLabel(ip3);

    JRadioButton c1=new JRadioButton("Tìm Mã Phòng");
    JRadioButton c2=new JRadioButton("Tìm Số Phòng");
    JRadioButton c3=new JRadioButton("Đơn Gia ");
    JRadioButton c4=new JRadioButton("Tình Trạng");

    JRadioButton r=new JRadioButton();

    JLabel lmp=new JLabel("Nhập Mã Phòng Cần Tìm:");
    JLabel lsp=new JLabel("Nhập Số Phòng Cần Tìm:");
    JLabel ldg=new JLabel("Nhập Đơn Giá Cần Tìm:");
    JLabel ltt=new JLabel("Nhập Tình Trạng Phòng:");

    JTextField tmp=new JTextField(20);
    JTextField tsp=new JTextField(20);
    JTextField tdg=new JTextField(20);
    JTextField ttt=new JTextField(20);

    JButton b1=new JButton("Tìm Kiếm");
    JButton b2=new JButton("Tìm Kiếm");
    JButton b3=new JButton("Tìm Kiếm");
    JButton b4=new JButton("Tìm Kiếm");
    public TimPhong(String title)
    {
        super(title);
        p2.setVisible(false);
        this.setLayout(null);
        this.add(ptimphong);
        ptimphong.setBounds(200, 0, 785, 400);
        ptimphong.setBackground(Color.GRAY);
        this.add(ptabel);
        ptabel.setBounds(200, 400, 785, 300);
        lql.setVisible(true);
        this.load();
        thongtin();

        lmp.setVisible(false);
        lsp.setVisible(false);
        ldg.setVisible(false);
        ltt.setVisible(false);
        tmp.setVisible(false);
        tsp.setVisible(false);
        tdg.setVisible(false);
        ttt.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b4.setVisible(false);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        c1.setSelected(false);
        c2.setSelected(false);
        c3.setSelected(false);
        c4.setSelected(false);
    }
    public void thongtin()
    {
        ptimphong.setLayout(null);
        ptimphong.add(l1);
        l1.setBounds(10, 10, 400, 50);
        ptimphong.add(c1);
        c1.setBounds(100, 50, 110, 30);
        ptimphong.add(c2);
        c2.setBounds(250, 50, 110, 30);
        ptimphong.add(c3);
        c3.setBounds(400, 50, 110, 30);
        ptimphong.add(c4);
        c4.setBounds(550, 50, 110, 30);

        ptimphong.add(lmp);
        lmp.setBounds(100, 200, 200, 50);
        ptimphong.add(tmp);
        tmp.setBounds(250, 210, 200, 30);
        ptimphong.add(b1);
        b1.setBounds(500, 210, 100, 30);

        ptimphong.add(lsp);
        lsp.setBounds(100, 200, 200, 50);
        ptimphong.add(tsp);
        tsp.setBounds(250, 210, 200, 30);
        ptimphong.add(b2);
        b2.setBounds(500, 210, 100, 30);

        ptimphong.add(ldg);
        ldg.setBounds(100, 200, 200, 50);
        ptimphong.add(tdg);
        tdg.setBounds(250, 210, 200, 30);
        ptimphong.add(b3);
        b3.setBounds(500, 210, 100, 30);

        ptimphong.add(ltt);
        ltt.setBounds(100, 200, 200, 50);
        ptimphong.add(ttt);
        ttt.setBounds(250, 210, 200, 30);
        ptimphong.add(b4);
        b4.setBounds(500, 210, 100, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(c1);
        group.add(c2);
        group.add(c3);
        group.add(c4);
        ptimphong.add(lnen);
        lnen.setBounds(0, 0, 785, 400);

        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        c4.addItemListener(this);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void load()
    {
        rowtitle.add("Mã phòng");
        rowtitle.add("Số Phòng");
        rowtitle.add("Mã Loại Phòng");
        rowtitle.add("Tình Trạng");
        rowtitle.add("Đơn Giá");
        dtm=new DefaultTableModel(rowtitle,0);

        tb=new JTable(dtm);


        ptabel.setLayout(null);
        JScrollPane scrollTable = new JScrollPane(tb);
        scrollTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setSize(785, 300);
        ptabel.add(scrollTable);

        KetNoi kn=new KetNoi();


        try
        {
            String sql="select * from phong ";
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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void timmaphong()
    {
        KetNoi kn=new KetNoi();
        int dem=0;
        try{

            String sql="SELECT maphong,sophong,maloaiphong,tinhtrang,dongia from phong where phong.maphong like '"+tmp.getText().trim()+"%'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            dtm.getDataVector().removeAllElements();
            while(rs.next())
            {
                dem++;
                Row=new Vector();
                Row.addElement(rs.getString(1));
                Row.addElement(rs.getInt(2));
                Row.addElement(rs.getString(3));
                Row.addElement(rs.getString(4));
                Row.addElement(rs.getFloat(5));
                dtm.addRow(Row);
            }
            if(dem==0)
            {
                JOptionPane.showMessageDialog(null, "Không có mã phòng :"+tmp.getText());
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Có Lỗi Xẩy Ra", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void timsophong()
    {
        KetNoi kn=new KetNoi();
        int dem=0;
        try{

            String sql="SELECT maphong,sophong,maloaiphong,tinhtrang,dongia from phong where phong.sophong like '"+tsp.getText().trim()+"%'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            dtm.getDataVector().removeAllElements();
            while(rs.next())
            {
                dem++;
                Row=new Vector();
                Row.addElement(rs.getString(1));
                Row.addElement(rs.getInt(2));
                Row.addElement(rs.getString(3));
                Row.addElement(rs.getString(4));
                Row.addElement(rs.getFloat(5));
                dtm.addRow(Row);
            }

            if(dem==0)
            {
                JOptionPane.showMessageDialog(null, "Không có số phòng :"+tsp.getText());
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Có Lỗi Xẩy Ra", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void timdongia()
    {
        KetNoi kn=new KetNoi();
        int dem=0;
        try{

            String sql="SELECT maphong,sophong,maloaiphong,tinhtrang,dongia from phong where phong.dongia like '"+tdg.getText().trim()+"%'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            dtm.getDataVector().removeAllElements();
            while(rs.next())
            {
                dem++;
                Row=new Vector();
                Row.addElement(rs.getString(1));
                Row.addElement(rs.getInt(2));
                Row.addElement(rs.getString(3));
                Row.addElement(rs.getString(4));
                Row.addElement(rs.getFloat(5));
                dtm.addRow(Row);
            }
            if(dem==0)
            {
                JOptionPane.showMessageDialog(null, "Không có phòng có đơn giá :"+tdg.getText());
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Có Lỗi Xẩy Ra", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void tinhtrang()
    {
        KetNoi kn=new KetNoi();
        int dem=0;
        try{

            String sql="SELECT maphong,sophong,maloaiphong,tinhtrang,dongia from phong where phong.tinhtrang like '"+ttt.getText().trim()+"%'";
            stm=kn.con.createStatement();
            rs=stm.executeQuery(sql);
            dtm.getDataVector().removeAllElements();
            while(rs.next())
            {
                dem++;
                Row=new Vector();
                Row.addElement(rs.getString(1));
                Row.addElement(rs.getInt(2));
                Row.addElement(rs.getString(3));
                Row.addElement(rs.getString(4));
                Row.addElement(rs.getFloat(5));
                dtm.addRow(Row);
            }
            if(dem==0)
            {
                JOptionPane.showMessageDialog(null, "Không có phòng có tình trạng  :"+ttt.getText());
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Có Lỗi Xẩy Ra", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    //	public static void main(String[] args) {
//		TimPhong tp=new TimPhong();
//		tp.setVisible(true);
//	}
    @Override
    public void itemStateChanged(ItemEvent e) {

        if(c1.isSelected())
        {
            c1.setSelected(true);
            c2.setSelected(false);
            c3.setSelected(false);
            c4.setSelected(false);
            lmp.setVisible(true);
            tmp.setVisible(true);

            // lmp.setVisible(false);
            lsp.setVisible(false);
            ldg.setVisible(false);
            ltt.setVisible(false);
            //tmp.setVisible(false);
            tsp.setVisible(false);
            tdg.setVisible(false);
            ttt.setVisible(false);
            b1.setVisible(true);
            b2.setVisible(false);
            b3.setVisible(false);
            b4.setVisible(false);

        }
        else if(c2.isSelected())
        {
            c1.setSelected(false);
            c2.setSelected(true);
            c3.setSelected(false);
            c4.setSelected(false);

            lmp.setVisible(false);
            lsp.setVisible(true);
            ldg.setVisible(false);
            ltt.setVisible(false);
            tmp.setVisible(false);
            tsp.setVisible(true);
            tdg.setVisible(false);
            ttt.setVisible(false);
            b1.setVisible(false);
            b2.setVisible(true);
            b3.setVisible(false);
            b4.setVisible(false);
        }
        else if(c3.isSelected())
        {
            c1.setSelected(false);
            c2.setSelected(false);
            //c3.setSelected(false);
            c4.setSelected(false);

            lmp.setVisible(false);
            lsp.setVisible(false);
            ldg.setVisible(true);
            ltt.setVisible(false);
            tmp.setVisible(false);
            tsp.setVisible(false);
            tdg.setVisible(true);
            ttt.setVisible(false);
            b1.setVisible(false);
            b2.setVisible(false);
            b3.setVisible(true);
            b4.setVisible(false);
        }
        else if(c4.isSelected())
        {
            c1.setSelected(false);
            c2.setSelected(false);
            c3.setSelected(false);
            // c4.setSelected(false);
            lmp.setVisible(false);
            lsp.setVisible(false);
            ldg.setVisible(false);
            ltt.setVisible(true);
            tmp.setVisible(false);
            tsp.setVisible(false);
            tdg.setVisible(false);
            ttt.setVisible(true);
            b1.setVisible(false);
            b2.setVisible(false);
            b3.setVisible(false);
            b4.setVisible(true);
        }
        else {

        }
    }
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1)
        {
            timmaphong();
        }
        else if(e.getSource()==b2)
        {
            timsophong();
        }
        else if(e.getSource()==b3)
        {
            timdongia();
        }
        else if(e.getSource()==b4)
        {
            tinhtrang();
        }
    }

}
