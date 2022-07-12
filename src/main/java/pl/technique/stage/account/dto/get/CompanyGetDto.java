package pl.technique.stage.account.dto.get;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyGetDto extends AccountGetDto {
    private String companyName;
    private String nip;
    private String address;
    private String description;
    private String logoUrl;
}
