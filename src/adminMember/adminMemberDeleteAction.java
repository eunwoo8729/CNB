package adminMember;

import java.io.Reader;
import java.io.IOException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class adminMemberDeleteAction extends ActionSupport {

	public static Reader reader; // ���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API�� ����ϱ� ���� sqlMapper
											// ��ü.

	private adminMemberVO paramClass; // �Ķ���͸� ������ ��ü
	private adminMemberVO resultClass; // ���� ��� ���� ������ ��ü

	private int m_no; // ȸ����ȣ


public adminMemberDeleteAction() throws IOException {
	reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
	sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
	reader.close();
}

	public String execute() throws Exception {
		paramClass = new adminMemberVO();
		resultClass = new adminMemberVO();

		resultClass = (adminMemberVO) sqlMapper.queryForObject("admin.selectOne", getM_no());

		paramClass.setM_no(getM_no());

		sqlMapper.delete("admin.deleteBook", paramClass);

		return SUCCESS;
	}

	public adminMemberVO getParamClass() {
		return paramClass;
	}

	public adminMemberVO getResultClass() {
		return resultClass;
	}

	public int getM_no() {
		return m_no;
	}
	
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	
	public void setParamClass(adminMemberVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(adminMemberVO resultClass) {
		this.resultClass = resultClass;
	}


}
