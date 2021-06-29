package onlineshop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.Arrays;
import java.util.List;

public class Olshop extends JFrame implements ActionListener, ItemListener{

    JLabel lbl_judul = new JLabel();
	
    JLabel lbl_productName = new JLabel();
    JTextField txt_productName = new JTextField();
	
    JTable tb_olshop;
    DefaultTableModel defaultTableModel;
	
    JScrollPane spane;
	
    JButton btn_buy = new JButton();
    JButton btn_refresh = new JButton();
    
    JButton btn_filter = new JButton();
    JComboBox<String> cb_filter = new JComboBox<>();
	
    JLabel lbl_searchh = new JLabel();
    JTextField txt_search = new JTextField();

    JLabel lbl_stock = new JLabel();
    JTextField txt_stock = new JTextField();
	
    JTextArea txt_field = new JTextArea();
	
    JLabel lbl_price = new JLabel();
    JLabel lbl_rp = new JLabel();
    JTextField txt_rp = new JTextField();
    
    JLabel lbl_quantity = new JLabel();
    JTextField txt_quantity = new JTextField();
    
    String name;
    int prodQuantity, quantityNeeded;
	public Olshop(){
		
	this.setTitle("Online Shop");
	       
        this.getContentPane().setLayout(null);
        this.setTitle(" ✿ Online Shop ✿ ");
        
        lbl_judul.setFont(new Font("Courier", Font.BOLD,18));
        lbl_judul.setText("˚✧₊⁎  Online Shop  ⁎⁺˳✧༚");
        lbl_judul.setBounds(240, 30, 500, 22);
        // kiri, atas, lebar, tinggi
        this.getContentPane().add(lbl_judul);
		
        lbl_productName.setFont(new Font("georgia", Font.BOLD,14));
        lbl_productName.setText("Product Name : ");
        lbl_productName.setBounds(30, 80, 300, 22);
        this.getContentPane().add(lbl_productName);

        txt_productName.setFont(new Font("georgia", Font.PLAIN, 14));
        txt_productName.setText("");
        txt_productName.setBounds(170, 80, 200, 22);
        this.getContentPane().add(txt_productName);
        
        lbl_quantity.setFont(new Font("georgia", Font.BOLD,14));
        lbl_quantity.setText("Quantity : ");
        lbl_quantity.setBounds(30, 120, 300, 22);
        this.getContentPane().add(lbl_quantity);
        
        txt_quantity.setFont(new Font("georgia", Font.PLAIN, 14));
        txt_quantity.setText("");
        txt_quantity.setBounds(170, 120, 200, 22);
        this.getContentPane().add(txt_quantity);
        
        btn_buy.setFont(new Font("Gill Sans MT", Font.PLAIN,14));
        btn_buy.setText("Buy");
        btn_buy.setBounds(170, 160, 90, 24);
        this.getContentPane().add(btn_buy);
        btn_buy.addActionListener(this);
        
        btn_refresh.setFont(new Font("Gill Sans MT", Font.PLAIN,14));
        btn_refresh.setText("Refresh");
        btn_refresh.setBounds(270, 160, 90, 24);
        this.getContentPane().add(btn_refresh);
        btn_refresh.addActionListener(this);
        
        lbl_stock.setFont(new Font("georgia", Font.BOLD,14));
        lbl_stock.setText("Stock : ");
        lbl_stock.setBounds(410, 80, 70, 22);
        this.getContentPane().add(lbl_stock);

        txt_stock.setFont(new Font("georgia", Font.PLAIN, 14));
        txt_stock.setText("");
        txt_stock.setEditable(false);
        txt_stock.setBounds(490, 80, 200, 22);
        this.getContentPane().add(txt_stock);
        
        btn_filter.setFont(new Font("Gill Sans MT", Font.PLAIN,14));
        btn_filter.setText("Filter");
        btn_filter.setBounds(240, 230, 90, 24);
        this.getContentPane().add(btn_filter);
        btn_filter.addActionListener(this);

        cb_filter.setFont(new Font("Optima", Font.PLAIN,14));
        cb_filter.setModel(new DefaultComboBoxModel<>(new String[] {"Baju", "Tempat Minum", "Gelas", "Piring", "Celana", "Lampu Belajar", "Hiasan Dinding", "Rak Dinding", "Sapu Pel", "Set Pisau" }));
        cb_filter.setSelectedItem(null);
        cb_filter.setBounds(30, 230, 200, 24);
 	this.getContentPane().add(cb_filter);
 	cb_filter.addItemListener(this);
 	
 	JPanel content = new JPanel();
 		
 	JScrollPane Spane = new JScrollPane(txt_field,
 	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
 	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 	txt_field.setFont(new Font("Optima", Font.PLAIN,14));
 	txt_field.setText("");

 	txt_field.setLineWrap(true);
 	txt_field.setWrapStyleWord(true);
	
 	content.setLayout(new BorderLayout());
        content.add(Spane);
        content.setBounds(410, 120, 280, 120);
        
        this.getContentPane().add(content);
        
        lbl_price.setFont(new Font("georgia", Font.BOLD,14));
        lbl_price.setText("Price: ");
        lbl_price.setBounds(410, 250, 50, 22);
        this.getContentPane().add(lbl_price);
        
        lbl_rp.setFont(new Font("georgia", Font.BOLD,14));
        lbl_rp.setText("Rp.");
        lbl_rp.setBounds(470, 250, 50, 22);
        this.getContentPane().add(lbl_rp);

        txt_rp.setFont(new Font("georgia", Font.PLAIN, 14));
        txt_rp.setText("");
        txt_rp.setEditable(false);
        txt_rp.setBounds(530, 250, 160, 22);
        this.getContentPane().add(txt_rp);
		
        lbl_searchh.setFont(new Font("georgia", Font.BOLD,14));
        lbl_searchh.setText("Search : ");
        lbl_searchh.setBounds(30, 290, 300, 22);
        this.getContentPane().add(lbl_searchh);

        txt_search.setFont(new Font("georgia", Font.PLAIN, 14));
        txt_search.setText("");
        txt_search.setBounds(170, 290, 200, 22);
        this.getContentPane().add(txt_search);
        
        String [] kolom = {"Product Name", "Category", "Stock", "Price"};

        defaultTableModel = new DefaultTableModel(kolom, 0);
        tb_olshop = new JTable(defaultTableModel);
        spane = new JScrollPane(tb_olshop);
        spane.setBounds(30, 340,700,250);
        this.getContentPane().add(spane);
        
        tb_olshop.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            get_data();
            }
        });
        
        show_data();
	}
        
        public void get_data(){
        int selectedRow = tb_olshop.getSelectedRow();
        
        name = tb_olshop.getValueAt(selectedRow,0).toString();
        prodQuantity = Integer.valueOf(tb_olshop.getValueAt(selectedRow, 2).toString());
        txt_productName.setText(name);
        txt_stock.setText(String.valueOf(prodQuantity));
    }
        
        public void set_data(){
        name = txt_productName.getText().trim();
        quantityNeeded = Integer.valueOf(txt_quantity.getText().trim());
        }
        
        public void reset_table(){
            defaultTableModel.setRowCount(0);
        }
        
        public void refresh(){
            reset_table();
            show_data();
        }
        
        public void show_data(){
        List data = new Product().show_data();
        String[] str = (String[])data.toArray(new String[0]);
        
        for(int i=0;i<str.length;i+=4){
            String[] df = {str[i], str[i+1], str[i+2], str[i+3]};
            defaultTableModel.addRow(df);
        }
     }
	
	public static void main(String[] args){
    	Olshop a = new Olshop();
        a.setSize(780,650);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	a.setLocationRelativeTo(null);
        a.setResizable(false);
        a.setVisible(true);
    }
	public void reset(){
            txt_productName.setText("");
	    txt_quantity.setText("");
        }
        
	public String cek_kosong() {
        String hasil;
        if(txt_productName.getText().trim().equals("")) {
            hasil = "Please select product to buy";
        }
        else if(txt_quantity.getText().trim().equals("")){
            hasil = "Please enter your amount.";
        }
        else{
            hasil = "Valid.";
        }
        return hasil;
    }
	@Override
	public void itemStateChanged(ItemEvent e) {
            
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btn_buy)) {
            String cek = cek_kosong();
            if(cek.equals("Valid.")) {
                set_data();
                if(prodQuantity < quantityNeeded || prodQuantity <= 0){
                    JOptionPane.showMessageDialog(null, "Not enough in stock");
                }else{
                    String save = new Product().update_data(name, quantityNeeded);
                    JOptionPane.showMessageDialog(null,"Your purchase has been added.");
                    refresh();
                    reset();
                }
            } else {
                JOptionPane.showMessageDialog(null, cek);
            }
            
         } else if(e.getSource().equals(btn_refresh)) {
        	txt_productName.setText("");
        	txt_quantity.setText("");
                txt_stock.setText("");
        }
		
	}
	
}
