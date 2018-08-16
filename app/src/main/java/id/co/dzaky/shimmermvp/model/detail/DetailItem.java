package id.co.dzaky.shimmermvp.model.detail;

import com.google.gson.annotations.SerializedName;

public class DetailItem{

	@SerializedName("birthday")
	private String birthday;

	@SerializedName("image_link")
	private String imageLink;

	@SerializedName("twitter_link")
	private String twitterLink;

	@SerializedName("twitter_username")
	private String twitterUsername;

	@SerializedName("video_link")
	private String videoLink;

	@SerializedName("horoskop")
	private String horoskop;

	@SerializedName("surname")
	private String surname;

	@SerializedName("blood_type")
	private String bloodType;

	@SerializedName("nickname")
	private String nickname;

	@SerializedName("instagram_link")
	private String instagramLink;

	@SerializedName("id")
	private String id;

	@SerializedName("instagram_username")
	private String instagramUsername;

	@SerializedName("height")
	private String height;

	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

	public String getBirthday(){
		return birthday;
	}

	public void setImageLink(String imageLink){
		this.imageLink = imageLink;
	}

	public String getImageLink(){
		return imageLink;
	}

	public void setTwitterLink(String twitterLink){
		this.twitterLink = twitterLink;
	}

	public String getTwitterLink(){
		return twitterLink;
	}

	public void setTwitterUsername(String twitterUsername){
		this.twitterUsername = twitterUsername;
	}

	public String getTwitterUsername(){
		return twitterUsername;
	}

	public void setVideoLink(String videoLink){
		this.videoLink = videoLink;
	}

	public String getVideoLink(){
		return videoLink;
	}

	public void setHoroskop(String horoskop){
		this.horoskop = horoskop;
	}

	public String getHoroskop(){
		return horoskop;
	}

	public void setSurname(String surname){
		this.surname = surname;
	}

	public String getSurname(){
		return surname;
	}

	public void setBloodType(String bloodType){
		this.bloodType = bloodType;
	}

	public String getBloodType(){
		return bloodType;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public String getNickname(){
		return nickname;
	}

	public void setInstagramLink(String instagramLink){
		this.instagramLink = instagramLink;
	}

	public String getInstagramLink(){
		return instagramLink;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setInstagramUsername(String instagramUsername){
		this.instagramUsername = instagramUsername;
	}

	public String getInstagramUsername(){
		return instagramUsername;
	}

	public void setHeight(String height){
		this.height = height;
	}

	public String getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"DetailItem{" + 
			"birthday = '" + birthday + '\'' + 
			",image_link = '" + imageLink + '\'' + 
			",twitter_link = '" + twitterLink + '\'' + 
			",twitter_username = '" + twitterUsername + '\'' + 
			",video_link = '" + videoLink + '\'' + 
			",horoskop = '" + horoskop + '\'' + 
			",surname = '" + surname + '\'' + 
			",blood_type = '" + bloodType + '\'' + 
			",nickname = '" + nickname + '\'' + 
			",instagram_link = '" + instagramLink + '\'' + 
			",id = '" + id + '\'' + 
			",instagram_username = '" + instagramUsername + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}