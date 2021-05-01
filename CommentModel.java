import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class CommentModel extends AbstractTableModel{
	private String[] columns;
	private Object[][] rows;

	public CommentModel(){}

	public CommentModel(Object[][] data, String[] columnName){

		this.rows = data;
		this.columns = columnName;
	}
	
	
    public Class getColumnClass(int column){

        if(column == 0){
            return String.class;
        }
        else{
            return getValueAt(0,column).getClass();
        }
    }
    
    public int getRowCount() {
        return this.rows.length;
       }

       public int getColumnCount() {
        return this.columns.length;
       }

       
       public Object getValueAt(int rowIndex, int columnIndex) {
       
       return this.rows[rowIndex][columnIndex];
       }
       public String getColumnName(int col){
           return this.columns[col];
       }
       
       public void refresh(Object[][] objects){
    	    //make the changes to the table, then call fireTableChanged
    	    fireTableChanged(null);
    	}
}
