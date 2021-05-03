import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
	private String[] columns;
	private Object[][] rows;
	
	/**
	 * Empty Constructor for table model
	 */
	public TableModel(){}
	
	/**
	 * Constructor for table model that takes a 2d array and a 1d array
	 * @param data 2d array of data
	 * @param columnName 1d array of names of columns
	 */
	public TableModel(Object[][] data, String[] columnName){

		this.rows = data;
		this.columns = columnName;
	}
	
	/**
	 * Getter method for Class of the object in a specific column
	 */
    public Class getColumnClass(int column){

        if(column == 0){
            return Icon.class;
        }
        else{
            return getValueAt(0,column).getClass();
        }
    }
    
    /**
     * Getter method for number of rows in array
     */
    public int getRowCount() {
        return this.rows.length;
       }
    /**
     * Getter method for number of columns in array
     */
       public int getColumnCount() {
        return this.columns.length;
       }

       /**
        * Getter method for an object at a specific row and column
        */
       public Object getValueAt(int rowIndex, int columnIndex) {
       
       return this.rows[rowIndex][columnIndex];
       }
       /**
        * Getter method for a columns name
        */
       public String getColumnName(int col){
           return this.columns[col];
       }
       /**
        * refresh method refreshes the objects within the table
        * @param objects 2d array of objects 
        */
       public void refresh(Object[][] objects){
    	    //make the changes to the table, then call fireTableChanged
    	    fireTableChanged(null);
    	}
}
