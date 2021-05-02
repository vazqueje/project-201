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

public class CommentDisplay extends JPanel {
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    
    
    
    public CommentDisplay(CommentSection cs) {
    	initComponents();
    	populateComments(cs);
    	
    }
    
    
    public void populateComments(CommentSection cs){
        String[] columnName = {"Comments","Description"};
        Object[][] rows = new Object[cs.getmaxpid()][2];
        for ( int i = 0; i < cs.getmaxpid(); i++) {
			rows[i][0] = cs.getComment(i).getTitle();
			rows[i][1] = cs.getComment(i).getDescription();
		}
        
        
        CommentModel model = new CommentModel(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(100);
        jTable1.setPreferredScrollableViewportSize(new Dimension(450,450));
        jTable1.setFillsViewportHeight(true);
        jTable1.setRowMargin(50);
        jTable1.setGridColor(Color.black);
        jTable1.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 18));
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(Color.white);
        header.setBackground(new Color(25, 24, 26));
        header.setBorder(new LineBorder(new Color(25, 24, 26), 10));
        header.setForeground(Color.white);
        header.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 25));
        header.setPreferredSize(
        	     new Dimension(WIDTH,150)
        		);
     
  
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
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

        
    }
    
    public JTable getTable(){
    	return jTable1;
    }
    
    
    
}
