package id.co.dzaky.shimmermvp.model.member;

import com.google.gson.annotations.SerializedName;

public class TeamTItem{

	@SerializedName("image")
	private String image;

	@SerializedName("surname")
	private String surname;

	@SerializedName("id")
	private int id;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setSurname(String surname){
		this.surname = surname;
	}

	public String getSurname(){
		return surname;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"TeamTItem{" + 
			"image = '" + image + '\'' + 
			",surname = '" + surname + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}