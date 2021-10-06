package tapu.com.project.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlDTO {

    private String original_url;

    @ApiModelProperty(hidden = true)
    private String short_url;
}
