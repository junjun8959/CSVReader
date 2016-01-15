//import java.awt.*;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import com.gis.jun.*;

import static com.gis.jun.MyFrame.*;

public class CSVRead {
     public static void main(String[] args)throws Exception {	
    	 MyFrame myFrame = new MyFrame();
    	JTextArea jta = new JTextArea(3, 35);
    	jta.setBackground(Color.BLACK);
    	jta.setForeground(Color.GREEN);
    	jta.setSelectedTextColor(Color.RED);
    	jta.setKeymap(null);
    	//jta.paint(Color.RED);
 		jta.setLineWrap(true);
 		JScrollPane scr = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
 											   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
 		myFrame.add(scr);
    	launchFrame(myFrame, 380, 800, "CSVReader3.0");
    	boolean flag = false;
			try{
				int rowNum = 0;				
				getMacAddr macAddr = new getMacAddr();
				String localMacAddr = macAddr.getMacAddr();
				 
				while(true) {
				CsvUtil util = new CsvUtil("/Grape/Statistics/GrapeModule_MODULE_2.0.5a5__"+ localMacAddr + ".csv");
				//String s = "//Grape/AutoReport/" + util.getString(rowNum-1, 0) + ".txt";
				
					if(rowNum != util.getRowNum()) {
							rowNum = util.getRowNum();
							Check check = new Check();
							//System.out.println(util.getString(rowNum - 1, 1));
							if(util.getString(rowNum-1, 1).equals("PASS")) {
								
								if(util.getColOfRowNum(rowNum-1) > 32 ) {
									
									String condition;
									String condition1 = util.getString(rowNum-1, 28);
									String condition2 = util.getString(rowNum-1, 29);
									String condition3 = util.getString(rowNum-1, 31);
									String condition4 = util.getString(rowNum-1, 13);
									boolean b = check.CheckMax(condition1, 4.25f);
									boolean c = check.CheckMin(condition2, -3.4f);
									boolean d = check.CheckMaxMin(condition3, 148f, 145f);
									boolean e = true;
									
									
									if(!b || !c || !d || !e) {
										
										if(flag == false)
											flag = true;
										else
											jta.append("\n");
										// Delete SFC files
										String s = "//Grape/AutoReport/" + util.getString(rowNum-1, 0) + ".txt";
										DeleteSFC del = new DeleteSFC();
										del.Delete(s);
										
	
										if(b == false)
											condition = condition1;
										else if (c == false)
											condition = condition2;
										else if(d == false)
											condition = condition3;
										else 
											condition = condition4;
										
										jta.append("SN:" + util.getString(rowNum-1, 0) 
												+ " Value:" + condition);
										jta.setCaretPosition(jta.getText().length());								
										jta.setSelectionStart(jta.getLineStartOffset(jta.getLineCount()-1));
										jta.setSelectionEnd(jta.getText().length());
										JOptionPane.showMessageDialog(null,( "SN:" + util.getString(rowNum-1, 0)
												+ " \nValue:" + condition));
										
									} else {
										//jta.getSelectedText();
										jta.setCaretPosition(jta.getText().length());									
									}
							} else {
								JOptionPane.showMessageDialog(null, "指定读取数据的位置为空，请再测试一次！");
							}
						}
				}
					Thread.sleep(1000);					
				}			
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"监控退出！！\n" + e);
				myFrame.setVisible(false);
				System.exit(-1);
			
			  }
     }
}