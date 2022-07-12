package pl.technique.stage.account.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyPostDto extends AccountPostDto {
    private String companyName;
    private String nip;
    private String address;
    private String description;
    private String logoUrl;
}
