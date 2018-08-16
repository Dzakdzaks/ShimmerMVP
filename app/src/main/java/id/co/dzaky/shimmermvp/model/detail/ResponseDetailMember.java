package id.co.dzaky.shimmermvp.model.detail;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDetailMember{

	@SerializedName("detail")
	private List<DetailItem> detail;

	public void setDetail(List<DetailItem> detail){
		this.detail = detail;
	}

	public List<DetailItem> getDetail(){
		return detail;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDetailMember{" + 
			"detail = '" + detail + '\'' + 
			"}";
		}
}