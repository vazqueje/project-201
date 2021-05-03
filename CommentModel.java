import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class CommentModel extends AbstractTableModel{
	private String[] columns;
	private Object[][] rows;

	/**
	 * Empty Constructor for a CommentModel
	 */
	public CommentModel(){}
	
	/**
	 * Constructor for commentmodel with a 2d array of comments and an array of column names
	 * @param data
	 * @param columnName
	 */
	public CommentModel(Object[][] data, String[] columnName){

		this.rows = data;
		this.columns = columnName;
	}
	
	/**
	 * Method to get class for object at a certain column
	 */
    public Class getColumnClass(int column){

        if(column == 0){
            return String.class;
        }
        else{
            return getValueAt(0,column).getClass();
        }
    }
    
    /**
     * Getter method for number of rows in table
     */
    public int getRowCount() {
        return this.rows.length;
       }
    /**
     * Getter method for total number of columns in the table
     */
       public int getColumnCount() {
        return this.columns.length;
       }

       /**
        * Getter method for value at a specific row and column
        */
       public Object getValueAt(int rowIndex, int columnIndex) {
       
       return this.rows[rowIndex][columnIndex];
       }
       /**
        * Getter method for name of column
        */
       public String getColumnName(int col){
           return this.columns[col];
       }
       /**
        * Refresh method to refresh a table of comments
        * @param objects arraylist of comment objects
        */
       public void refresh(Object[][] objects){
    	    //make the changes to the table, then call fireTableChanged
    	    fireTableChanged(null);
    	}
}
