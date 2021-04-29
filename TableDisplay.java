import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TableDisplay extends JPanel {
    private JLabel imageLabel;
    private JScrollPane sp;
    private JTable table;
    private User user;

    /**
     * default constructor: Initializes table components and populates JTable with default values i.e. the whole catalog
     * @param user : the user currently using the application
     */
    public TableDisplay(User user){
        this.setBackground(Color.white); //current theme
        this.user = user;
        initialize();
        populateTable();
    }

    /**
     * Constructor that redraws the table based on a search query
     * @param searchQuery : an a rendered search ArrayList from the search Class
     */
    public TableDisplay(ArrayList<Entry> searchQuery){
        initialize();
        searchTable(searchQuery);
    }

    /**
     * Populates the table for default main page, includes all entries
     */
    public void populateTable(){
        EntryRenderer er = null;
        if(user == null){
            er = new EntryRenderer();
        }else{
            er = new EntryRenderer(user);
        }

        ArrayList<Entry> catalogList = er.fillTable();

        String[] header = {"Cover","Name","Description","Genre","Developer","publishDate","ESRB"}; //column header for table
        Object[][] rows = new Object[catalogList.size()][7]; //Calculate number of rows necessary for the 7 columns

        //fills in table rows with data
        for(int i = 0; i < catalogList.size(); i++){
            rows[i][0] = catalogList.get(i).getCover();
            if(catalogList.get(i).getCover() != null){
                Image image = catalogList.get(i).getCover().getScaledInstance(220, 284, BufferedImage.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image.getScaledInstance(220, 284, Image.SCALE_SMOOTH) );

                rows[i][0] = icon;
            }
            else{
                rows[i][0] = null;
            }
            rows[i][1] = catalogList.get(i).getName();
            rows[i][2] = catalogList.get(i).getDescription();
            rows[i][3] = catalogList.get(i).getGenre();
            rows[i][4] = catalogList.get(i).getDeveloper();
            rows[i][5] = catalogList.get(i).getPublishDate();
            rows[i][6] = catalogList.get(i).getEsrbRating();
        }

        //Set table properties: height, width, color, font etc...
        TableModel model = new TableModel(rows, header);
        table.setModel(model);
        table.setRowHeight(300);
        table.setPreferredScrollableViewportSize(new Dimension(450,450));
        table.setFillsViewportHeight(true);
        table.setRowMargin(50);
        table.setGridColor(new Color(25, 24, 26));
        JTableHeader headerLabels = table.getTableHeader();
        headerLabels.setBackground(Color.white);
        headerLabels.setBackground(new Color(25, 24, 26));
        headerLabels.setBorder(new LineBorder(new Color(25, 24, 26), 10));
        headerLabels.setForeground(Color.white);
        headerLabels.setPreferredSize(
                new Dimension(WIDTH,150)
        );

        //import and create font
        try {
            Font tableFont = Font.createFont(Font.TRUETYPE_FONT, new File("Aileron-Thin-webfont.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(tableFont);
            tableFont = tableFont.deriveFont(20f);
            Font headerFont = tableFont.deriveFont(30f);

            table.setFont(tableFont);
            table.getTableHeader().setFont(headerFont);

        } catch (IOException |FontFormatException e) {
            e.printStackTrace();
        }

    }

    /**
     * Populates table based on search query
     * @param list : the rendered search query result set given by an instance of the Search class
     */
    public void searchTable(ArrayList<Entry> list){
        String[] header = {"Cover","Name","Description","Genre","Developer","publishDate","esrbRating"};
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
            System.out.println(rows[i][1]);
            rows[i][2] = list.get(i).getDescription();
            rows[i][3] = list.get(i).getGenre();
            rows[i][4] = list.get(i).getDeveloper();
            rows[i][5] = list.get(i).getPublishDate();
            rows[i][6] = list.get(i).getEsrbRating();
        }

        //Set table properties: height, width, color, font etc...
        TableModel model = new TableModel(rows, header);
        table.setModel(model);
        table.setRowHeight(300);
        table.setPreferredScrollableViewportSize(new Dimension(450,450));
        table.setFillsViewportHeight(true);
        table.setRowMargin(50);
        table.setGridColor(Color.white);
        JTableHeader headerLabels = table.getTableHeader();
        headerLabels.setBackground(Color.white);
        headerLabels.setBackground(new Color(25, 24, 26));
        headerLabels.setBorder(new LineBorder(new Color(25, 24, 26), 10));
        headerLabels.setForeground(Color.white);
        headerLabels.setPreferredSize(
                new Dimension(WIDTH,150)
        );

        //set table font
        try {
            Font tableFont = Font.createFont(Font.TRUETYPE_FONT, new File("Aileron-Thin-webfont.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(tableFont);
            tableFont = tableFont.deriveFont(20f);
            Font headerFont = tableFont.deriveFont(30f);

            table.setFont(tableFont);
            table.getTableHeader().setFont(headerFont);
        } catch (IOException|FontFormatException e) {
            e.printStackTrace();
        }
        table.repaint();
    }

    /**
     * Initializes table components to prepare for data to be populate it.
     */
    public void initialize() {
        sp = new JScrollPane();
        table = new JTable();
        imageLabel = new JLabel();

        //create default table model, placeholder before we set it to custom AbstractTableModel
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String[] {
                        "Header 1", "Header 2", "Header 3", "Header 4", "Header 5", "Header 6", "Header 7"
                }
        ));

        //set scroll pane to area of table
        sp.setViewportView(table);
        sp.updateUI();

        //create layout for table panel
        GroupLayout tableLayout = new GroupLayout(this);
        setLayout(tableLayout);

        //set spacing and aesthetics of table to fit image
        tableLayout.setHorizontalGroup(
                tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tableLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sp)
                                .addContainerGap())
                        .addGroup(tableLayout.createSequentialGroup()
                                .addGap(248, 248, 248)
                                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(261, Short.MAX_VALUE))
        );
        tableLayout.setVerticalGroup(
                tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tableLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

}



