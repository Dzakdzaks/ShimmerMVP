package id.co.dzaky.shimmermvp.model.member;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseMember{

	@SerializedName("team_kiii")
	private List<TeamKiiiItem> teamKiii;

	@SerializedName("team_j")
	private List<TeamJItem> teamJ;

	@SerializedName("team_t")
	private List<TeamTItem> teamT;

	public void setTeamKiii(List<TeamKiiiItem> teamKiii){
		this.teamKiii = teamKiii;
	}

	public List<TeamKiiiItem> getTeamKiii(){
		return teamKiii;
	}

	public void setTeamJ(List<TeamJItem> teamJ){
		this.teamJ = teamJ;
	}

	public List<TeamJItem> getTeamJ(){
		return teamJ;
	}

	public void setTeamT(List<TeamTItem> teamT){
		this.teamT = teamT;
	}

	public List<TeamTItem> getTeamT(){
		return teamT;
	}

	@Override
 	public String toString(){
		return 
			"ResponseMember{" + 
			"team_kiii = '" + teamKiii + '\'' + 
			",team_j = '" + teamJ + '\'' + 
			",team_t = '" + teamT + '\'' + 
			"}";
		}
}