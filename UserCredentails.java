package utilities;

public class UserCredentails {
	
	private String id;
	private String CompanyId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyId() {
		return CompanyId;
	}

	public void setCompanyId(String companyId) {
		CompanyId = companyId;
	}

	public UserCredentails() throws Exception{
	}
	
	public UserCredentails(String CompanyId) {
		this.CompanyId=CompanyId;
	}
	
	

}
