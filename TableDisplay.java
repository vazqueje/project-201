import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TableDisplay extends JPanel {
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    
    public TableDisplay() {
    	this.setBackground(Color.white);
        initComponents();
        populateJTable();
    }
    
    public TableDisplay(ArrayList<Entry> list) {
    	initComponents();
    	searchJTable(list);
    	
    }
    
    public void populateJTable(){
    	System.out.println("Heres");
        EntryRenderer er = new EntryRenderer();
        ArrayList<Entry> list = er.fillTable();
        
        String[] columnName = {"Cover","Name","Description","Genre","Developer","publishDate","esrbRating"};
        Object[][] rows = new Object[list.size()][7];
        for(int i = 0; i < list.size(); i++){
            rows[i][0] = list.get(i).getCover();
            if(list.get(i).getCover() != null){
            	Image image = list.get(i).getCover().getScaledInstance(220, 284, BufferedImage.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image.getScaledInstance(220, 284, Image.SCALE_SMOOTH) );   
                   
               rows[i][0] = icon;
               }
               else{
                   rows[i][0] = null;
               }
            rows[i][1] = list.get(i).getName();
            rows[i][2] = list.get(i).getDescription();
            rows[i][3] = list.get(i).getGenre();
            rows[i][4] = list.get(i).getDeveloper();
            rows[i][5] = list.get(i).getPublishDate();
            rows[i][6] = list.get(i).getEsrbRating();
        }
        
        TableModel model = new TableModel(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(300);
        jTable1.setPreferredScrollableViewportSize(new Dimension(450,450));
        jTable1.setFillsViewportHeight(true);
        jTable1.setRowMargin(50);
        jTable1.setGridColor(new Color(25, 24, 26));
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(Color.white);
        header.setBackground(new Color(25, 24, 26));
        header.setBorder(new LineBorder(new Color(25, 24, 26), 10));
        header.setForeground(Color.white);
        header.setPreferredSize(
        	     new Dimension(WIDTH,150)
        		);
       
        try {
		     //Returned font is of pt size 1
		     Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("Aileron-Thin-webfont.ttf"));
		     GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     genv.registerFont(font2);
		     font2 = font2.deriveFont(20f);
		     Font font3 = font2.deriveFont(30f);
		     
		     jTable1.setFont(font2);
		     jTable1.getTableHeader().setFont(font3);

		} catch (IOException|FontFormatException e) {
		     // Handle exception
		}
    }
    
    public void searchJTable(ArrayList<Entry> list){
        String[] columnName = {"Cover","Name","Description","Genre","Developer","publishDate","esrbRating"};
        Object[][] rows = new Object[list.size()][7];
        for(int i = 0; i < list.size(); i++){
            rows[i][0] = list.get(i).getCover();
            if(list.get(i).getCover() != null){
                Image image = list.get(i).getCover().getScaledInstance(220, 284, BufferedImage.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image.getScaledInstance(220, 284, Image.SCALE_SMOOTH) );  
                
                //ImageIcon image = list.get(i).getCover().getBufferedImage()
                //.getScaledInstance(220, 284, Image.SCALE_SMOOTH) );   
                   
               rows[i][0] = icon;
               }
               else{
                   rows[i][0] = null;
               }
            rows[i][1] = list.get(i).getName();
            System.out.println(rows[i][1]);
            rows[i][2] = list.get(i).getDescription();
            rows[i][3] = list.get(i).getGenre();
            rows[i][4] = list.get(i).getDeveloper();
            rows[i][5] = list.get(i).getPublishDate();
            rows[i][6] = list.get(i).getEsrbRating();
        }
        
        TableModel model = new TableModel(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(300);
        jTable1.setPreferredScrollableViewportSize(new Dimension(450,450));
        jTable1.setFillsViewportHeight(true);
        jTable1.setRowMargin(50);
        jTable1.setGridColor(Color.white);
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(Color.white);
        header.setBackground(new Color(25, 24, 26));
        header.setBorder(new LineBorder(new Color(25, 24, 26), 10));
        header.setForeground(Color.white);
        header.setPreferredSize(
        	     new Dimension(WIDTH,150)
        		);
     
        try {
		     //Returned font is of pt size 1
        	 
		     Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("Aileron-Thin-webfont.ttf"));
		     GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     genv.registerFont(font2);
		     font2 = font2.deriveFont(20f);
		     

		     jTable1.setFont(font2);
		     jTable1.getTableHeader().setFont(font2);

		} catch (IOException|FontFormatException e) {
		     // Handle exception
		}
        jTable1.repaint();
        //model.fireTableDataChanged();
        System.out.println(jTable1.getRowCount());
    }
    
    private void initComponents() {
    	System.out.println("Initialized");
    	
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        System.out.println(jTable1.getRowCount());
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("test");
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.updateUI();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

        
    }
    
    
    
}
