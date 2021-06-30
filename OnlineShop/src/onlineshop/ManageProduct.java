package onlineshop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.Arrays;
import java.util.List;

public class ManageProduct extends JFrame implements ActionListener{

    String name, category, stock, price;
            
    JLabel lbl_judul = new JLabel();
   
    JTable tb_manage;
    DefaultTableModel defaultTableModel;
     
    JScrollPane spane;
	
    JLabel lbl_fName = new JLabel();
	
    JLabel lbl_productName = new JLabel();
    JTextField txt_productName = new JTextField();
	
    JLabel lbl_stock = new JLabel();
    JTextField txt_stock = new JTextField();
	
    JLabel lbl_price = new JLabel();
    JTextField txt_price = new JTextField();
	
    JLabel lbl_category = new JLabel();
    JComboBox<String> cb_category = new JComboBox<>();
    JButton btn_add = new JButton();
    JButton btn_edit = new JButton();
    JButton btn_delete = new JButton();
    JButton btn_clear = new JButton();
    JButton btn_logout = new JButton();
    JButton btn_search = new JButton();
    JButton btn_refresh = new JButton();
    
    JLabel lbl_search = new JLabel();
    JTextField txt_search = new JTextField();
	
    public ManageProduct(){
        this.setTitle("Manage Product");
       
        this.getContentPane().setLayout(null);
        this.setTitle(" ✿ Manage Product ✿ ");
        
        lbl_judul.setFont(new Font("Courier", Font.BOLD,18));
        lbl_judul.setText("˚✧₊⁎  Online Shop  ⁎⁺˳✧༚");
        lbl_judul.setBounds(180, 30, 500, 22);
        // kiri, atas, lebar, tinggi
        this.getContentPane().add(lbl_judul);
	
        lbl_productName.setFont(new Font("georgia", Font.BOLD,14));
        lbl_productName.setText("Product Name : ");
        lbl_productName.setBounds(30, 80, 300, 22);
        this.getContentPane().add(lbl_productName);

        txt_productName.setFont(new Font("georgia", Font.PLAIN, 14));
        txt_productName.setText("");
        txt_productName.setBounds(170, 80, 200, 28);
        this.getContentPane().add(txt_productName);
        
        lbl_category.setFont(new Font("Optima", Font.BOLD,14));
        lbl_category.setText("Category : ");
        lbl_category.setBounds(30, 120, 200, 24);
        this.getContentPane().add(lbl_category);
       
        cb_category.setFont(new Font("Optima", Font.PLAIN,14));
        cb_category.setModel(new DefaultComboBoxModel<>(new String[] {"Baju", "Tempat Minum", "Gelas", "Piring", "Celana", "Lampu Belajar", "Hiasan Dinding", "Rak Dinding", "Sapu Pel", "Set Pisau" }));
        cb_category.setSelectedItem(null);
        cb_category.setBounds(170, 120, 200, 24);
 	this.getContentPane().add(cb_category);
	
        lbl_stock.setFont(new Font("georgia", Font.BOLD,14));
        lbl_stock.setText("Stock : ");
        lbl_stock.setBounds(400, 80, 85, 24);
        this.getContentPane().add(lbl_stock);

        txt_stock.setFont(new Font("georgia", Font.PLAIN, 14));
        txt_stock.setText("");
        txt_stock.setBounds(470, 80, 200, 28);
        this.getContentPane().add(txt_stock);
	
        lbl_price.setFont(new Font("georgia", Font.BOLD,14));
        lbl_price.setText("Price : ");
        lbl_price.setBounds(400, 120, 85, 24);
        this.getContentPane().add(lbl_price);

        txt_price.setFont(new Font("georgia", Font.PLAIN, 14));
        txt_price.setText("");
        txt_price.setBounds(470, 120, 200, 28);
        this.getContentPane().add(txt_price);
	
        btn_add.setFont(new Font("Gill Sans MT", Font.PLAIN,14));
        btn_add.setText("Add");
        btn_add.setBounds(160, 200, 90, 24);
        this.getContentPane().add(btn_add);
        btn_add.addActionListener(this);
        
        btn_edit.setFont(new Font("Gill Sans MT", Font.PLAIN,14));
        btn_edit.setText("Edit");
        btn_edit.setBounds(280, 200, 90, 24);
        this.getContentPane().add(btn_edit);
        btn_edit.addActionListener(this);
        
        btn_delete.setFont(new Font("Gill Sans MT", Font.PLAIN,14));
        btn_delete.setText("Delete");
        btn_delete.setBounds(400, 200, 90, 24);
        this.getContentPane().add(btn_delete);
        btn_delete.addActionListener(this);
	
        btn_clear.setFont(new Font("Gill Sans MT", Font.PLAIN,14));
        btn_clear.setText("Clear");
        btn_clear.setBounds(520, 200, 90, 24);
        this.getContentPane().add(btn_clear);
        btn_clear.addActionListener(this);
	
        btn_logout.setFont(new Font("Gill Sans MT", Font.PLAIN,14));
        btn_logout.setText("Logout");
        btn_logout.setBounds(30, 20, 90, 24);
        this.getContentPane().add(btn_logout);
        btn_logout.addActionListener(this);
        
        lbl_fName.setFont(new Font("georgia", Font.BOLD,14));
        lbl_fName.setText("Welcome, Belvin Shandy Aurora.");
        lbl_fName.setBounds(490, 20, 300, 22);
        this.getContentPane().add(lbl_fName);
	
        lbl_search.setFont(new Font("georgia", Font.BOLD,14));
        lbl_search.setText("Search : ");
        lbl_search.setBounds(30, 260, 300, 22);
        this.getContentPane().add(lbl_search);

        txt_search.setFont(new Font("georgia", Font.PLAIN, 14));
        txt_search.setText("");
        txt_search.setBounds(170, 260, 200, 28);
        this.getContentPane().add(txt_search);
        
        btn_search.setFont(new Font("Gill Sans MT", Font.PLAIN,14));
        btn_search.setText("Search");
        btn_search.setBounds(400, 260, 90, 24);
        this.getContentPane().add(btn_search);
        btn_search.addActionListener(this);
        
        btn_refresh.setFont(new Font("Gill Sans MT", Font.PLAIN,14));
        btn_refresh.setText("Refresh");
        btn_refresh.setBounds(520, 260, 90, 24);
        this.getContentPane().add(btn_refresh);
        btn_refresh.addActionListener(this);
	
        String [] kolom = {"Product Name", "Category", "Stock", "Price"};

        defaultTableModel = new DefaultTableModel(kolom, 0);
        tb_manage = new JTable(defaultTableModel);
        spane = new JScrollPane(tb_manage);
        spane.setBounds(30,320,700,250);
        this.getContentPane().add(spane);
        
        tb_manage.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                get_data();
            }
        });
	
        show_data();
}
    
    
    public void find_data(String str1){
        List data = new Product().find_data(str1);
        String[] str = (String[]) data.toArray(new String[0]);
        
        for(int i=0;i<str.length;i+=4){
            String[] df = {str[i], str[i+1], str[i+2], str[i+3]};
            defaultTableModel.addRow(df);
        }
    }
    
    public void reset_table(){
        defaultTableModel.setRowCount(0);
    }
    
    public void refresh(){
        reset_table();
        show_data();
    }
    
    public void get_data(){
        int selectedRow = tb_manage.getSelectedRow();
        
        name = tb_manage.getValueAt(selectedRow,0).toString();
        category = tb_manage.getValueAt(selectedRow,1).toString();
        stock = tb_manage.getValueAt(selectedRow,2).toString();
        price = tb_manage.getValueAt(selectedRow,3).toString();
        
        txt_productName.setText(name);
        txt_productName.setEditable(false);
        cb_category.setSelectedItem(category);
        txt_stock.setText(stock);
        txt_price.setText(price);
    }
    
    public void show_data(){
        List data = new Product().show_data();
        String[] str = (String[])data.toArray(new String[0]);
        
        for(int i=0;i<str.length;i+=4){
            String[] df = {str[i], str[i+1], str[i+2], str[i+3]};
            defaultTableModel.addRow(df);
        }
     }
    
    public void set_data(){
        name = txt_productName.getText().trim();
        category = cb_category.getSelectedItem().toString();
        stock = txt_stock.getText().trim();
        price = txt_price.getText().trim();
    }
    
	public String cek_kosong() {
        String hasil;
        if(txt_productName.getText().trim().equals("")) {
            hasil = "Please enter product name.";
        }
        
        else if(txt_stock.getText().trim().equals("")){
            hasil = "Please enter your amount.";
        }
        
        else if(txt_price.getText().trim().equals("")){
            hasil = "Please enter your price.";
        }
        
        
        else if (cb_category.getSelectedIndex() == -1) {
            hasil = "Please enter category.";
        } 
        
        else{
            hasil = "Valid.";
        }

        return hasil;
    }
        
        public void reset(){
            txt_productName.setText("");
	    txt_stock.setText("");
	    txt_price.setText("");
	    cb_category.setSelectedItem(null);
        }
        
	@Override
	public void actionPerformed(ActionEvent e) {
		  if(e.getSource().equals(btn_add)) {
	            String cek = cek_kosong();

	            if(cek.equals("Valid.")) {
                        set_data();
                        String save = new Product().add_data(name, category, stock, price);
	                JOptionPane.showMessageDialog(null,"Item has been added.");
                        refresh();
                        reset();
	            } else {
	                JOptionPane.showMessageDialog(null, cek);
	            }
	            
	         } else if(e.getSource().equals(btn_clear)) {
                     reset();
                     txt_productName.setEditable(true);
	        }else if(e.getSource().equals(btn_edit)){
                    String cek = cek_kosong();
                    
                    if(cek.equals("Valid.")){
                        set_data();
                        String save = new Product().edit_data(name, category, stock, price);
                        JOptionPane.showMessageDialog(null, "Item has been edited");
                        refresh();
                        reset();
                    }else{
                        JOptionPane.showMessageDialog(null, cek);
                    }
                }else if(e.getSource().equals(btn_search)){
                   if(!txt_search.getText().equals("")){
                       reset_table();
                       find_data(txt_search.getText().toString().trim());
                   }else{
                       JOptionPane.showMessageDialog(null, "Input product name");
                   }
                }else if(e.getSource().equals(btn_delete)){
                    String cek = cek_kosong();
                    
                    if(cek.equals("Valid.")){
                        set_data();
                        String save = new Product().delete_data(name);
                        JOptionPane.showMessageDialog(null, save);
                        refresh();
                        reset();
                    }else{
                        JOptionPane.showMessageDialog(null, cek);
                    }
                }else if(e.getSource().equals(btn_logout)){
                    Interface_LoginAdmin ila = new Interface_LoginAdmin();
                    JOptionPane.showMessageDialog(null, "Logging out...");
                    ila.setVisible(true);
                    ila.pack();
                    ila.setLocationRelativeTo(null);
                    ila.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                }else if(e.getSource().equals(btn_refresh)){
                    txt_search.setText("");
                    refresh();
                }
	}
	
	public static void main(String[] args){
    	ManageProduct a = new ManageProduct();
        a.setSize(780,650);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	a.setLocationRelativeTo(null);
        a.setResizable(false);
        a.setVisible(true);
    }
	
	
}
