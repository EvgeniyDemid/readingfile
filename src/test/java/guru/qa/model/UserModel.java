package guru.qa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class UserModel {

	@SerializedName("page")
	@Expose
	private Integer page;
	@SerializedName("per_page")
	@Expose
	private Integer perPage;
	@SerializedName("total")
	@Expose
	private Integer total;
	@SerializedName("total_pages")
	@Expose
	private Integer totalPages;
	@SerializedName("data")
	@Expose
	private List<Datum> data;
	@SerializedName("support")
	@Expose
	private Support support;


	@Getter
	public class Support {

		@SerializedName("url")
		@Expose
		private String url;
		@SerializedName("text")
		@Expose
		private String text;
	}

	@Getter
	public class Datum {

		@SerializedName("id")
		@Expose
		private Integer id;
		@SerializedName("email")
		@Expose
		private String email;
		@SerializedName("first_name")
		@Expose
		private String firstName;
		@SerializedName("last_name")
		@Expose
		private String lastName;
		@SerializedName("avatar")
		@Expose
		private String avatar;
	}
}

