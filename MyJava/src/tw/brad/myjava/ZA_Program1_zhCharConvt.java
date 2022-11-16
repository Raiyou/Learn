package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONArray;
import org.json.JSONObject;

public class ZA_Program1_zhCharConvt extends JFrame {

	private JButton open, saveas, updatedic, transt2s, transs2t, clear;
	private JTextArea textinput, textoutput;
	private Dimension dmain, dcenter, dtext, dtextinput, dtextoutput;
	
	public ZA_Program1_zhCharConvt() {
		super("zhCharConvt");

		open = new JButton("Open");
		saveas = new JButton("SaveAs");
		updatedic = new JButton("UpdateDic");
		transt2s = new JButton("T2S");
		transs2t = new JButton("S2T");
		clear = new JButton("Clear");
		textinput = new JTextArea();
		textoutput = new JTextArea();
		textinput.setLineWrap(true);	// 自動換行
		textoutput.setLineWrap(true);	// 自動換行
		
		
		setLayout(new BorderLayout());

		JPanel jplTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jplCenter = new JPanel();
		JScrollPane jspLeft = new JScrollPane(textinput);	
		JScrollPane jspRight = new JScrollPane(textoutput);

		jplTop.add(open); jplTop.add(saveas); jplTop.add(updatedic);
		jplCenter.add(transt2s); jplCenter.add(transs2t); jplCenter.add(clear);
		
		add(jplTop, BorderLayout.NORTH);
		add(jspLeft, BorderLayout.WEST);
		add(jspRight, BorderLayout.EAST);
		add(jplCenter, BorderLayout.CENTER);


		// 設定視窗大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		dmain = toolkit.getScreenSize();
		setSize((int)(dmain.width/2.0), (int)(dmain.height/1.5));
		// 設定布局區塊大小
		dcenter = new Dimension(100, 0);
		dtext = new Dimension((this.getWidth()-dcenter.width)/2, 0);
		jspLeft.setPreferredSize(dtext);
		jspRight.setPreferredSize(dtext);
		jplCenter.setPreferredSize(dcenter);		


		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setListener();
	}

	public String transChar(String sql) throws Exception {
		Connection conn = 
				DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/eeit53", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		HashMap<String, String> hmap = new HashMap<>();
		while (rs.next()) {
			String str1 = rs.getString("String1");
			String str2 = rs.getString("String2");
			hmap.put(str1, str2);
		}	
		stmt.close();
		rs.close();
		conn.close();
		
		String strinput = textinput.getText();
		StringBuffer sb = new StringBuffer();
		String[] strary = strinput.split(""); 
		for (int i=0; i<strary.length; i++) {
			String temp = hmap.get(strary[i]);
			if (temp != null) {
				strary[i] = temp;
			}
			sb.append(strary[i]);
		}
		return sb.toString();
	}
	
