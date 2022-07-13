package pl.technique.stage.account.dto.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyPostDto extends AccountPostDto {
    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("nip")
    private String nip;

    @JsonProperty("address")
    private String address;

    @JsonProperty("description")
    private String description;

    @JsonProperty("logoUrl")
    private String logoUrl;
}
