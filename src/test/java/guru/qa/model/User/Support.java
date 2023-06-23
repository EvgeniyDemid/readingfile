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
public class Support {

	@SerializedName("url")
	@Expose
	private String url;
	@SerializedName("text")
	@Expose
	private String text;
}
