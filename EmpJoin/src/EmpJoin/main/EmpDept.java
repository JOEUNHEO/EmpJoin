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
		
		//테이블 칼럼 명을 String[] 에 담는다.
		String[] colNames = {"사원번호", "이름", "부서명", "부서위치"};
		//기본 테이블 모델 객체 생성
		model = new DefaultTableModel(colNames,0);
		//JTable 객체 생성
		JTable table = new JTable();
		//테이블에 모델 연결
		table.setModel(model);
		
		//스크롤 가능한 페널 객체
		JScrollPane panel = new JScrollPane(table);
		//페널을 프레임의 가운데에 배치
		add(panel, BorderLayout.CENTER);
		
		//프레임의 위치와 크기 설정
		setBounds(200, 200, 800, 500);
		//보이도록 설정
		setVisible(true);
		//프레임을 닫았을 때 프로세스가 완전히 종료되도록 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		displayJoin();
	}
	
	public void displayJoin() {
		//회원 정보를 읽어온다.
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