	public void fileOpenDialog() throws Exception{
		JFileChooser fileChooser = new JFileChooser();	
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);	
		fileChooser.setFileFilter(new FileNameExtensionFilter("Text File", "txt", "log", "csv"));
		
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			FileInputStream fin = new FileInputStream(file);
			BufferedInputStream bin = new BufferedInputStream(fin);
			byte[] buf = new byte[(int)file.length()];
			bin.read(buf);
			bin.close();			
			// 輸出字串至TextAreaInput
			textinput.setText(new String(buf));
		}
	}
	
	public void fileSaveDialog() throws Exception{
		JFileChooser fileChooser = new JFileChooser();	
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);	
		fileChooser.setFileFilter(new FileNameExtensionFilter("Text File", "txt", "log", "csv"));
		
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			// 輸出TextAreaOutput字串至檔案
			FileOutputStream fout = new FileOutputStream(file);
			fout.write(textoutput.getText().getBytes());
			fout.flush();
			fout.close();
		}
	}
	
	public String getJSONString(String jsonsrc) throws Exception {
		URL url = new URL(jsonsrc); 
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.connect();
		StringBuffer sb = new StringBuffer();
		try(BufferedReader reader = new BufferedReader(
				new InputStreamReader(conn.getInputStream()))) {
				String strappd;
				while ((strappd = reader.readLine()) != null) {
					sb.append(strappd);
				}
		}
		return sb.toString();
	}
		
	public void parseJSON(String json, String sqldel, String sqlinsert) throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eeit53", "root", "root");
		Statement stmt = conn.createStatement();
		stmt.execute(sqldel);
		PreparedStatement pstmt = conn.prepareStatement(sqlinsert);
		
		JSONArray jsarry = new JSONArray(json);
		for (int i=0; i<jsarry.length(); i++) {
			JSONObject row = jsarry.getJSONObject(i);
			pstmt.setString(1, row.getString("i"));
			pstmt.setString(2, row.getString("o"));
			pstmt.executeUpdate();
		}
		pstmt.close();
		conn.close();
	}	

	
	public void setListener() {
		transt2s.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sqlTransT2S = "SELECT String1, String2 FROM zhConvtT2S";
				try {
					textoutput.setText(transChar(sqlTransT2S));
				} catch (Exception transCharT2SErr) {
					System.out.println(transCharT2SErr);
				}
			}
		});
		transs2t.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sqlTransS2T = "SELECT String1, String2 FROM zhConvtS2T";
				try {
					textoutput.setText(transChar(sqlTransS2T));
				} catch (Exception transCharS2TErr) {
					System.out.println(transCharS2TErr);
				}
			}
		});
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textinput.setText("");
				textoutput.setText("");
			}
		});
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					fileOpenDialog();
				} catch (Exception openFileErr) {
					System.out.println(openFileErr);
				}
			}
		});
		saveas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					fileSaveDialog();
				} catch (Exception saveFileErr) {
					System.out.println(saveFileErr);
				}	
			}
		});
		updatedic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				try {
					String jsonT2S = "https://raw.githubusercontent.com/kfcd/fanjian/master/dist/json/fanjian.json";
					String jsonS2T = "https://raw.githubusercontent.com/kfcd/fanjian/master/dist/json/jianfan.json";
					String sqldelT2S = "DELETE FROM zhConvtT2S";
					String sqldelS2T = "DELETE FROM zhConvtS2T";
					String sqlinsertT2S = "INSERT INTO zhConvtT2S (String1,String2) VALUES (?,?)";
					String sqlinsertS2T = "INSERT INTO zhConvtS2T (String1,String2) VALUES (?,?)";
					parseJSON(getJSONString(jsonT2S), sqldelT2S, sqlinsertT2S);
					parseJSON(getJSONString(jsonS2T), sqldelS2T, sqlinsertS2T);
							
				} catch (Exception updatedicBtn) {
					System.out.println(updatedicBtn);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ZA_Program1_zhCharConvt();


	}

}




/*Simp -> Trad
			
			[v] fieldLeft(Content) -> fieldRight(Result)
			string to db <-> db to string
			-> built db first
			
		
			
			custom word : db.add/delete
			
			讀取 -> 字元逐一比對資料庫 -> 置換 -> 輸出
			
			讀取資料庫 col1 -> 判斷符合輸入字元 -> 返回資料庫 col2
			
			
			[v] 文字框1 -> 文字框2
			
			TWid -> 判斷式
			Brad40 -> LinkedList ???
			Brad42 -> HashMap
			讀取資料庫 -> 至HashMap
		
			
https://raw.githubusercontent.com/kfcd/fanjian/master/dist/json/fanjian.json
https://raw.githubusercontent.com/kfcd/fanjian/master/dist/json/jianfan.json	
		
			
						FileInputStream fin = new FileInputStream("D:/JavaLearn/dir1/coffee.jpg");
			BufferedInputStream bin = new BufferedInputStream(fin);	// 串流用，效能較好
			
			int len; byte[] buf = new byte[8*1024];
			while ( (len = bin.read(buf)) != -1) {	// 客戶端傳檔
				bout.write(buf, 0, len);
				
			}	
				bin.close();
				
				bout.flush();
				bout.close();
			
			
			
			
			
						if (len > 0) {
				FileOutputStream fout = new FileOutputStream("D:/JavaLearn/dir1/" + ip + ".jpg");
				BufferedOutputStream bout = new BufferedOutputStream(fout);
				bout.write(buf, 0, len);
				
				bout.flush();
				bout.close();
			}
			
			
			
*/			
			

