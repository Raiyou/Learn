package tw.brad.myjava;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyFoodTable extends JTable  {
	private MyTableModel tableModel;
	private FoodDB foodDB;
	
	public MyFoodTable() throws Exception{
		
		foodDB = new FoodDB();
		foodDB.queryData("SELECT * FROM food");
//		System.out.println(foodDB.getRows());	// 檢查
		
		tableModel = new MyTableModel();
		setModel(tableModel);
		tableModel.setColumnIdentifiers(foodDB.getHeader());
		
	}
	
	public void delRow() {
		tableModel.removeRow(getSelectedRow());
		repaint();
//		System.out.printf("%s:\n" + getSelectedRow());	// 檢查
	}
	
	public void addRow() {
		tableModel.addRow(new String[0]); // 隨意指定陣列騙過編譯器
	}
	
	public void newsql() {
		try {
			foodDB.queryData("SELECT id, name, tel FROM food ORDER BY tel");
			tableModel.setColumnIdentifiers(foodDB.getHeader());
			repaint();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private class MyTableModel extends DefaultTableModel{

		@Override
		public int getRowCount() {
			return foodDB.getRows();
		}

		@Override
		public int getColumnCount() {
			return foodDB.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return foodDB.getData(row+1, column+1);
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			foodDB.setData(row+1, column+1, (String)aValue);
			System.out.printf("%d:%d\n", row, column);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column > 0;
		}

		@Override
		public void removeRow(int row) {
			foodDB.delData(row+1);
//			System.out.printf("removeRow: \n", row);
		}

		@Override
		public void addRow(Object[] rowData) {
			foodDB.addData();
		}
		
		
	}
	
}
