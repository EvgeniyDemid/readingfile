package guru.qa.model.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
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
