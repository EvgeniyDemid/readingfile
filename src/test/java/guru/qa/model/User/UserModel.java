package guru.qa.model.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
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

}
