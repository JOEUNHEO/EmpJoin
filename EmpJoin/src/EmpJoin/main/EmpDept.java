package EmpJoin.main;

import java.awt.BorderLayout;
import java.util.List;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import EmpJoin.dao.EmpjoinDao;
import EmpJoin.dto.EmpjoinDto;

public class EmpDept extends JFrame {
	DefaultTableModel model;
	
	public EmpDept() {
		initUI();
	}
	
	public void initUI() {
		
		setLayout(new BorderLayout());
		
		//���̺� Į�� ���� String[] �� ��´�.
		String[] colNames = {"�����ȣ", "�̸�", "�μ���", "�μ���ġ"};
		//�⺻ ���̺� �� ��ü ����
		model = new DefaultTableModel(colNames,0);
		//JTable ��ü ����
		JTable table = new JTable();
		//���̺� �� ����
		table.setModel(model);
		
		//��ũ�� ������ ��� ��ü
		JScrollPane panel = new JScrollPane(table);
		//����� �������� ����� ��ġ
		add(panel, BorderLayout.CENTER);
		
		//�������� ��ġ�� ũ�� ����
		setBounds(200, 200, 800, 500);
		//���̵��� ����
		setVisible(true);
		//�������� �ݾ��� �� ���μ����� ������ ����ǵ��� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		displayJoin();
	}
	
	public void displayJoin() {
		//ȸ�� ������ �о�´�.
		EmpjoinDao empjoinDao = EmpjoinDao.getInstance();
		List<EmpjoinDto> list = empjoinDao.getList();
		
		model.setRowCount(0);
		
		for(EmpjoinDto tmp:list) {
			Object[] rowData = {tmp.getEmpno(), tmp.getEname(), tmp.getDname(), tmp.getLoc()};
			model.addRow(rowData);
		}
	}
	
	public static void main(String[] args) {
		new EmpDept();
	}
	
}
